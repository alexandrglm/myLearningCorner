;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

.include "cpctelera.h.s"
.area _DATA

;;  pending data

.area _CODE
;; THIS comes from a the main.s included in CPCtelera v.1.5, and will be used as the base

.globl cpct_disableFirmware_asm   ;; mandatory
.globl cpct_getScreenPtr_asm
.globl cpct_drawSolidBox_asm
.globl cpct_drawTileAligned2x8_f_asm

_main::

   ;; from this point ... pending.
   call cpct_disableFirmware_asm

   ld    d, #0
   ld    e, #3

   call cpct_getScreenPtr_asm

   call cpct_drawTileAligned2x8_f_asm

   call cpct_drawSolidBox_asm

;;   infinite loop to maintain in-screen what we coded.
loop:
   jr    loop
