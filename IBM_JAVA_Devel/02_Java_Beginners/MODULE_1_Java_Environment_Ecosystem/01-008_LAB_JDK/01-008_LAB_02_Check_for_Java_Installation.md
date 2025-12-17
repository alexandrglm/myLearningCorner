# 01-008 Lab 02 - Check for Java Installation

To compile and run a Java program, Java should be installed in the system. In the Cloud IDE, Java has been pre-installed for you. For your further practice after completion of the course, it is highly recommended that you install JDK in your system. The guide to installation is covered in a later part of the lab.

## Steps

### 1. Open a New Terminal

Click on **Terminal** on the Cloud IDE menu and choose **New Terminal** to open a new terminal.

![](01-008_IMG1.jpg)

### 2. Terminal Ready

You will see the new terminal as shown in the image, ready to take your commands.

![](../../../../.gitbook/assets/01-008_IMG2.jpg)

### 3. Check the Java Version

Check the version of Java that has been provided in the Cloud IDE:

```bash
java --version
```

You should see an output such as:

```bash
java --version
java 21.0.5 2024-10-15 LTS
Java(TM) SE Runtime Environment (build 21.0.5+9-LTS-239)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.5+9-LTS-239, mixed mode, sharing)
```

### 4. Check JAVA\_HOME (Recommended)

The `JAVA_HOME` environment variable points to the installation directory of the Java Development Kit (JDK). Many applications, IDEs (Integrated Development Environments), and build tools rely on this variable to locate the Java runtime environment (JRE) and development tools.

```bash
echo $JAVA_HOME
```

You should see an output such as:

```bash
/usr/lib/jvm/jdk-21.0.5-oracle-x64
```
