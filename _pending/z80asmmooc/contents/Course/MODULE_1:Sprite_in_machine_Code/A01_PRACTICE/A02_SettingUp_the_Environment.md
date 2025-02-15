## Installing WinAPE (a Win CPC emulator) and CPCtelera v1.5
- WinAPE, Windows Amstrad Plus Emulator, needs to be wine-loaded.
- Latest version available: 2.0b2 	05-Jan-2016 
- Although the WinAPE  [Source](http://www.winape.net/downloads.jsp) is available, there’s no need to install it separately, as CPCtelera will handle this for us.

Let's begin by setting up the environment and starting with the compilation of CPCtelera.

# Setting up the environment

**CPCtelera sources**: https://github.com/lronaldo/cpctelera.git  

The repository contains multiple branches, which can be selected using `git checkout` after cloning it:  
- `$ git branch` displays the current branch (the default is the master branch, CPCtelera v1.4.2).  
- `$ git checkout development` switches to the `development` branch, which usually contains the latest fixes and updates.  
- You can view all available branches with `$ git branch -a`.

```bash
$ git branch -a
* development
  master
  remotes/origin/HEAD -> origin/master
  remotes/origin/android
  remotes/origin/colorreplace
  remotes/origin/cpcplus_asic
  remotes/origin/development
  remotes/origin/doc
  remotes/origin/drawbackbuffer
  remotes/origin/easytilemaps
  remotes/origin/gh-pages
  remotes/origin/master
  remotes/origin/maze
  remotes/origin/newstrings
  remotes/origin/readvideomem
  remotes/origin/sna
  remotes/origin/spriteclipping
  remotes/origin/spritemirroring
  remotes/origin/update2cdt
```
- ⚠️ `development` branch will be used. 
```bash
$ git checkout development
branch 'development' set up to track 'origin/development'.
```
- Now, we can start the `./setup.sh` script. ⚠️ Ensure you know which user account you are using, as running it as the root user will make the binaries only available for that specific user. **As always, avoid using the root account. ⚠️
 
- This build script will verify if all requirements are met.  
The following libraries should be installed beforehand, as they are supported by default in Debian sources (Tested on Debian-next -Trixie-):

```
gcc g++ make bison flex mono-complete libboost-dev libfreeimage-dev
```
```bash
Welcome to...
 ____     ____     ____     __            ___
/\  _`\  /\  _`\  /\  _`\  /\ \__        /\_ \
\ \ \/\_\\ \ \L\ \\ \ \/\_\\ \ ,_\     __\//\ \       __   _ __    __
 \ \ \/_/_\ \ ,__/ \ \ \/_/_\ \ \/   /'__`\\ \ \    /'__`\/\`'__\/'__`\
  \ \ \L\ \\ \ \/   \ \ \L\ \\ \ \_ /\  __/ \_\ \_ /\  __/\ \ \//\ \L\.\_
   \ \____/ \ \_\    \ \____/ \ \__\\ \____\/\____\\ \____\\ \_\\ \__/.\_\
    \/___/   \/_/     \/___/   \/__/ \/____/\/____/ \/____/ \/_/ \/__/\/_/

This setup script will help you configure CPCtelera in your system.

===============================================================
== 1: CPCtelera initial tests
===============================================================
> Checking directory structure... [ OK ]
> Checking important files....... [ OK ]
Welcome to...
 ____     ____     ____     __            ___
/\  _`\  /\  _`\  /\  _`\  /\ \__        /\_ \
\ \ \/\_\\ \ \L\ \\ \ \/\_\\ \ ,_\     __\//\ \       __   _ __    __
 \ \ \/_/_\ \ ,__/ \ \ \/_/_\ \ \/   /'__`\\ \ \    /'__`\/\`'__\/'__`\
  \ \ \L\ \\ \ \/   \ \ \L\ \\ \ \_ /\  __/ \_\ \_ /\  __/\ \ \//\ \L\.\_
   \ \____/ \ \_\    \ \____/ \ \__\\ \____\/\____\\ \____\\ \_\\ \__/.\_\
    \/___/   \/_/     \/___/   \/__/ \/____/\/____/ \/____/ \/_/ \/__/\/_/

This setup script will help you configure CPCtelera in your system.

===============================================================
== 1: CPCtelera initial tests
===============================================================
> Checking directory structure... [ OK ]
> Checking important files....... [ OK ]
> Checking required commands...
Welcome to...
 ____     ____     ____     __            ___
/\  _`\  /\  _`\  /\  _`\  /\ \__        /\_ \
\ \ \/\_\\ \ \L\ \\ \ \/\_\\ \ ,_\     __\//\ \       __   _ __    __
 \ \ \/_/_\ \ ,__/ \ \ \/_/_\ \ \/   /'__`\\ \ \    /'__`\/\`'__\/'__`\
  \ \ \L\ \\ \ \/   \ \ \L\ \\ \ \_ /\  __/ \_\ \_ /\  __/\ \ \//\ \L\.\_
   \ \____/ \ \_\    \ \____/ \ \__\\ \____\/\____\\ \____\\ \_\\ \__/.\_\
    \/___/   \/_/     \/___/   \/__/ \/____/\/____/ \/____/ \/_/ \/__/\/_/

This setup script will help you configure CPCtelera in your system.

===============================================================
== 1: CPCtelera initial tests
===============================================================
> Checking directory structure... [ OK ]
> Checking important files....... [ OK ]
> Checking required commands...
>>> Looking for 'gcc'... [ OK ]
>>> Looking for 'g++'... [ OK ]
>>> Looking for 'make'... [ OK ]
>>> Looking for 'bison'... [ OK ]
>>> Looking for 'flex'... [ OK ]
>>> Looking for 'mono'... [ OK ]
> Checking command versions...
>>> GNU GCC/G++ Version >= 5.1... [ OK ]
> Checking required libraries...
>>> Looking for 'boost/graph/adjacency_list.hpp'... [ OK ]
>>> Looking for 'libintl.h'... [ OK ]
>>> Looking for 'FreeImage.h'... [ OK ]
Everything seems to be OK.

===============================================================
== 2: Building CPCtelera tools, z80 library and examples
===============================================================
> Proceeding to build required tools to build and manage CPCtelera and other software for Amstrad CPC (This might take a while, depending on your system).
>>> Building compilation tools:                                            100% [ OK ]
>>> Building cpctelera z80 lib:                                            100% [ OK ]
> Bulding procedure finished. 
> CPCtelera's tools and library are now ready to be used on your system.

>>> Building cpctelera examples:                                           100% [ OK ]

===============================================================
== 3: Configuring CPCtelera environment
===============================================================
> Setting up present CPCtelera folder as install directory and configuring routes and templates...
>>> CPCTelera full path: [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera
>>> Inserting full path into build config template... [ OK ]
>>> CPCTelera scripts path: [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/scripts
>>> Adding scripts path to $PATH variable in .bashrc... [ OK ]

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% CPCtelera is now ready to be used on your system. %%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

You may now go to the examples folder and play around with the included example projects. Inside any project's folder, just type make to create CDT and DSK files for Amstrad CPC. In the src/ folder you will find C source code for each example. The cfg/ folder contains the building configuration for your project. Change everything as you like.

If you wanted to create a new project, you may use cpct_mkproject <project_folder>. This is a script that automates the creation of new projects. For convenience, it has been included in your $PATH environment variable (you need to open a new shell for this to take effect). You may create projects anywhere, provided you do not change CPCtelera's main folder location. 

If you have any comments, please go to https://github.com/lronaldo/cpctelera or send an email cpctelera@cheesetea.com. We hope you enjoy the library and expect to see your games comming out soon :).
```
- Once compiled and installed, we can check the new binaries added to our system.
- Make sure to reload your paths by running `source .bashrc` or by closing and reopening a new terminal session.  

```bash
$ cpct_
cpct_aks2c         cpct_img2tileset   cpct_png2chars     cpct_tmx2csv
cpct_bin2c         cpct_installrslib  cpct_rgas2c        cpct_tmx2data
cpct_bin2sna       cpct_mkproject     cpct_rvm           cpct_winape
cpct_binpatch      cpct_pack          cpct_sp2tiles
```
- Now, it's time to get WinAPE by using `cpct_winape`. ⚠️ **Ensure your system is Wine-enabled** (e.g., :i386 architecture, Wine properly configured, etc.). ⚠️

```bash
$ cpct_winape 

%%%%%%%%%%%%%%%%%%%%%%%%%
%% WinAPE laucher script
%%%%%%%%%%%%%%%%%%%%%%%%%

[Warning] WinAPE is not configured for your system yet.

Proceeding to install/configure WinAPE on your system.

Do you already have WinAPE installed (y/n)?n

This script can automatically download and install WinAPE under your CPCtelera tools folder for you.

Do want WinAPE to be downloaded & installed (y/n)?y
 Downloading WinAPE from (http://winape.net/download/WinAPE20B2.zip)...
2025-01-19 18:22:45 URL:http://winape.net/download/WinAPE20B2.zip [4458571/4458571] -> "/REMOVED_FOR_PRIVACY]2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/scripts/../winape.zip" [1]
Unpacking WinAPE...
Setting CPCTelera default WinAPE.ini file...
WinAPE is now configured and installed in '[REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/scripts/../winape'
```

- Then, we need to get RetroVirtual Machine, by performing the same method used before with WinApe, but with the bin `cpct_rvm`:
```bash
$ cpct_rvm 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% RetroVirtualMachine laucher script
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

[Warning] RVM is not configured for your system yet.

Proceeding to install/configure RVM on your system.

Do you already have RVM installed (y/n)?n

This script can automatically download and install RVM under your CPCtelera tools folder for you.

Do want RVM to be downloaded & installed (y/n)?y
 Selecting appropriate URL for your Operative System...
 Downloading RVM from (http://retrovirtualmachine.ams3.digitaloceanspaces.com/release/beta1/linux/x64/RetroVirtualMachine.2.0.beta-1.r7.linux.x64.zip)...
2025-01-19 18:24:14 URL:https://retrovirtualmachine.ams3.digitaloceanspaces.com/release/beta1/linux/x64/RetroVirtualMachine.2.0.beta-1.r7.linux.x64.zip [67292659/67292659] -> "[REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/scripts/../RVM.zip" [1]
Unpacking RVM...
RVM is now configured and installed in '   #/[REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/scripts/../rvm'

Launching RetroVirtualMachine V2...
Machine:  cpc664

```
# Creating a new Project.
1. By using `cpct_mkproject` `-a` (--asm, only available at devel. version 1.5.)
      - **Default path**: `~/game/`
```bash
cpct_mkproject -a game

===============================================================
== CPCtelera: Creating new project in game/
===============================================================
> Setting up assembler-based defaults... [ OK ]
> Creating project folder structure... [ OK ]
> Copying files from project templates... [ OK ]
> Copying basic VS Code project configuration... [ OK ]
> Configuring Android APK exporter... [ OK ]
> Configuring project name to: game [ OK ]
> Configuring z80 code load address: 4000 [ OK ]
> Configuring $CPCT_PATH: Using environment variable [ OK ]

===============================================================
== CPCtelera: New project created in game/
===============================================================

```
## **The default path will be ~/game/**
```bash
$ ls -l ~/game
total 20
drwxrwxr-x 3 user user 4096 ene 19 18:31 cfg
drwxrwxr-x 2 user user 4096 ene 19 18:31 dsk
drwxrwxr-x 3 user user 4096 ene 19 18:31 exp
-rw-rw-r-- 1 user user 1989 ene 19 18:31 Makefile
drwxrwxr-x 2 user user 4096 ene 19 18:31 src
```
***
# Compiling a first example program:
## Sources location
- ~/game/src/main.s
- 
## Example code included.
```asm
;;-----------------------------LICENSE NOTICE------------------------------------
;;  This file is part of CPCtelera: An Amstrad CPC Game Engine 
;;  Copyright (C) 2018 ronaldo / Fremos / Cheesetea / ByteRealms (@FranGallegoBR)
;;
;;  This program is free software: you can redistribute it and/or modify
;;  it under the terms of the GNU Lesser General Public License as published by
;;  the Free Software Foundation, either version 3 of the License, or
;;  (at your option) any later version.
;;
;;  This program is distributed in the hope that it will be useful,
;;  but WITHOUT ANY WARRANTY; without even the implied warranty of
;;  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;;  GNU Lesser General Public License for more details.
;;
;;  You should have received a copy of the GNU Lesser General Public License
;;  along with this program.  If not, see <http://www.gnu.org/licenses/>.
;;-------------------------------------------------------------------------------

;; Include all CPCtelera constant definitions, macros and variables
.include "cpctelera.h.s"

;;
;; Start of _DATA area 
;;  SDCC requires at least _DATA and _CODE areas to be declared, but you may use
;;  any one of them for any purpose. Usually, compiler puts _DATA area contents
;;  right after _CODE area contents.
;;
.area _DATA

;; Define one Zero-terminated string to be used later on
string: .asciz "Hey! CPCtelera up and running!";

;;
;; Start of _CODE area
;; 
.area _CODE

;; 
;; Declare all function entry points as global symbols for the compiler.
;; (The linker will know what to do with them)
;; WARNING: Every global symbol declared will be linked, so DO NOT declare 
;; symbols for functions you do not use.
;;
.globl cpct_disableFirmware_asm
.globl cpct_getScreenPtr_asm
.globl cpct_setDrawCharM1_asm
.globl cpct_drawStringM1_asm

;;
;; MAIN function. This is the entry point of the application.
;;    _main:: global symbol is required for correctly compiling and linking
;;
_main::
   ;; Disable firmware to prevent it from interfering with string drawing
   call cpct_disableFirmware_asm

   ;; Set up draw char colours before calling draw string
   ld    d, #0         ;; D = Background PEN (0)
   ld    e, #3         ;; E = Foreground PEN (3)

   call cpct_setDrawCharM1_asm   ;; Set draw char colours

   ;; Calculate a video-memory location for printing a string
   ld   de, #CPCT_VMEM_START_ASM ;; DE = Pointer to start of the screen
   ld    b, #24                  ;; B = y coordinate (24 = 0x18)
   ld    c, #16                  ;; C = x coordinate (16 = 0x10)

   call cpct_getScreenPtr_asm    ;; Calculate video memory location and return it in HL

   ;; Print the string in video memory
   ;; HL already points to video memory, as it is the return
   ;; value from cpct_getScreenPtr_asm
   ld   iy, #string    ;; IY = Pointer to the string 

   call cpct_drawStringM1_asm  ;; Draw the string

   ;; Loop forever
loop:
   jr    loop
```
***
## *"Disassembling"* the Assembler Code

- Since the assembler included in WinAPE may not meet our requirements, we use a more versatile assembler, suitable for various platform developments but focused to our specific goals.  
- It is **mandatory** for any project to declare specific block codes:  
  - **DATA area**  
  - **CODE area**  
    - **GLOBAL symbols**  
    - **MAIN symbol**  

- These declarations allow the linker and assembler process to compile the code as expected.

 
## Declaring **.area_DATA**

```asm
;;
;; Start of _DATA area 
;;  SDCC requires at least _DATA and _CODE areas to be declared, but you may use
;;  any one of them for any purpose. Usually, compiler puts _DATA area contents
;;  right after _CODE area contents.
;;
.area _DATA
```
  
## Declaring **.area_CODE**
```asm
;;
;; Start of _CODE area
;; 
.area _CODE
```

## Global symbols
```asm
.globl cpct_disableFirmware_asm
.globl cpct_getScreenPtr_asm
.globl cpct_setDrawCharM1_asm
.globl cpct_drawStringM1_asm
```

## main Symbol (Where the program starts)
The first step in our program is *"taking the ownership* of the firmware functions, as our program will set/define/configure/order *"what will happen"* on execution time.

```asm
_main::
   ;; Disable firmware to prevent it from interfering with string drawing
   call cpct_disableFirmware_asm
```
In this example, the code will draw a colored string (predefined in the DATA area, positioned at a specific screen location) by following these logical steps:  

1. Set up the draw character colors.  
2. Calculate the video memory location.  
3. Configure the location and print the desired string in the video memory.  
4. Add an infinite loop to keep the string displayed on the screen.  


  
```asm
   ;; Set up draw char colours before calling draw string
   ld    d, #0         ;; D = Background PEN (0)
   ld    e, #3         ;; E = Foreground PEN (3)

   call cpct_setDrawCharM1_asm   ;; Set draw char colours

   ;; Calculate a video-memory location for printing a string
   ld   de, #CPCT_VMEM_START_ASM ;; DE = Pointer to start of the screen
   ld    b, #24                  ;; B = y coordinate (24 = 0x18)
   ld    c, #16                  ;; C = x coordinate (16 = 0x10)

   call cpct_getScreenPtr_asm    ;; Calculate video memory location and return it in HL

   ;; Print the string in video memory
   ;; HL already points to video memory, as it is the return
   ;; value from cpct_getScreenPtr_asm
   ld   iy, #string    ;; IY = Pointer to the string 

   call cpct_drawStringM1_asm  ;; Draw the string

   ;; Loop forever
loop:
   jr    loop
```
***
# Compiling
## `make`

The compiling process generates several binary formats:  
- **.BIN** - The program in **BINARY** format.  
- **.CDT** - The program in **CASSETE** format.  
- **.DSK** - The program in **DISK** format.  
- **.SNA** - A snapshot file. 

⚠️ Note: Using **SNAPSHOTs** for development differs from loading **BIN**, **cassette**, or **disk** programs. Be aware of these differences during the loading process.  

### Example of a Compiling Process:
```bash
$ cd ~/game/
dev@ice:~/game$ make
preobjs: 'obj/dsk/.folder obj/.folder'
[game] 
[game] === PREBUILD PROCCESSING DONE!
[game] ============================================================
[game] 
 [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/sdcc-3.6.8-r9946/bin/sdasz80 -l -o -s -I [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/src -Isrc   obj/main.rel  src/main.s 
[game] Linking binary file
 [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/sdcc-3.6.8-r9946/bin/sdcc -mz80 --no-std-crt0 -Wl-u --code-loc 0x4000 --data-loc 0 -l [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/cpctelera.lib      obj/main.rel -o "obj/game.ihx"
[game] Creating Amsdos binary file obj/game.bin
 [REMOVED_FOR_PRIVACY]/2_iKASTAROAK/Z80/0_environment/cpctelera/cpctelera/tools/hex2bin-2.0/bin/hex2bin -p 00 "obj/game.ihx" | tee obj/game.bin.log
hex2bin v2.0, Copyright (C) 2015 Jacques Pelletier & contributors

Binary file start = 00004000
Records start     = 00004000
Highest address   = 00004127
Pad Byte          = 0
[game] Creating Cassette file 'game.cdt'
'game.cdt' < 'game.bin' {Format:'firmware' Load:'0x4000' Run:'0x4000' Name:'Game'}
[game] Successfully created 'game.cdt'
[game] Creating Disk File 'game.dsk'
DSK : game.dsk
------------------------------------
[game.dsk] Added BIN file 'obj/game.bin'
[game] Successfully created 'game.dsk'
[game] All files added to game.dsk. Disc ready.
[game] Creating Snapshot File 'game.sna'
[game] Successfully created 'game.sna'
```
***
# RUNNING THE PROGRAM

## CDT - RVM
```bash
~/game$ cpct_rvm game.cdt -nw
Launching RetroVirtualMachine V2...
Machine:  cpc464
CDT:      game.cdt
Command:  RUN"\n 
```
![image](https://github.com/user-attachments/assets/3dfdadeb-6aee-486d-a32d-035303451512)

## SNA / DSK / CDT - WinAPE
```bash
~/game$ cpct_winape game.sna 
Autoloading symbols file obj/game.noi
```
![image](https://github.com/user-attachments/assets/0be2fcb0-806c-486c-bf3c-0ddaee2e7094)
***
- The DSK loading throug WinAPE actually opens a new WinAPE instance and type for us `run"{THE_PROGRAM.bin}`
```bash
~/game$ cpct_winape game.dsk 
Autoloading symbols file obj/game.noi
```
  
- The CDT load has to be run at RVM.  
Cassete loads **use fast-forwarding** when **loading** the program, not so in its execution.  
```bash
~/game$ cpct_rvm game.cdt
Launching RetroVirtualMachine V2...
Machine:  cpc464
CDT:      game.cdt
Command:  RUN"\n 
WarpMode: ON
```
***
# OUR FIRST PROGRAM - Drawing 3 coloured moving squares
# Pending
## DOCs path:
```bash
$ cd $CPCT_PATH/docs/
```
## CPCtelera Reference Manual
⚠️ The man/docs included here reffers to the **Development Branch - v.1.5**.

```bash
$ $CPCT_PATH/docs/index.html
```







