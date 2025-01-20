;; CPCtelera and this asm startup routine belongs to (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)

.include "cpctelera.h.s"
.area _DATA

;;  pending data

.area _CODE
;; THIS comes from a the main.s included in CPCtelera v.1.5, and will be used as the base

.globl cpct_disableFirmware_asm
.globl cpct_getScreenPtr_asm
.globl cpct_setDrawCharM1_asm
.globl cpct_drawStringM1_asm

_main::
   call cpct_disableFirmware_asm

   ld    d, #0
   ld    e, #3

   call cpct_setDrawCharM1_asm

   ld   de, #CPCT_VMEM_START_ASM
   ld    b, #24
   ld    c, #16

   call cpct_getScreenPtr_asm

   ld   iy, #string

   call cpct_drawStringM1_asm

loop:
   jr    loop
