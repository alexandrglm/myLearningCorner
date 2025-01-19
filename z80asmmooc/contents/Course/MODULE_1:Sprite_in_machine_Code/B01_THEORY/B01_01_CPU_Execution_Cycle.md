# B1_01: The CPU Execution Cycle
Video class: [Youtube Link](https://youtu.be/p8DeOFI-CKE)  
Materials used: [1.T01.elCicloDeEjecucionDeLaCPU.pdf](https://github.com/alexandrglm/elearning_tools/blob/main/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T01.elCicloDeEjecucionDeLaCPU.pdf)  
***

#### Content:
- How the Z80's execution cycle works.  
- The `Fetch - Decode - Execute` process, illustrated using the *A01_02 program* as an example: *"How to draw and display a pixel on the screen."*  
- An introduction to processor counters, registers, buses, and RAM.
***

The Z80 processor follows a `fetch-decode-execute` cycle to read instructions from memory, perform the necessary operations, and move to the next instruction, enabling the execution of programs and the manipulation of data.(¹)

The AMSTRAD buses are:
- **DATA BUS**:    8 bit lenght.
- **ADRESS BUS**:  16 bit lenght.


The Z80 interarl registers are:

- **PC**:  Program Counter - Everytime an instruction has been loaded, and unless there are not any instruction ordering to backward the counter, an attached circuit sums +1 on the program counter.
- **BR**:  Buffer register - Temporary storage for anything that comes from the memory.
- **IR**:  Instruction register -  Same as BR, but for storing instructions.


The Z80 memory registers are:
- **A/F**
- **B/C**
- **D/E**
- **H/L**

- A - B - C - D - F -High - Low





***
#### References
1. 'How the Z80 work' - Reading-Uk [Link](http://www.reading-uk.net/en/how-the-z-80-work/)
2. 'The Z80 registers' - Jimmy Dansbo's Z80 Information site [Link](https://jnz.dk/z80/registers.html)
