# IDE - Framework

## Original IDE proposed:
-  Link:    https://lift.cs.princeton.edu/java/linux/
-  Java SE Development Kit 11 (JDK 11). 


## Local Java Development Environment (Isolated, Non-System-Wide)

This setup isolates both the **JDK** and **IDE** within a self-contained environment folder, preventing modifications to the system-wide Java installation.

---

## Overview

A **local development environment** ensures:

- **System integrity**: No alterations to system-wide `/usr/bin/java` or global `$JAVA_HOME`
- **Project isolation**: Environment-specific Java version and IDE instance
- **Easy activation/deactivation**: Shell-specific PATH and environment variable management
- **Clean state restoration**: Deactivation restores previous shell configuration completely

---

## Components

| Component | Specification |
|-----------|----------------|
| **JDK** | **OpenJDK 17+** (Temurin builds, Eclipse Adoptium) |
| **IDE** | **IntelliJ IDEA Community Edition** (latest version, x64) |

### JDK Selection: OpenJDK 17+ Temurin

**Why Temurin?**

- **Free and open-source**: Community-supported, no licensing concerns
- **Long-term support (LTS)**: Stable releases with extended maintenance
- **Cross-platform**: Identical builds across Windows, macOS, Linux
- **Performance**: High-quality reference implementation

### IDE Selection: IntelliJ IDEA Community Edition

**Why IntelliJ IDEA Community?**

- **Comprehensive Java support**: Full language features, refactoring tools, debugging
- **Free**: Community Edition includes professional-grade development features
- **Productivity**: Advanced code completion, analysers, integrated version control
- **Ecosystem**: Native Maven/Gradle support, extensive plugin marketplace
- **Learning-friendly**: Clear error messages, intelligent suggestions

---

## Environment Behaviour

### Activation Features

#### Activating the environment

- **Adjusts `PATH`**: Prioritises JDK binaries from the environment folder
- **Sets `JAVA_HOME`**: Points to the isolated JDK installation
- **Preserves system state**: System Java installation remains unchanged
- **Visual indicator**: Shell prompt prefixed with environment name (e.g., `(my-java-env) user@host:~/project$`)
- **Session-scoped**: Changes apply only to the current shell session



### Deactivation Features

#### Deactivating the environment:

- **Restores `PATH`**: Returns to previous shell configuration
- **Clears `JAVA_HOME`**: Restores previous environment variable state
- **Clean exit**: No residual environment pollution
- **Prompt restoration**: Shell prompt returns to normal

---

## Setup Process

### Prerequisites

- **Bash shell** (or compatible shell: zsh, ksh)
- **Internet connection** (to download JDK and IDE)
- **Disk space**: ~2–3 GB for JDK + IDE installation
- **Write permissions**: In your project directory (**no root required**)

### Installation Script

**Reference**: Easy Env Setup Script  
https://github.com/alexandrglm/easyenv/blob/41aa17af1cd44ab170d32ce51e8d1414ade5b591/JavaSE_openSDKs/VENV_JDK_temurin_IntelliJ-IIDEA_latest_x64.sh


### **Steps**:

1. **Download the setup script** to your project directory:
   ```bash
   curl -O https://raw.githubusercontent.com/alexandrglm/easyenv/41aa17af1cd44ab170d32ce51e8d1414ade5b591/JavaSE_openSDKs/VENV_JDK_temurin_IntelliJ-IIDEA_latest_x64.sh
   ```

2. **Make the script executable**:
   ```bash
   chmod +x VENV_JDK_temurin_IntelliJ-IIDEA_latest_x64.sh
   ```

3. **Execute the setup script**:
   ```bash
   ./VENV_JDK_temurin_IntelliJ-IIDEA_latest_x64.sh
   ```

The script automatically:
- Downloads OpenJDK 17+ Temurin
- Downloads IntelliJ IDEA Community Edition
- Extracts both into an isolated environment folder
- Creates activation/deactivation scripts

---

## Usage

### Activate Environment

Open a terminal in your project directory and run:

```bash
source ./<env-name>/bin/activate
```

**Example**:
```bash
source ./java-dev-env/bin/activate
```

**Result**: Shell prompt changes to `(java-dev-env) user@host:~/project$`

### Launch IntelliJ IDEA

With the environment activated, start the IDE:

```bash
./<env-name>/run-idea
```

**Example**:
```bash
./java-dev-env/run-idea
```

**First launch**: IntelliJ may require initial configuration (theme, plugins, project settings). This occurs once.

### Deactivate Environment

When finished, restore the previous shell state:

```bash
source ./<env-name>/bin/deactivate
```

**Example**:
```bash
source ./java-dev-env/bin/deactivate
```

**Result**: Shell prompt returns to normal; `JAVA_HOME` and `PATH` are restored.

---

## Workflow Example

```bash
# 1. Navigate to project directory
cd ~/my-algorithms-project

# 2. Set up environment (one-time)
./VENV_JDK_temurin_IntelliJ-IIDEA_latest_x64.sh

# 3. Activate environment for this session
source ./java-dev-env/bin/activate

# 4. Launch IDE
./java-dev-env/run-idea

# [Work in IntelliJ, write code, run programmes]

# 5. When done, deactivate environment
source ./java-dev-env/bin/deactivate
```

---

## Verification

### Verify JDK Installation

With environment activated:

```bash
java -version
javac -version
```

**Expected output**:
```
openjdk version "17.x.x" (or higher)
OpenJDK Runtime Environment (build 17.x.x+...)
```

### Verify IDE Launch

```bash
./<env-name>/run-idea
```

IntelliJ IDEA window should open within seconds.

---
