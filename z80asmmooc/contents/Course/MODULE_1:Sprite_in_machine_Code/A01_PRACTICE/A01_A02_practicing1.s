;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

.include "cpctelera.h.s"
.area _DATA

thecolour: .db #3

.area _CODE
;; THIS comes from a the main.s included in CPCtelera v.1.5, and will be used as the base

.globl cpct_disableFirmware_asm   ;; mandatory
.globl cpct_getScreenPtr_asm
.globl cpct_drawSolidBox_asm

_main::

   call cpct_disableFirmware_asm

   ld   d, #10
   ld   e, #5
   call cpct_getScreenPtr_asm

   ld   a, (thecolour)
   ld   c, #10
   ld   b, #10
   call cpct_drawSolidBox_asm

;;   infinite loop to maintain in-screen what we coded.
loop:
   jr    loop
