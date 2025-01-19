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


### Binary system
  
- Binary is a base-2 number system, meaning it only uses two digits: **0 and 1.**
- Everything works on a binary system.  


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

