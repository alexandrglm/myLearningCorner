# B01\_01\_CPU\_Execution\_Cycle

## B01 - Module 1, Theory

### B01\_01:    The CPU Execution Cycle

Video class: [Youtube Link](https://youtu.be/p8DeOFI-CKE)\
Materials used: [1.T01.elCicloDeEjecucionDeLaCPU.pdf](../../../../../../_pending/Z80-Assembler-MOOC/contents/Course/MODULE_1:Sprite_in_machine_Code/B01_THEORY/1.T01.elCicloDeEjecucionDeLaCPU.pdf)

***

**Content:**

* How the Z80's execution cycle works.
* The `Fetch - Decode - Execute` process, illustrated using the _A01\_02 program_ as an example: _"How to draw and display a pixel on the screen."_
* An introduction to processor counters, registers, buses, and RAM.

***

The Z80 processor follows a continue `fetch-decode-execute`-cycle to read instructions from memory, perform the necessary operations, and move to the next instruction, enabling the execution of programs and the manipulation of data.(¹)

The AMSTRAD buses are:

* **DATA BUS**: 8 bit lenght.
* **ADRESS BUS**: 16 bit lenght.

The Z80 interarl registers are:

* **PC**: Program Counter - Everytime an instruction has been loaded, and unless there are not any instruction ordering to backward the counter, an attached circuit sums +1 on the program counter.
* **BR**: Buffer register - Temporary storage for anything that comes from the memory.
* **IR**: Instruction register - Same as BR, but for storing instructions.

The Z80 memory registers are:

* **A/F** - Accumulator / Flag registers.
* **B/C** - General purposse registers.
* **D/E** - General purposse registers.
* **H/L** - General purposse registers.

***

## Zilog's Z80 general specifications: (²):

### CPU Registers

* The Z80 CPU contains 208 bits of read/write memory that are available to the programmer.
* The memory is configured into:
  * Eighteen 8-bit registers + four 16-bit registers.
* All Z80 CPU registers are implemented using static RAM.
* The register includes:
  * Two sets of **six general-purpose registers** that can be used individually as 8-bit registers or in pairs as 16-bit registers.
  * Two sets of **Accumulator** and **Flag** registers.
  * Six **special-purpose** registers.

| **Main Register Set**         | **Alternative Register Set** |
| ----------------------------- | ---------------------------- |
| _Accumulator (A)_             | _Accumulator (A')_           |
| _Flags (F)_                   | _Flags (F')_                 |
| **General Purpose registers** |                              |
| _B, C, D, E, H, L_            | _B', C', D', E', H', L'_     |
| **Special Purpose registers** |                              |
| _Interrupt Vector (I)_        | _Memory Refresh (R_          |
| _Index Register (IX)_         | _Index Register (IY)_        |
| _Stack Pointer (SP)_          | _Program Counter (PC)_       |

#### Special-Purpose Registers

**Program Counter (PC)**

The Program Counter holds the 16-bit address of the current instruction being fetched from memory.\
It automatically increments after the instruction is fetched. When a program jump occurs, the new address is placed into the Program Counter, overriding the automatic increment.

**Stack Pointer (SP)**

The Stack Pointer holds the 16-bit address of the top of the stack in system RAM.\
The stack operates as a _Last-In-First-Out (LIFO)_ structure.\
Data can be pushed onto or popped off the stack using the `PUSH` / `POP` instructions.\
The stack simplifies interrupt handling, subroutine nesting, and data manipulation.

**Two Index Registers (IX and IY).**

The two index registers hold 16-bit base addresses used in indexed addressing.\
These registers point to a memory region, and an additional byte can specify a displacement from this base.\
**This simplifies the use of data tables.**

**Interrupt Page Address (I) Register.**

The `I register` stores the high 8 bits of an address used during interrupts.\
The lower 8 bits come from the interrupting device.\
This feature **allows interrupt routines to be located anywhere in memory, with minimal access time.**

**Memory Refresh (R) Register.**

The `R register` is used for refreshing dynamic memory, allowing it to function like static memory.\
It increments automatically after each instruction fetch, and its data is sent along with the refresh control signal, all without affecting CPU performance.

**Accumulator and Flag Registers.**

The Z80 CPU includes two 8-bit accumulators and associated flag registers :

* The `accumulator register` holds the results of arithmetic or logical operations.
* the `flag registers` indicate the results, such as whether the result is zero.\
  The code can switch between accumulators and flag pairs as needed.

#### General Purpose Registers

There are two sets of general-purpose registers:

```
    Set 1: BC, DE, HL
    Set 2: BC', DE', HL'
```

Each register set can be used as individual 8-bit registers or paired as 16-bit registers.\
The programmer can quickly switch between sets using a single exchange command, which is particularly useful for fast interrupt handling, as it avoids saving and restoring registers from the stack.

#### Arithmetic Logic Unit (ALU)

The 8-bit arithmetic and logical instructions of the CPU are executed in the Arithmetic Logic Unit (ALU).\
Internally, the ALU communicates with the registers and the external data bus by using the internal data bus.\
Functions performed by the ALU may include:

```
    Add
    Subtract
    Logical AND
    Logical OR
    Logical eXclusive OR
    Compare
    Left or right shifts or rotates (aritmetic and logical)
    Increment
    Decrement
    Set bit
    Reset bit
    Test bit
```

#### Instruction Register and CPU control

Each register set can be used as individual 8-bit registers or paired as 16-bit registers.\
The code can quickly switch between sets using a single exchange command, which is particularly useful for fast interrupt handling, as it avoids saving and restoring registers from the stack.

***

**References**

1. '_How the Z80 work_' - Reading-Uk [Link](http://www.reading-uk.net/en/how-the-z-80-work/)
2. '_The Z80 registers_' - Jimmy Dansbo's Z80 Information site [Link](https://jnz.dk/z80/registers.html)
