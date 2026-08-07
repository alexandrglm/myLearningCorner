# 03-003: Query / ASM Languages (High-Level - Low-Level)

### Language Level Classification

![](../../../../.gitbook/assets/03-003_IMG1.png)

Programming languages divide into **high-level** and **low-level** categories based on abstraction proximity to machine code.

* **High-level languages**: Sophisticated, English-like syntax facilitating code comprehension and rapid development. Examples include **query languages** (SQL), **structured programming** (Pascal), and **object-oriented languages** (Python).
* **Low-level languages**: Symbolic representations of machine code (binary: 0s, 1s). Examples include **assembly languages** (ARM, MIPS, X86).

***

### Query Languages: High-Level Database Communication

![](../../../../.gitbook/assets/03-003_IMG2.png) ![](../../../../.gitbook/assets/03-003_IMG3.png)

**Query languages** provide predefined, understandable instructions for database requests. They enable structured communication between user applications and databases, ensuring both parties use identical syntax and semantics.

![](../../../../.gitbook/assets/03-003_IMG4.png)

**Characteristics**:

* Predominantly request, create, read, update, or delete database data (**CRUD operations**)
* Utilise understandable commands and syntax
* Database management system-specific syntax requirements

**Common Query Languages**: **SQL** (most prevalent); **AQL**, **CQL**, **Datalog**, **DMX**.

**Database Types**:

* **SQL databases**: Relational with structured, predefined schemas
* **NoSQL databases** (Not Only SQL): Non-relational with dynamic schemas for unstructured data

**SQL Query Categories**:

* **SELECT queries**: Request data retrieval
* **Action queries**: Manipulate data (CREATE, INSERT, UPDATE, DELETE)
* **Administrative queries**: Create users, modify permissions

![](../../../../.gitbook/assets/03-003_IMG5.png) ![](../../../../.gitbook/assets/03-003_IMG6.png) ![](../../../../.gitbook/assets/03-003_IMG7.png)

***

### Assembly Languages: Low-Level Processor Communication

**Assembly languages** use simple symbolic representations (mnemonics) for machine code instructions, requiring assembler translation rather than compilation or interpretation.

![](../../../../.gitbook/assets/03-003_IMG8.png)

**Characteristics**:

* One-to-one mapping between statements and machine code instructions (unlike high-level languages producing multiple instructions)
* Processor architecture-specific; each CPU type typically has its own assembly language
* Line-by-line statement entry; one statement per line
* Readable symbolic format utilising mnemonics

**Assembly Statement Structure**:

```
[label:] instruction [operands] [; comments]
```

* **Label** (optional): Statement identifier
* **Instruction (mnemonic)**: Operation direction
* **Operands** (optional): Data location parameters
* **Comments** (optional): Explanatory notes

![](../../../../.gitbook/assets/03-003_IMG9.png)

**Common Mnemonics**: **INP** (Input), **OUT** (Output), **LDA** (Load), **STA** (Store), **ADD** (Add).

![](../../../../.gitbook/assets/03-003_IMG10.png) **Statement Components**:

* **Opcodes**: Processor directives specifying data operations
* **Operands**: Data location specifications ![](../../../../.gitbook/assets/03-003_IMG11.png)

***

## Lesson Speech

Welcome to **"Query and Assembly Programming Languages."** After this guide, you will be able to: **Compare high-level and low-level programming languages. Describe query languages, and describe assembly languages**.

Let's explore **query and assembly programming languages**. But first, we need to **categorise programming languages into two levels** – **high-level and low-level**.

A **high-level programming language** is **more sophisticated** and **uses the common English language** to **make its code more understandable** and to **increase the speed of coding and debugging programmes**. **Examples of high-level programming languages** include **query languages** such as **Structured Query Language (or SQL), structured programming languages** such as **Pascal, and object-oriented programming languages** such as **Python**.

In contrast, a **low-level programming language** uses a **set of symbols** to **represent machine code**. And **examples of low-level programming languages** include **assembly languages** such as **ARM, MIPS, and X86**.

A **query** is a **request for information from a database**. The **database** handles the **query** and **searches its tables** for the **information requested** and **returns the results** to the querying entity. When **querying a database**, it is important that **both the user application** making the query and the **database handling the query** are **speaking the same language**. In programming terms, **writing a query** means **using predefined and understandable instructions** to **make the request to a database**. This is achieved **using programmatic code** and **this is what we refer to as a query language**.

A **query language** may also be **referred to as a database query language**. **By far the most prevalent query language** for **database queries and database management** is **SQL**. However, there are **other query languages available** such as **AQL, CQL, Datalog, and DMX**.

In addition to **SQL databases**, there is **another type of database** called **NoSQL**, which stands for **Not Only SQL**. The **key difference between these two types of databases** is their **data structures**. **While SQL databases** are **relational** and **use structured, predefined, schemas**, **NoSQL databases** are **non-relational in nature** and **have dynamic schemas for unstructured data**.

A **query language** is **predominantly used** to **request data from a database** or to **create, read, update, and delete data in a database**. You will **likely see the term CRUD** used to refer to these **last four key database operations**.

Typically, a **user enters a command** to either **make a query** or **perform a CRUD operation** using **syntax that is understandable** to the **database management system** hosting the database. And a **database typically consists of structured tables** made up of **multiple rows and columns of data**. When a **user performs a query**, the **database retrieves the data** from the **relevant rows and columns** in the table and **arranges it into some sort of order**, ready to be **returned and presented** in the **query results**.

**Database queries** are either a **select command, or an action command**, such as **CREATE, INSERT, UPDATE, or a mixture of both**. The term **"statement"** is **more commonly used** to **describe these commands**. **Select queries** request **data from a database**, whereas **action queries manipulate data** in a database. **Query statements** can also be **used to perform other administrative functions** such as **creating users and modifying permissions**.

This table lists **some of the most common SQL query statements**. Here are **some simple syntax examples** of **common SQL statements**.

As mentioned earlier, **assembly languages** are **less sophisticated** than **query languages, structured programming languages, and object-oriented programming languages**. As an **assembly language** uses a **simple set of symbols** to **represent the 0s and 1s** of **machine code**, it is **categorised as a low-level programming language**.

**Assembly languages** are **closely tied to the processor architecture** from **hardware manufacturers** and therefore, **each CPU type** will **typically have its own assembly language**. For this reason, there are a **large number of assembly languages in use today**, which **vary among hardware manufacturers**.

**Assembly languages** use a **simple readable format** for their **statements**, and they are **entered one line at a time, with one statement per line**. **Assembly language statements** use the **standard format** shown here. In this syntax **all fields in curly brackets { }** are **optional**, and the **statement has two main parts**. The **first part** is the **instruction (or the mnemonic), and the second part** includes the **parameters (or the operands)**. There may also be **optional useful comments** added on the **end of the statement**.

One **other key difference** with **assembly languages** is that they are **translated using an assembler** instead of **a compiler or interpreter**, and **one statement translates into just one machine code instruction**, as opposed to **high-level languages** where **one statement can be translated** into **multiple machine code instructions**.

**Assemblers** translate **assembly language** into **machine code** using **mnemonics** such as **Input (INP), Output (OUT), Load (LDA), Store (STA), and Add (ADD)**. The **statements consist of opcodes** that **tell the processor what to do** with the **data**, and **operands** that **tell the processor where to find the data**.

In this guide, you learned that: **Query languages, structured programming languages, and object-oriented programming languages** are **categorised as high-level programming languages**. **Assembly languages** are **categorised as low-level programming languages**. A **query language** is **predominantly used** to **request data from a database** or to **manipulate data in a database**. The **most prevalent query language** for **database queries and database management** is **Structured Query Language (SQL)**. **Select queries** request **data from a database**, whereas **action queries manipulate data** in a database. You also learned that: **Assembly languages** use a **simple set of symbols** to **represent the 0s and 1s** of **machine code**. **Assembly languages** are **closely tied to the processor architecture** from **hardware manufacturers**. **Assembly languages** are **translated using an assembler** instead of **a compiler or interpreter**. And **assembly language instructions** have a **one-to-one association** with their **machine code counterpart**.
