pending ...  

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

### Binary system
  
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

- Now, imagine combining more than one BIT.
- Four combined BITs forms a NIBBLE:
  ![image](https://github.com/user-attachments/assets/a3f95f85-0d38-4182-8236-248a8a1523ce)

- And ... Eight combined BIT's forms ... a **Byte**!
  ![image](https://github.com/user-attachments/assets/f16d37dc-898e-48c6-b7fd-c265b47aa845)







  


### Converting from Decimal (Base 10) to Binary (Base 2)

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

