
This challenge is performed starting with its guided solution available at A01-03.

## ASMdoc

Steps:  
0. The program:  
```hex
3E 88 32 00 C0 18 FE
```
  - Decoding/understanding the programm:
    `3e 88` -> `ld a,n` -> `ld a,#88`   
    `32 00 C0` -> `ld (nn nn),a` -> ' `ld (C000), a`  
    `18 FE` -> `jr d` -> `jr FE` -> FE: 1111 1110 = 254 -> infinite loop  
0.2. Tells the `PC`to execute the address we want (4000) and close the Debugger.


1. Copy value 88 to CPU.
   We need an empty/available memory zone, so, 00 00 won't be right place to.

3. Copy from there, to mem. address C0 00
4. Stop the execution.

