
This challenge is performed starting with its guided solution available at A01-03.

## ASMdoc
#### Main idea:

1. Copy value 88 to CPU.
3. Copy from there, to mem. address C0 00
4. Stop the execution.

#### Steps:  
0. The program:  
```hex
3E 88 32 00 C0 18 FE
```
  - Decoding/understanding the programm:
    * `3e 88` -> `ld a,n` -> `ld a,#88`  
      Opcode 3E, to load "something" (red pixel, colour chart is #88") into `a` Acummulator register.

    * `32 00 C0` -> `ld (nn nn),a` -> ' `ld (C000), a`  
      Opcode 32, to load what's stored on the acummulator, `a`, on the desired mem. address, `C0 00`.
      
    * `18 FE` -> `jr d` -> `jr FE`  
      Opcode 18, to perform a relative jump on FE, performing an infinite loop.
      
    
1. Run WinAPE.
2. Open the debugger (F7).
3. Find an empty/available mem. address. (For example, 4000)
4. Load the programm hex code.
5. Verify the data input, instructions are also shown in assembly. 
7. Tells the `PC` to execute the address we want (4000) and close the Debugger.

  
![IMG](https://github.com/alexandrglm/elearning_tools/blob/bc01e1afddec92231135ae063906e724085ebcd5/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/C01_CHALLENGES/RedPixelChallenge_Screenshot_20250122-0221.png)  

That's all. 
🎉🎉🎉🎉🎉🎉




