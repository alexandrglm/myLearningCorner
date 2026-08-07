#!/usr/bin/env bash


clear
echo "========================================================="
echo "          @alexandrglm/easyenv - v1.2"
echo ""
echo "  OpenJDK (Temurin builds) + IntelliJ IDEA"
echo "========================================================="

set -euo pipefail

echo ""
echo "=== Java Virtual Environment Creator (IntelliJ + OpenJDK) ==="
echo ""

read -rp "Enter a name for the environment folder (e.g. my-java-env): " ENV_NAME
if [ -z "$ENV_NAME" ]; then
  echo "No name provided. Aborting."
  exit 1
fi

ROOT_DIR="$(pwd)"
ENV_DIR="$ROOT_DIR/$ENV_NAME"

mkdir -p "$ENV_DIR"
cd "$ENV_DIR"

mkdir -p jdk idea bin



# --- Fetch available OpenJDK versions ---

echo ""
echo "Fetching available OpenJDK versions..."
JSON=$(curl -s https://api.adoptium.net/v3/info/available_releases)

if command -v jq >/dev/null 2>&1; then
  VERSIONS=$(echo "$JSON" | jq -r '.available_releases[]' | sort -nr)
else
  VERSIONS=$(echo "$JSON" \
    | awk -v RS="[" -v FS="]" '/available_releases/ {print $1}' \
    | awk -F: '{print $2}' \
    | tr -d ' ' \
    | tr ',' '\n' \
    | sort -nr)
fi

echo "Available Java versions:"
i=1
declare -A INDEXED

for v in $VERSIONS; do
  echo "  $i) $v"
  INDEXED[$i]=$v
  i=$((i+1))
done

read -rp "Select version by index (e.g. 5): " IDX

if [ -z "${INDEXED[$IDX]:-}" ]; then
  echo "Invalid selection. Aborting."
  exit 1
fi


JDK_VER="${INDEXED[$IDX]}"
echo "Chosen JDK version: $JDK_VER"



# --- Choose source ---
echo ""
echo "Choose JDK source:"
echo "  1) Prebuilt Temurin Binary (recommended)"
echo "  2) Build OpenJDK from source (requires toolchain, long compile time)"
echo ""

read -rp "Selection [1/2]: " JDK_SRC

# --- Download Temurin robustly ---
if [ "$JDK_SRC" = "1" ]; then

  echo ""
  echo "Downloading Temurin JDK $JDK_VER..."

  ARCH_RAW=$(uname -m)

  case "$ARCH_RAW" in
    x86_64|amd64) ARCH="x64" ;;
    aarch64|arm64) ARCH="aarch64" ;;
    *) echo "Unsupported architecture: $ARCH_RAW"; exit 1 ;;
  esac

  API_URL="https://api.adoptium.net/v3/assets/latest/${JDK_VER}/hotspot?architecture=${ARCH}&os=linux&image_type=jdk"

  echo "Querying API: $API_URL"


  ASSETS_JSON=$(curl -sL "$API_URL")


  if command -v jq >/dev/null 2>&1; then

    BINARY_URL=$(echo "$ASSETS_JSON" | jq -r '.[0].binary.package.link // .[0].binary.package[0].link // .[0].binary.link // empty')

  else

    BINARY_URL=$(python3 - <<PY - "$ASSETS_JSON"
import sys, json
s=sys.argv[1]
j=json.loads(s or "[]")
if not j:
    print("")
    sys.exit(0)
o=j[0].get("binary",{})
link = ""
pkg = o.get("package")
if isinstance(pkg, dict):
    link = pkg.get("link","")
elif isinstance(pkg, list) and pkg:
    link = pkg[0].get("link","")
link = link or o.get("package",{}).get("link","") or o.get("link","") or ""
print(link)
PY
"$ASSETS_JSON")
  fi

  if [ -z "$BINARY_URL" ]; then

    echo "Could not obtain binary URL from Adoptium API. Trying web fallback..."

    WEBPAGE="https://adoptium.net/download?link=&variant=openjdk&version=${JDK_VER}&os=linux&architecture=${ARCH}"
    BINARY_URL=$(curl -sL "$WEBPAGE" | grep -o 'https://[^"]\+\.tar\.gz' | head -n1 || true)

  fi

  if [ -z "$BINARY_URL" ]; then
    echo "Failed to find a download URL for JDK ${JDK_VER}. Aborting."
    exit 1
  fi

  echo "Downloading from: $BINARY_URL"

  curl -L -H "Accept: application/octet-stream" "$BINARY_URL" -o jdk.tar.gz

  if ! file jdk.tar.gz | grep -q -E 'gzip|tar'; then
    echo "Downloaded file is not a tar archive. Removing and aborting."
    rm -f jdk.tar.gz
    exit 1
  fi


  echo "Extracting JDK..."
  mkdir -p jdk
  tar -xf jdk.tar.gz --strip-components=1 -C jdk
  rm -f jdk.tar.gz
  echo "JDK installed in ./jdk"


else

  echo "Build from source selected. This requires build tools (gcc, make, autoconf, python, etc)."

  if ! command -v gcc >/dev/null 2>&1 || ! command -v make >/dev/null 2>&1; then
    echo "Toolchain not present. Aborting."
    exit 1
  fi

  git clone https://github.com/openjdk/jdk.git openjdk-src

  cd openjdk-src

  git checkout "jdk-$JDK_VER" || true

  bash configure --prefix="$ENV_DIR/jdk"

  make images

  make install

  cd "$ENV_DIR"

fi


# --- Download IntelliJ Community (latest) ---

echo ""
echo "Downloading IntelliJ IDEA Community..."

API="https://data.services.jetbrains.com/products/releases?code=IIC&latest=true&type=release"
URL=$(curl -s "$API" | grep -o 'https://[^"]\+ideaIC[^"]\+\.tar\.gz' | head -n1 || true)

if [ -z "$URL" ]; then

  echo "Could not obtain IntelliJ download link. Aborting."
  exit 1
fi

echo "Downloading: $URL"

curl -L "$URL" -o idea.tar.gz

echo "Extracting IntelliJ..."

tar -xf idea.tar.gz

EXTRACTED_DIR=$(find . -maxdepth 1 -type d -name "idea-IC-*" | head -n1 || true)

if [ -z "$EXTRACTED_DIR" ]; then
  echo "IntelliJ extracted but folder not found. Please inspect the archive."
  exit 1
fi

rm -rf idea
mv "$EXTRACTED_DIR" idea
rm -f idea.tar.gz

echo "IntelliJ installed in ./idea"

# --- Create bin/activate (single robust activate) ---

cat > bin/activate <<'ACTIVEOF'
#!/usr/bin/env bash

# Resolve environment root
ENV_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
ENV_NAME="$(basename "$ENV_ROOT")"

# Save old vars
if [ -z "${_JAVA_VENV_OLD_PATH+x}" ]; then
  export _JAVA_VENV_OLD_PATH="$PATH"
fi
if [ -z "${_JAVA_VENV_OLD_PS1+x}" ]; then
  export _JAVA_VENV_OLD_PS1="${PS1-}"
fi

export JAVA_HOME="$ENV_ROOT/jdk"
export IDEA_JDK="$JAVA_HOME"

# Prepend java bin to PATH if not already present
case ":$PATH:" in
  *":$JAVA_HOME/bin:"*) ;;
  *) export PATH="$JAVA_HOME/bin:$PATH" ;;
esac

# Update shell command hash so 'which' sees new java
if command -v hash >/dev/null 2>&1; then
  hash -r
fi

# Add all jars inside libraries-modules-env to CLASSPATH
LIB_DIR="$ENV_ROOT/libraries-modules-env"

if [ -d "$LIB_DIR" ]; then

  export CLASSPATH=".:$LIB_DIR/*:${CLASSPATH-}"
fi

# Prompt prefix (do not overwrite PS1, just prefix)
if [ -n "${PS1-}" ]; then
  PS1="($ENV_NAME) ${PS1}"
fi

echo "Java environment activated: $ENV_NAME"
ACTIVEOF

chmod +x bin/activate


# --- Deactrivate wrapper ---

cat > bin/deactivate <<'DEACTEOF'
#!/usr/bin/env bash

if command -v deactivate >/dev/null 2>&1; then
  deactivate
  exit 0
fi

if [ -n "${_JAVA_VENV_OLD_PATH-}" ]; then
  export PATH="$_JAVA_VENV_OLD_PATH"
  unset _JAVA_VENV_OLD_PATH
fi

if [ -n "${_JAVA_VENV_OLD_PS1-}" ]; then
  PS1="$_JAVA_VENV_OLD_PS1"
  unset _JAVA_VENV_OLD_PS1
fi

unset JAVA_HOME
unset IDEA_JDK

if command -v hash >/dev/null 2>&1; then
  hash -r
fi

echo "Java environment deactivated (fallback)."
DEACTEOF
chmod +x bin/deactivate

# --- run-idea launcher (auto-detects idea bin) ---
cat > run-idea <<'RUNEOF'
#!/usr/bin/env bash
set -e
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

# Activate environment (sourcing creates deactivate function within the shell)
# Use dot-sourcing so that deactivate remains available in interactive shells

. "$SCRIPT_DIR/bin/activate"

# locate idea.sh

IDE_SH="$SCRIPT_DIR/idea/bin/idea.sh"

if [ ! -x "$IDE_SH" ]; then

  # fallback: find any idea.sh under idea/
  IDE_SH=$(find "$SCRIPT_DIR/idea" -type f -name "idea.sh" | head -n1 || true)
fi

if [ -z "$IDE_SH" ] || [ ! -x "$IDE_SH" ]; then

  echo "Cannot find idea.sh under $SCRIPT_DIR/idea. Aborting."
  exit 1

fi

# Exec the IDE (this replaces the current shell)
exec "$IDE_SH"
RUNEOF

chmod +x run-idea



# --- KDE .desktop launcher ---
cat > intellij-venv.desktop <<DESK
[Desktop Entry]
Type=Application
Name=IntelliJ (Java Venv: $ENV_NAME)
Exec=konsole -e bash -lc 'cd "$ENV_DIR" && source "$ENV_DIR/bin/activate" && "$ENV_DIR/run-idea"'
Terminal=false
DESK


# --- Finals ---
echo ""
echo "=== Installation Complete ==="
echo ""
echo "To use this environment (in this terminal):"
echo "  source $ENV_NAME/bin/activate"
echo ""
echo "To start IntelliJ from this folder:"
echo "  ./$ENV_NAME/run-idea"
echo ""
echo "If you prefer a separate shell with venv active:"
echo "  konsole -e bash -lc 'cd \"$ENV_NAME\" && source bin/activate && bash --login'"
echo ""
echo "To deactivate (after sourcing activate):"
echo "  source $ENV_NAME/bin/deactivate  (fallback script)"
echo ""
echo "KDE launcher created:"
echo "  $ENV_NAME/intellij-venv.desktop"
echo ""
echo "========================================="
