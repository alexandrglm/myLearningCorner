# Module 03 - 119: Python - Guide to Pipenv for Managing a Python Project's Packages and Environment

In this guide, we're going to walk through the **Pipenv library**, a very powerful tool that allows us to manage the packages we bring into our projects.

One of the reasons why [Pipenv](https://pypi.org/project/pipenv/) has become incredibly popular—and why it's actually recommended by the official Python developers—is because it allows you to wrap your entire project's dependencies into a **single environment**. This is a very powerful tool, and I'm going to walk through why right now.

***

## Why Use Pipenv?

I'm going to create a directory, and I'm not going to actually write any Python code into it yet because I first want to show you the reason why it's important to have a **package manager** for your projects.

So, I'm going to say:

```bash
mkdir python-env
cd python-env
```

I'm just going to create a text file here so we can walk through it. I'll call it `dependency_issues.txt`. Inside of here, let's imagine a scenario where you have **Python 3.6.3** installed, and you build one project—it could be a **machine learning project**. Inside of it, you brought the **requests library**, and let's say they're at version **1.2**.

Later on, you build another Python program—a **Django web API**. You also needed the **requests library** for that project, but this one required a different version, say **2.0**.

That may not seem like an issue, but then all of a sudden, when you go back to your machine learning program that was working with **requests 1.2**, you're going to discover that something broke. Now, this project doesn't even work anymore. What you've run into is a **dependency conflict**. Both projects are using Python 3.6.3, but they're using two different versions of the **requests library**. When you updated it for your API, you inadvertently broke the machine learning project.

This is why we need tools like **Pipenv**. Pipenv will create a **virtual environment** for each project, isolating their dependencies. So, when you install **requests 1.2** for the machine learning project, it will be nested inside its own virtual environment.

When you install **requests 2.0** for the Django web API, it will be in a completely separate virtual environment.

This way, the two projects won't interfere with each other.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image11.png)

***

## Installing Pipenv

You can go to [docs.pipenv.org](https://docs.pipenv.org/) to find installation instructions depending on your system.

* **Mac (with Homebrew):**`brew install pipenv`
*   **Ubuntu/Linux:**

    ```bash
    sudo apt install software-properties-common python-software-properties
    sudo add-apt-repository ppa:pypa/ppa
    sudo apt update
    sudo apt install pipenv
    `
    ```
* **Windows:**\
  pip install pipenv

Pipenv is a **first-class citizen** on Windows, so you can use it just as easily as on other platforms.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image13.png)

***

## Setting Up a Pipenv Environment

Once Pipenv is installed, you can set up a new environment for your project. First, navigate to your project directory:

```bash
cd python-env
```

Then, initialize a new Pipenv environment for a Python 3 project:

```bash
pipenv --three
```

This will create a new **virtual environment** for your project. Pipenv will automatically detect the Python version you have installed and create the environment accordingly.

After running this command, Pipenv will generate a **Pipfile** in your project directory. This file will manage all your project's dependencies.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image14.png)

***

## Understanding the Pipfile

The **Pipfile** is where you list all the packages your project depends on. Here’s what a basic Pipfile looks like:

```toml
[[source]]
url = "https://pypi.org/simple"
verify_ssl = true
name = "pypi"

[packages]

[dev-packages]

[requires]
python_version = "3.6"
```

* **Packages:** This is where you list the packages your project needs to run.
* **Dev-packages:** These are packages you only need for development, such as testing or linting tools.
* **Requires:** This specifies the Python version your project requires.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image15.png)

***

## Installing Packages with Pipenv

To install a package, you use the `pipenv install` command. For example, to install **numpy**, you would run:

```bash
pipenv install numpy
```

This will install **numpy** and add it to your **Pipfile**. It will also generate a **Pipfile.lock**, which locks the exact versions of all dependencies, ensuring your project remains consistent.

You can also install multiple packages at once:

```bash
pipenv install requests flask
```

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image17.png)

***

## Working with the Virtual Environment

To activate the virtual environment, run:

```bash
pipenv shell
```

This will start a new shell session with the virtual environment activated. You can verify this by running:

```bash
which python
```

This should point to the Python executable inside your virtual environment, not your system's Python.

Once inside the virtual environment, you can run Python scripts and import the installed packages without any issues.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Environment+and+Version+Management/Guide+to+Pipenv+for+Managing+a+Python+Project's+Packages+and+Environment+%23+1564/image20.png)

***

## Summary

Pipenv is a powerful tool for managing **Python project dependencies** and **virtual environments**. It helps you avoid dependency conflicts by isolating each project's dependencies. By using Pipenv, you can ensure that your projects remain consistent and reproducible across different environments.

To recap:

* Use `pipenv --three` to create a new Python 3 environment.
* Use `pipenv install <package>` to install packages.
* Use `pipenv shell` to activate the virtual environment.

By following these steps, you can manage your Python projects more effectively and avoid common dependency issues.
