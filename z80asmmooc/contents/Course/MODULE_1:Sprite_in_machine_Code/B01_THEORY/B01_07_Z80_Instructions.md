# B1_07:   Z80 Instructions
Video class: [Youtube Link](https://youtu.be/diUXVhx1h3Y)    
Materials used: [ 1.T07.instruccionesDelZ80.pdf ](https://github.com/alexandrglm/elearning_tools/blob/f66aebb71e321f28ffb0bf99769a2d7d7ca6cbc6/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T07.instruccionesDelZ80.pdf)  
***

#### Content:  
- A guide explaining about Z80 instructions.
- Deeper explanation about machine-code instructions used on course's Module 1.
- Executing & debugging examples using WinAPE.

***

* All instructions allowed to be executed by the CPU are well-documented, like in the official Z80 documentation, or what  were made for/by this chipset lovers as seen in this table example given from [this site](https://clrhome.org/table/) :
![IMG_Z80_Opcodes](https://github.com/user-attachments/assets/1dcedf84-e6f6-4f69-a924-77d65030a58b)  

* Every Opcode is ordered by its machine code (0-9 / A-F).
Remember:
The possible given data (8 / 16 bit values) are read **right-to-the-left**.

* There's no limit of use for any of these more than the each own documented opcodes.

---

## Opcodes used in this Module

### `3E - 00` - `ld a, xx`
Copies the given 8 bit value onto `a`Acummulator register.

### `32 - 00 FF` - `ld (FF00), a`
Copies what's inside in `a` Accumulator register onto the given 16-bit memory address.  

### `21 - 00 FF` - `ld hl, FF00`  
Copies the given 16 bit value onto `h` and `l`.   
(⚠️ FF00, in this case, **is not a memory address, but a 16 bit number** that needs to be adressed to both 8bit registers) 

### `22 - 00 FF` - `ld (FF00), hl`  
Copies what's inside `h` and `l` registers onto the given memory address (This case, this Opcode is refering a 16 bit memory address). 
💡 This is the main method to store 16 bit data value into a specific memory address.

### `18 - 00` - `jr 00`
Performs a relative jump (`JR`) by adding the given value to `PC` register.   
Then, the programm counter will follow the execution from that "added" point.  










***
#### References
1. '*Z80 full Opcodes table*' - CLRHome [Link](https://clrhome.org/table/)
