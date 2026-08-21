# B01\_02\_Binary\_system

## B01 - Module 1, Theory

### B01\_02:    Binary system (Base 2)

Video class: [Youtube Link](https://youtu.be/ONMS354Xjz8)\
Materials used: [1.T02.introduccionAlBinario.pdf](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/1.T02.introduccionAlBinario.pdf)

***

**Content:**

* What binary system means for
* How memories work: Storing, fetching data processes.
* Dismembering the binary system.
* Counting on Base2 & Passing Base10 to Base2.
* Special use cases: Storing selecte data.

***

## ❇️ Binary system

* Binary is a base-2 number system: **0 and 1.**
* The foundation of the electronic and digital world relies on the binary system:
  * **1**: Signal is present (Electricuty flows).
  * **0**: Signal is not present (Elec. does not flow).

To control circuits and determine whether a signal passes or not, humanity developed an ingenious invention: **Transistors**.

* **The Transistor:**\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/01.PNG)

A transistor functions like a switch. By combining multiple transistors, a **flip-flop (bistable circuit)** is created, allowing data to be stored.\
This concept forms the foundation of CPUs, memory systems, and other digital components.

There are various types of transistors (e.g., **NPN, PNP**) that contribute to the formation of different **logic gates**.

Focusing on data processing, a transistor acts as a single **bit**. Depending on its configuration and how it is energized within the circuit, it outputs either a **1** or a **0**.

* **When energized, the state changes, allowing electricity to flow:**\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/02.png)
* **Even if the input stops flowing electricity, the bit retains its state:**\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/03.png)
* **If electricity is sent through the second input, the bit resets to 0, stopping the flow of electricity:**\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/04.png)

Now, imagine combining more than one BIT.

* Four combined BITs forms a NIBBLE:\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/05.png)
* And ... Eight combined BIT's forms ... a **Byte**!![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/06.png)

There are 256 (0\~255) possible status in a Byte.\
Therefore, we need to understand all of this kind of status (data stored) combination, and here comes **the Binary system**:

![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/07.png)

## ❇️ Converting from Decimal (Base 10) to Binary (Base 2)

* **Divide the decimal number by 2 and recording the rest at each step.**\
  ⚠️ Remainder = Rest. _Remainder_ is a more specific arithmetical term as the rest complies only at divisions.

**Steps:**

```
1. Divide the decimal number by 2.  
2. Write down the rest  
3. Update the quotient (the result of the division).  
4. Repeat the process with the new quotient, until the quotient is 0.  
5. The binary number is formed by reading the rest UPSIDE DOWN! (from bottom to the top).  
```

*   Example: _Converting 13 (decimal) to binary:_

    ```
    13 / 2 = 6, rest = 1  
    6 / 2 = 3, rest = 0  
    3 / 2 = 1, rest = 1  
    1 / 2 = 0, rest = 1
    ```

    Reading the remainders from bottom to top, the binary representation of our number is `1101`.

***

## ❇️ Converting from Binary (Base 2) to Decimal (Base 10)

**Steps:**

```
1. Write down the binary number, aligning each digit on its positional value.  
2. Multiply each binary digit (0 or 1) by its positional value.  
3. Add up all the resulting values to get the decimal equivalent.
```

* **10100110** to decimal:

| ^ 2 :        | 128   | 64    | 32    | 16    | 8     | 4     | 2     | 1     |
| ------------ | ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- |
| Binary digit | **1** | **0** | **1** | **0** | **0** | **1** | **1** | **0** |

**Adding these values together:**\
`128` + `(there's no 64, so 0)` + `32` + `(there's no 16, so 0)` + `(there's no 8, so 0)` 4 + 2 + `(there's no 1, so 0)` = **166**

The binary number **10100110** is equivalent to **166** in Base10.

***

## ❇️ Special number use cases

### How the Base 10 System Stores Data

The Base 10 (decimal) system represents numbers using **10 digits**: 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9.\
Each position in a number represents a power of 10 and ,as you add digits, the system is expanded by adding new decimal places.

This allows the system to store progressively larger values by grouping numbers into tens, hundreds, thousands, and beyond. Here's how it works:

```
1 to 9: The first group of single digits.  
10 to 99: The second group, adding a **new decimal place** for tens.  
100 to 999: The third group, expanding with another decimal place for hundreds.  
1000 to 9999: Adds a fourth decimal place for thousands.  
[...]  
1,000,000,000,000,000 to 9,999,999,999,999,999: Continues expanding as more decimal places are added.  
```

Each additional decimal place increases the range of numbers the system can represent, building on the power of tens:

* **10⁰ = 1** (units place)
* **10¹ = 10** (tens place)
* **10² = 100** (hundreds place), and so on.

♾️ This incremental approaching process can continue infinitely giving a huge lenght numbers, as this is the foundation of Base10 system.

Now, just imagine a building that needs to number each room.\
A logical way to determine which floor a particular room is on would be, avoiding

* The **first digit on the left** as the floor number.
* The remaining digits as the room number on this floor.

Example:

* **107:** Room 7 on the **First** floor.
* **923:** Room 23 on the **Ninth** floor.\
  ![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/08.png)

### How Base2 stores data:

Imagine a Byte, composed of 8 bits, where each bit has its own state (either **0** or **1**) and can represent data. Let’s use the following example on how a single Byte can encode multiple pieces of information for managing a sprite in a game or application.![image](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/09.png)

The Byte **01011011** can be interpreted as follows:

* **First bit (0):** Determines the sprite used.
* **Bits 2-4 (101):** Represents a time counter in binary, with a maximum value of **Base 2 (111)** or **7 seconds**.
* **Bits 5-6 (10):** Specifies the colors used for the sprite.
* **Last two bits (11):** Indicates a life counter for the sprite, with a maximum value of **Base 2 (11)** or **3 lives**.
