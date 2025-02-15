# B1_02: Binary system (Base 2).
Video class: [Youtube Link](https://youtu.be/ONMS354Xjz8)  
Materials used: [1.T02.introduccionAlBinario.pdf](https://github.com/alexandrglm/elearning_tools/blob/9e0eecc5523a81b341b0fbb4c84fc4fcf39c6a2d/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T02.introduccionAlBinario.pdf)    
***

#### Content:  
- What binary system means for  
- How memories work: Storing, fetching data processes.  
- Dismembering the binary system. 
- Counting on Base2 & Passing Base10 to Base2. 
- Special use cases: Storing selecte data.  
***

#  ❇️ Binary system
  
- Binary is a base-2 number system: **0 and 1.**
- The foundation of the electronic and digital world relies on the binary system:
  - **1**:  Signal is present (Electricuty flows).
  - **0**:  Signal is not present (Elec. does not flow).

To control circuits and determine whether a signal passes or not, humanity developed an ingenious invention: **Transistors**.  

These are made of metal-based materials called **semiconductors**, whose main characteristic is enabling or disabling the flow of signals based on their level of energization.  

- **The Transistor:**  
  ![image](https://github.com/user-attachments/assets/55cdb9f5-a68c-4f99-b6ae-657dedcc2532)

A transistor functions like a switch. By combining multiple transistors, a **flip-flop (bistable circuit)** is created, allowing data to be stored.  
This concept forms the foundation of CPUs, memory systems, and other digital components.

There are various types of transistors (e.g., **NPN, PNP**) that contribute to the formation of different **logic gates**.  

Focusing on data processing, a transistor acts as a single **bit**. Depending on its configuration and how it is energized within the circuit, it outputs either a **1** or a **0**.  

- **When energized, the state changes, allowing electricity to flow:**  
  ![image](https://github.com/user-attachments/assets/dbb0f353-91e7-41b6-8c39-2aa952669fb6)

- **Even if the input stops flowing electricity, the bit retains its state:**  
  ![image](https://github.com/user-attachments/assets/9b75aed0-16a7-4c9b-8330-d9e619ee9229)

- **If electricity is sent through the second input, the bit resets to **0**, stopping the flow of electricity:**  
  ![image](https://github.com/user-attachments/assets/588297b3-6a63-43a7-b612-cc62970435e0)

Now, imagine combining more than one BIT.  
- Four combined BITs forms a NIBBLE:  
  ![image](https://github.com/user-attachments/assets/a3f95f85-0d38-4182-8236-248a8a1523ce)

- And ... Eight combined BIT's forms ... a **Byte**!
  ![image](https://github.com/user-attachments/assets/f16d37dc-898e-48c6-b7fd-c265b47aa845)

There are 256 (0~255) possible status in a Byte.
Therefore, we need to understand all of this kind of status (data stored) combination, and here comes **the Binary system**:  

![image](https://github.com/user-attachments/assets/0948887d-0349-402e-9f8b-2f2bbe9e053b)

***


#  ❇️ Converting from Decimal (Base 10) to Binary (Base 2)

- **Divide the decimal number by 2 and recording the rest at each step.**  
⚠️ Remainder = Rest. *Remainder* is a more specific arithmetical term as the rest complies only at divisions.

#### Steps:  
    1. Divide the decimal number by 2.  
    2. Write down the rest  
    3. Update the quotient (the result of the division).  
    4. Repeat the process with the new quotient, until the quotient is 0.  
    5. The binary number is formed by reading the rest UPSIDE DOWN! (from bottom to the top).  

- Example: *Converting 13 (decimal) to binary:*  
```text  
13 / 2 = 6, rest = 1  
6 / 2 = 3, rest = 0  
3 / 2 = 1, rest = 1  
1 / 2 = 0, rest = 1
```
Reading the remainders from bottom to top, the binary representation of our number is `1101`.  
***
#  ❇️ Converting from Binary (Base 2) to Decimal (Base 10)
#### Steps:  
    1. Write down the binary number, aligning each digit on its positional value.  
    2. Multiply each binary digit (0 or 1) by its positional value.  
    3. Add up all the resulting values to get the decimal equivalent.

- **10100110** to decimal:
  
| ^ 2 : | 128  | 64  | 32  | 16  | 8   | 4   | 2   | 1   |
|-------------|-------|------|------|------|------|------|------|------|
| Binary digit | **1** | **0** | **1** | **0** | **0** | **1** | **1** | **0** |


**Adding these values together:**  
`128` + `(there's no 64, so 0)` +  `32` + `(there's no 16, so 0)` + `(there's no 8, so 0)` 4 + 2 + `(there's no 1, so 0)` = **166**   
  
The binary number **10100110** is equivalent to **166** in Base10.
***

#  ❇️ Special number use cases

## How the Base 10 System Stores Data  

The Base 10 (decimal) system represents numbers using **10 digits**: 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9.  
Each position in a number represents a power of 10 and ,as you add digits, the system is expanded by adding new decimal places.  
  
This allows the system to store progressively larger values by grouping numbers into tens, hundreds, thousands, and beyond. Here's how it works:  
```text
1 to 9: The first group of single digits.  
10 to 99: The second group, adding a **new decimal place** for tens.  
100 to 999: The third group, expanding with another decimal place for hundreds.  
1000 to 9999: Adds a fourth decimal place for thousands.  
[...]  
1,000,000,000,000,000 to 9,999,999,999,999,999: Continues expanding as more decimal places are added.  
```

Each additional decimal place increases the range of numbers the system can represent, building on the power of tens:  
- **10⁰ = 1** (units place)  
- **10¹ = 10** (tens place)  
- **10² = 100** (hundreds place), and so on.  

♾️ This incremental approaching process can continue infinitely giving a huge lenght numbers, as this is the foundation of Base10 system.  

Now, just imagine a building that needs to number each room.  
A logical way to determine which floor a particular room is on would be, avoiding   
- The **first digit on the left** as the floor number.  
- The remaining digits as the room number on this floor.    

Example:  
- **107:** Room 7 on the **First** floor.  
- **923:** Room 23 on the **Ninth** floor.  
![image](https://github.com/user-attachments/assets/a30cbefc-88fb-4374-aefa-08f191dd9d0b)



## How Base2 stores data:
Imagine a Byte, composed of 8 bits, where each bit has its own state (either **0** or **1**) and can represent data. Let’s use the following example on how a single Byte can encode multiple pieces of information for managing a sprite in a game or application.
![image](https://github.com/user-attachments/assets/a34a665d-7932-4ddf-93c0-ea204f241261)

The Byte **01011011** can be interpreted as follows:  

- **First bit (0):** Determines the sprite used.  
- **Bits 2-4 (101):** Represents a time counter in binary, with a maximum value of **Base 2 (111)** or **7 seconds**.  
- **Bits 5-6 (10):** Specifies the colors used for the sprite.  
- **Last two bits (11):** Indicates a life counter for the sprite, with a maximum value of **Base 2 (11)** or **3 lives**.  


