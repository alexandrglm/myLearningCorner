;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

; 20250121:
; Trying to decode every Opcode by using the official doc. by adding comments before them.
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
  ; Opcode 0E - Value 0x00000001
	ld	c, #1
	call cpct_setVideoMode_asm

  ;  Opcode 31 - Value: The given ( array ) declared at .area _DATA
 	ld	hl, (colourarray)
  ;  Opcode 21 - Value: 0x 0000 0100
  ld	de, #4
 	call cpct_setPalette_asm
    
    ;  Opcode 21
   	ld   	de, #CPCT_VMEM_START_ASM
   	; Opcode 06 - Value: 0x 0001 1010 
    ld    	b, #24
    ;  Opcode 0E - Value: 0x 0001 0000
   	ld    	c, #16
	call cpct_getScreenPtr_asm

    ; Opcode 3E - Value: given array declared at .area _DATA
   	ld   a, (colour)
    ; Opcode 0E - Value: 0x 0000 0110
   	ld   c, #8
    ; Opcode 06 - Value: 0x 000 0110
   	ld   b, #8
   	call cpct_drawSolidBox_asm

loop:
   ; Opcode 18 - d value? "loop"?
   jr    loop
