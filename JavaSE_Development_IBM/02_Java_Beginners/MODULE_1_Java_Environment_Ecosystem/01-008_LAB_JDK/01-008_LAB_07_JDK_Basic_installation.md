# Lab 07 - JDK Basic Installation

## Download JDK

Go to https://www.oracle.com/au/java/technologies/downloads/ to find the latest JDK downloads. At the time of creating this lab, the latest is version 23. From March 2025, it will be superseded by version 24.

Choose the operating system of your computer and select the installable that is appropriate to your system.

Follow the JDK installation instructions provided in that link.

## Verify Installation

Once you complete the installation, open the Command Prompt and follow the steps below depending on which OS you are using.

### Windows

1. Click on the Windows button on the keyboard and type `cmd` and press Enter.
2. When the command prompt opens, type `java -version` to see if Java has been installed and ensure the right version is displayed.

### macOS

1. Press Command and Space Bar and type Terminal in the spotlight.
2. In the terminal, type `java -version`. If the installation has been done successfully, you will see the Java version displayed.

## Set JAVA_HOME Environment Variable

Set the `JAVA_HOME` environment variable to point to the JDK installation directory.

### Windows

1. Right click on the Windows key on the keyboard and choose **Settings**.
2. In the settings window, search for **Environment Variables**. You will see the option to **Edit environment variables for your account**. Choose that option, especially if you are using a work PC or more than one user uses the PC where it is being installed.
3. Under **User Variables**, click on the **New** button.
4. In the **Variable name** field, enter `JAVA_HOME`.
5. In the **Variable value** field, enter the path to your JDK installation directory (e.g., `C:\Program Files\Java\jdk-23`). Please ensure that the path you set matches the installation location on your system.
6. Click **OK** to close all the windows.

### macOS (via Terminal)

1. Open the Terminal application.
2. Run the command:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
```

Please ensure that the path you set matches the installation location on your system. This will set the `JAVA_HOME` for that Terminal instance only for as long as the terminal is open.

If you want to permanently set `JAVA_HOME`, search and open the `.bashrc` file and add the following statement:

```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-23.jdk/Contents/Home
```

Please ensure that the path you set matches the installation location on your system.

### Linux (via Terminal)

1. Open the Terminal application.
2. Run the command:

```bash
export JAVA_HOME=/usr/lib/jvm/java-23-openjdk-amd64
```

Please ensure that the path you set matches the installation location on your system.

## Create and Run a Java Program

You are now ready to create and run Java programs on your system.
