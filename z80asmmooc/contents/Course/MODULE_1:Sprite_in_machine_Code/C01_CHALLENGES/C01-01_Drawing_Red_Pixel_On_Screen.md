
This challenge is performed starting with its guided solution available at A01-03.

## ASMdoc

Steps:
0. The program:
```hex
3E 88 32 00 C0 18 FE"
```
  - Decoding the programm:
    `3e 88` -> `ld ld x,n` 
    `32 00 C0` -> ld x, C000
    `18 FE` -> ld x, FE -> FE -> 1111 1110

    
1. Copy value 88 to CPU.
   We need an empty/available memory zone, so, 00 00 won't be right place to.

3. Copy from there, to mem. address C0 00
4. Stop the execution.

