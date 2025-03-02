;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

; 20250120_2: 
; Now, the videoMode has been configured, but the square is still being called as a String method.
; That can be proved by seeing results using mode 1 and above. ( | | | | | | | | ).
; Surprisely, using mode 0 we can see a rectangle wit no | spaces | between each character

.include "cpctelera.h.s"

.area _DATA

colourarray: .db 1,2,3,4
colour: .db #3

.area _CODE
;; THIS comes from a the main.s included in CPCtelera v.1.5, and will be used as the base

.globl cpct_disableFirmware_asm
.globl cpct_setVideoMode_asm
.globl cpct_setPalette_asm
.globl cpct_getScreenPtr_asm
.globl cpct_drawSolidBox_asm

_main::

   	call cpct_disableFirmware_asm

	ld	c, #1
	call cpct_setVideoMode_asm

 	ld	hl, (colourarray)
  	ld	de, #4
 	call cpct_setPalette_asm

   	ld   	de, #CPCT_VMEM_START_ASM
   	ld    	b, #24
   	ld    	c, #16
	call cpct_getScreenPtr_asm

   	ld   a, (colour)
   	ld   c, #8
   	ld   b, #8
   	call cpct_drawSolidBox_asm

loop:
   jr    loop
