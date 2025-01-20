# Definitions
- **Assembly language**:
Low-level programming language that provides direct control of the processor.  
Each line of assembly code corresponds to one machine instruction.

# Components

## Assembly Directives/Symbols:
Used by the assembler to manage code and data.  
```asm
.org
.area_DATA
.area_CODE
.include
.asciz
...
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

