# Definitions
- **Assembly language**:
Low-level programming language that provides direct control of the processor.  
Each line of assembly code corresponds to one machine instruction.
# Components

## General Syntax

- **LABELS:**
Represent addresses or markers in the code; always **end with a colon (:)**.
```asm
loop:
```

- **INSTRUCTIONS**
An instruction tells the CPU what operation to perform.  
```asm
  LD      A, 42  
  MV      A, 4001     
  ADD     A, 100
```
The instructions, here, are `LD - Load`- `MV - Move` - `ADD - Sums`.  

- **OPERANDS**:
Values or registers that instructions operate on.  
```asm
  LD     A, 42
```
The operands are "A, 42" (loads the value 42 onto A register).  

- **COMMENTS**
Comments start with a semicolon (;); it's a good practice documenting the code
```asm
LD A, 42  ; Load 42 into register A
```
***
## Assembly Directives/Symbols:
Used by the assembler to manage code and data.  
```asm
.org
.area_DATA
.area_CODE
.include
.asciz
_main::
...
```
### main Symbol
Where the program starts.
The first step in a program is "taking the ownership of the firmware functions, as the program will set/define/configure/order "what will happen" on execution time.  
```asm
_main::
  call cpct_disableFirmware_asm  ;; Disabling firmware
```

***
## Registers:
- **General-purpose**: `A, B, C, D, E, H, L`  
- **Special-purpose**:  
  - **Index registerts**: `IX`, `IY`.  
  - **Stack Pointer**: `SP`.  
  - **Programm Counter**: `PC`.  
- **Flags**: `F` register stores condition flags (e.g., `zero`, `carry`, ...).  
***

## Instructions Categories:
### Data Transfer: 
- LD
- EX
- PUSH
- POP
- more pending
  
### Arithmetical/Logical: 
- ADD
- SUB
- AND
- OR
- XOR
- more pending
  
### Control Flow: 
- JP
- JR
- CALL
- RET
- more pending

### I/O: 
- IN
- OUT
  
### Others: 
- NOP
- HALT.
***

## Memory Addressing:

### Immediate: 
Load a constant.
```asm
LD A, 42
```
42, as a constant, is loaded into A.

### Register Indirect: 
Use registers to point to memory.
```asm
LD A, (HL)
```
A (HL value) is loaded into A.


### Indexed: 
Use `IX`  or `IY` with an offset.  
```asm
LD A, (IX+5).
```

