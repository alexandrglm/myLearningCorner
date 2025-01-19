## Installing WinAPE (a Win CPC emulator) and CPCtelera v1.5
- WinAPE, Windows Amstrad Plus Emulator, can be installed on Linux. [Source](http://www.winape.net/downloads.jsp)
- Latest version available: 2.0b2 	05-Jan-2016 

## CPCtelera git: https://github.com/lronaldo/cpctelera.git
There are many branches inside the same repo which can be chosen by typing `git checkuot` after cloning the repo.
* `$ git branch`shows the current branch (master branch as default, CPCtelera v.1.4.2)  
* `$ git checkout development` turns the branch to `development` branch, which tends to get the lastest fixes, content, and so on.
* We can check all the branches availabes with `git branch -a`
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
- `development`branch will be used in our course, so
```bash
$ git checkout development
branch 'development' set up to track 'origin/development'.
```
- Now, we can start the `./setup.sh`. Make sure which user you are using as long as executing by the root user will make these binaries available only for the selected used. As regular, don't use root account.
- This building script will ensure all the requeriments are satisfied.   
These are the libraries which should be installed before running the setup as they are supported on Debian sources by default (Debian-next -Trixie-):
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
