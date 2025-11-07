# Programming Assignment 0: Hello, World 

## Overview

This assignment ensures that you can write simple Java programs, use the `algs4` library, and submit your work to the autograder.

## Step 1: Compile and Run HelloWorld

Example:

```bash
~/Desktop/hello> javac HelloWorld.java

~/Desktop/hello> java HelloWorld
Hello, World
```

Output:

```
Hello, World
```

## Step 2: Command-Line Arguments

Write `HelloGoodbye.java` which takes **two names** as command-line arguments.  

Example:  

```bash
~/Desktop/hello> javac HelloGoodbye.java

~/Desktop/hello> java HelloGoodbye Kevin Bob
Hello Kevin and Bob.
Goodbye Bob and Kevin.

~/Desktop/hello> java HelloGoodbye Alejandra Bahati


```

Output:

```
Hello Kevin and Bob.
Goodbye Bob and Kevin.
```

## Step 3: Using `algs4.jar` for RandomWord

Write `RandomWord.java` that reads words from standard input and prints **one at random** using the reservoir sampling approach.  

Example:  

```bash
~/Desktop/hello> javac-algs4 RandomWord.java

~/Desktop/hello> java-algs4 RandomWord
heads tails
tails

~/Desktop/hello> java-algs4 RandomWord
heads tails
heads

~/Desktop/hello> more animals8.txt
ant bear cat dog
emu fox goat horse

~/Desktop/hello> java-algs4 RandomWord < animals8.txt
emu

~/Desktop/hello> java-algs4 RandomWord < animals8.txt
bear
```

Possible output:

```
emu
```
---

### Required `algs4` imports
[Link](https://algs4.cs.princeton.edu/code/algs4.jar)

Use the following library functions from `algs4.jar`:  

*   [StdIn.readString()]https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdIn.html#readString--): reads and returns the next string from standard input.

*   [StdIn.isEmpty()](https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdIn.html#isEmpty--): returns `true` if there are no more strings available on standard input, and `false` otherwise.

*   [StdOut.println()](https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdOut.html#println--): prints a string and terminating newline to standard output. It’s also fine to use `System.out.println()` instead.

*   [StdRandom.bernoulli(p)](https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html#bernoulli-double-): returns `true` with probability *p* and `false`with probability `1 - p` and false with probability 1−p. 


In order to access these library functions, you must do the following two things:  

* Add algs4.jar to the Java classpath. This typically requires a different mechanism from the command line and the IDE:
    -   If you used our autoinstaller, the Bash commands javac-algs4 and java-algs4 add algs4.jar to the Java classpath.
    -   If you use IntelliJ, the supplied IntelliJ project folder includes algs4.jar and adds it to the Java classpath.
    -   If you prefer to use some other shell (such as Powershell or zsh) or IDE (such as Eclipse or Netbeans), that’s fine—just be sure that you can configure it accordingly. 


*   Add an import statement like the following at the top of your program:
```java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
```

If you use IntelliJ and the provided project folder, IntelliJ will automatically add and remove import statements as needed, so you won’t need to type them. 

---

## Submission

Submit a ZIP containing exactly:

* `HelloWorld.java`
* `HelloGoodbye.java`
* `RandomWord.java`

Do not include any other files.

## Reference

Full assignment: [https://coursera.cs.princeton.edu/algs4/assignments/hello/specification.php](https://coursera.cs.princeton.edu/algs4/assignments/hello/specification.php)
