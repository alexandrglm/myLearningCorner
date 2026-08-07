# Princeton Algorithms Course Java Environment Setup (Custom VENV Version)

# Java Environment Guide — Princeton Course (Adapted for Local VENV)

**Purpose.** This document reproduces and adapts the Princeton "Hello World in Java (Linux)" guide ([https://lift.cs.princeton.edu/java/linux/](https://lift.cs.princeton.edu/java/linux/)) to a non‑system‑wide environment (Temurin OpenJDK inside a project venv + IntelliJ IDEA Community).  

It preserves the original structure and intent but replaces system‑wide installation steps with instructions that keep everything inside a single folder.

---

## Table of contents

1. Install Java ( venv. adapted)
2. Install command‑line tools (algs4 and lift CLI) — local version
3. Install IntelliJ (adapted)
4. Open a project in IntelliJ
5. Create a program in IntelliJ (HelloWorld)
6. Compile and execute (IntelliJ)
7. Compile and execute (command line, inside venv)
8. Textbook libraries (`algs4` and `stdlib`) — local setup
9. Troubleshooting and verification
10. Useful links and resources

---

## 1. Install Java (adapted for non‑system‑wide venv)

**Original (Princeton):** install JDK 11 system‑wide.

**Our approach:** use a Temurin OpenJDK (17 or newer) installed inside the environment folder. The environment provides `JAVA_HOME` and `PATH` modifications only for the shell that sources the `activate` script.

### Why 17+?

* Recent IntelliJ releases and many course artefacts are compiled with Java 17 classfile version (61.0) or newer. Use **OpenJDK 17 or 21 (Temurin builds)**.

### How it works (summary)

* The environment folder contains `jdk/` (the JDK), `idea/` (the IDE), `bin/activate`, `run-idea`, and helper scripts.
* `source ./ENVNAME/bin/activate` will:

  * set `JAVA_HOME=./ENVNAME/jdk`
  * prepend `./ENVNAME/jdk/bin` to `PATH`
  * prefix your shell prompt with `(<ENVNAME>) `
  * provide a `deactivate` function to restore previous state

### Validation (after activation)

```bash
$ source ./my-java-env/bin/activate
$ which java
/path/to/your/project/my-java-env/jdk/bin/java
$ java --version
OpenJDK 21.x.y ... (Temurin)
```

---

## 2. Install command‑line tools (algs4 / lift CLI) — local variant

Princeton places helper tools into `/usr/local/lift` and wrapper scripts into `/usr/local/bin`. We instead place those under the environment folder so nothing is system‑wide.

### What we install locally

* `algs4.jar` (textbook libraries)
* `stdlib.jar` (introcs / drawing libraries where required)
* local wrapper scripts: `javac-introcs`, `java-introcs`, `javac-algs4`, `java-algs4` inside `ENVNAME/bin`

### Suggested layout

```
ENVNAME/
├── bin/           # activate, deactivate, run-idea, wrappers
├── jdk/
├── idea/
└── lib/
    ├── algs4.jar
    └── stdlib.jar
```

### Wrapper script example: `javac-algs4`

```bash
#!/usr/bin/env bash
# Location: ENVNAME/bin/javac-algs4
# Usage: javac-algs4 MyProgram.java
ENV_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export CLASSPATH="$ENV_ROOT/lib/algs4.jar:"
exec "$ENV_ROOT/jdk/bin/javac" -cp "$CLASSPATH" "$@"
```

`java-algs4` would be similar, calling the `java` binary with `-cp "$ENV_ROOT/lib/algs4.jar:."`.

### How to download the stable `algs4` and `stdlib`

* `algs4.jar` official: [https://algs4.cs.princeton.edu/code/algs4.jar](https://algs4.cs.princeton.edu/code/algs4.jar)
* `stdlib.jar` (introcs / stdlib): [https://introcs.cs.princeton.edu/java/stdlib/stdlib.jar](https://introcs.cs.princeton.edu/java/stdlib/stdlib.jar) (or the URL provided in the course materials)

Place both under `ENVNAME/lib/`.

---

## 3. Install IntelliJ (adapted)

**Original (Princeton):** download IntelliJ IDEA Community 2025.2 and install system‑wide. Also provide custom preferences to overwrite `~/.config/JetBrains/...`.

**Our approach:** download the IntelliJ tarball and extract it inside `ENVNAME/idea/`. Do **not** touch global JetBrains config directories. Optionally provide instructions for applying the Princeton preferences locally (if you want to import the settings).

### Steps (inside project folder)

1. Download the latest IntelliJ Community `.tar.gz` from JetBrains (the script automates this). Example API endpoint used by JetBrains:

   * `https://data.services.jetbrains.com/products/releases?code=IIC&latest=true&type=release`
2. Extract and rename the extracted folder to `idea/` (so `ENVNAME/idea/bin/idea.sh` exists).
3. Do **not** overwrite system JetBrains settings unless you explicitly want to.

### Launching IntelliJ from the environment

* `source ./ENVNAME/bin/activate`
* `./ENVNAME/run-idea`  (this sources the activate script and then execs `idea.sh`)

### Notes about IntelliJ JRE

* IntelliJ bundles a JetBrains JRE (JBR) inside the `idea/jbr/` folder. The launcher will prefer `IDEA_JDK`, then the bundled `jbr/`, then `JAVA_HOME`. Setting `IDEA_JDK` to the venv JDK ensures the IDE uses the environment's JDK.

---

## 4. Open a Project in IntelliJ (adapted)

Follow the Princeton instructions, but open the folder from inside the environment.

Steps (short):

1. `source ./ENVNAME/bin/activate`
2. `./ENVNAME/run-idea` or start IntelliJ via the desktop launcher created by the script
3. In IntelliJ: *Open* → select the project folder (e.g., the `hello` sample project)

**Important:** Do **not** use New Project. Use **Open** with the project folder.

**Set Platform SDK** (point IntelliJ to the env JDK)

* File → Project Structure → Platform Settings → SDKs → + → Add JDK
* Select `ENVNAME/jdk/` as the SDK path. IntelliJ will show the short name (e.g. 17)

![Opening a project in IntelliJ (placeholder)](https://lift.cs.princeton.edu/java/linux/images/intellij-welcome.png)

![Opening a project in IntelliJ (placeholder)](https://lift.cs.princeton.edu/java/linux/images/intellij-select-project.png)

![Opening a project in IntelliJ (placeholder)](https://lift.cs.princeton.edu/java/linux/images/intellij-hello.png)


---

## 5. Create a program in IntelliJ (HelloWorld)

Follow the Princeton flow but inside the project.

1. In Project View, select the package or folder where you want the class.
2. Use LIFT → New Java Class (project shortcut provided by course; otherwise: right click → New → Java Class)
3. Name the class `HelloWorld` and paste the code exactly:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}
```

![Creating a new Java class (placeholder)](https://lift.cs.princeton.edu/java/linux/images/intellij-welcome-hello.png)

![](https://lift.cs.princeton.edu/java/linux/images/intellij-project-folder.png)

- Select the menu option LIFT → New Java Class. When prompted, type HelloWorld for the Name, followed by Return.:
![](https://lift.cs.princeton.edu/java/linux/images/intellij-new-class.png)

Save and continue.

---

## 6. Compile and Execute the Program (from IntelliJ)

Use the course LIFT menu or the normal Build / Run menus.

Princeton suggests LIFT → Recompile 'HelloWorld.java' and LIFT → Run 'HelloWorld'. In our environment the same workflow applies. IntelliJ will use the Project SDK configured to `ENVNAME/jdk` so compilation should succeed.

![Compilation successful (placeholder)](https://lift.cs.princeton.edu/java/linux/images/intellij-new-class.png)

---

## 7. Compile and Execute the Program (from the command line, inside venv)

Open IntelliJ's embedded terminal or a separate terminal.

**Using the venv `javac` / `java`:** ensure you have activated the environment first.

```bash
$ source ./ENVNAME/bin/activate
$ cd hello
$ javac HelloWorld.java
$ java HelloWorld
Hello, World
```

**Using course wrappers (algs4 / stdlib)**

* Use the wrapper scripts provided in `ENVNAME/bin/` (see section 2). Example:

```
$ javac-algs4 Barnsley.java
$ java-algs4 Barnsley 10000
```

---

## 8. Textbook libraries (`algs4` and `stdlib`) — full local setup

Princeton expects `algs4.jar` and wrapper scripts; we replicate this locally.

### Download stable `algs4`

* `curl -L -o ENVNAME/lib/algs4.jar https://algs4.cs.princeton.edu/code/algs4.jar`
* `curl -L -o ENVNAME/lib/stdlib.jar <official-stdlib-url>`

### Create wrapper scripts (examples)

`ENVNAME/bin/javac-algs4`:

```bash
#!/usr/bin/env bash
ENV_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
CLASSPATH="$ENV_ROOT/lib/algs4.jar:"
exec "$ENV_ROOT/jdk/bin/javac" -cp "$CLASSPATH" "$@"
```

`ENVNAME/bin/java-algs4`:

```bash
#!/usr/bin/env bash
ENV_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
CLASSPATH="$ENV_ROOT/lib/algs4.jar:."
exec "$ENV_ROOT/jdk/bin/java" -cp "$CLASSPATH" "$@"
```

Make them executable: `chmod +x ENVNAME/bin/javac-algs4 ENVNAME/bin/java-algs4`.

**Usage**

```bash
$ source ./ENVNAME/bin/activate
$ javac-algs4 CollidingDisks.java
$ java-algs4 CollidingDisks
```

---

## 9. Troubleshooting and verification

**Problem:** `which java` still shows `/usr/bin/java` after activation.

**Fix:** run `hash -r` or start a fresh shell after activation. The activation script should also call `hash -r` automatically. If `which java` still shows the wrong path, ensure your `PATH` is correctly prefixed and that `JAVA_HOME` is set.

**Problem:** IntelliJ complains `UnsupportedClassVersionError`.

**Fix:** ensure your env JDK is ≥ Java 17. Recreate the environment with JDK 17+ and configure IntelliJ Project SDK to that JDK.

**Problem:** algs4 drawing windows do not show.

**Fix:** ensure DISPLAY is set (running under X11 or Wayland with XWayland). If running headless, GUI drawing will not appear.

---

## 10. Useful links and resources

* Princeton course guide (original): [https://lift.cs.princeton.edu/java/linux/](https://lift.cs.princeton.edu/java/linux/)
* Adoptium Temurin builds: [https://adoptium.net/](https://adoptium.net/)
* IntelliJ IDEA Community Edition: [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)
* algs4.jar (official): [https://algs4.cs.princeton.edu/code/algs4.jar](https://algs4.cs.princeton.edu/code/algs4.jar)
* Introcs / stdlib: [https://introcs.cs.princeton.edu/java/stdlib/](https://introcs.cs.princeton.edu/java/stdlib/)

---

## Appendix: Example HelloWorld workflow (concise)

1. Create env with script: `./create_java_venv.sh` → produces `ENVNAME/`.
2. Activate: `source ENVNAME/bin/activate`
3. Open IntelliJ: `./ENVNAME/run-idea`
4. Open `hello` project (File → Open)
5. Ensure Project SDK points to `ENVNAME/jdk` (File → Project Structure → SDKs)
6. Compile and run using IntelliJ or `javac` / `java` in a venv shell.

---

