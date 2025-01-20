;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

; 20250120: This solid box is read with the String method, so it's simply shown glitched. But it's a good first approaching.
; I have to learn about setting up the video memory for solid boxes.
; Coordinates on screen, done.


.include "cpctelera.h.s"
.area _DATA

thecolour: .db #1

.area _CODE
;; THIS comes from a the main.s included in CPCtelera v.1.5, and will be used as the base

.globl cpct_disableFirmware_asm
.globl cpct_getScreenPtr_asm
.globl cpct_drawSolidBox_asm

_main::

   	call cpct_disableFirmware_asm

   	ld   de, #CPCT_VMEM_START_ASM
   	ld    b, #24
   	ld    c, #16
   
	call cpct_getScreenPtr_asm

   	ld   a, (thecolour)
   	ld   c, #8
   	ld   b, #8
   	call cpct_drawSolidBox_asm

loop:
   jr    loop
