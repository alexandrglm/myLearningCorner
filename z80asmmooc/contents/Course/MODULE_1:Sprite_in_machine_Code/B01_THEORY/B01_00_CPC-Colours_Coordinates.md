Depending on the video mode are being used:
*  Colours encoding change.  
*  Coordinates on-screen differs.  
*  Pixels-per-block aren't the same.

*Although **practicing** is the best way to understand/memorize/get ready to self-manipulate data, the lack of time (and the headache derivated from trying to get deeper on knowledge) needs to be resolved not only by takning notes, but creating guides and types.  
So, let's note some tips: 

## VIDEO MODE 1  
* 4 Colours:  

  
* 4 pixels-per-block, horizontals.
  
* `D000` ~ `FFFF` video memory address available.  
  
* Screen Border can be defined using BASIC (`border + the colour num. available at HW Colour tables), to avoid mistaken countings.  

### Colour Byte codification  
Even it's already explained in this `Module_1/B_Theory`, this is the simplest way.  

1. `1 BYTE` = `1 BLOCK` of `4 PIXELS/COLOURS` = `2 BITS per COLOUR`.  
2. Bits allocating uses `PAIR BLOCKS NOTATION` plus `RIGHT-TO-THE-LEFT ALLOCATION`.  
3. Fast mental conversion must be needed at the begining but, in fact, there are always the same values to use, so they are automatically memorised on trainging-practicng.  

#### Colour conversions are made like this:  

1st.  Make sure you know well the binary digits of each colour (It's easy in video mode 1 as long as only uses 4 of them):    

  - `00` - Transparent(Blue)  
  - `01` - Yellow  
  - `10` - Cyan  
  - `11` - Red  
  
2nd.  Choose which 4 colours you will need to fill the block in use, and put them and its bin equivalence on two mental rows.  Then, treat the bin row as two blocks of 4 bits each ones.  
  
3rd.  Re-order the bin row by filling it in a new row of two blocks by adding the bits BY PAIRS and RIGHT-TO-THE LEFT.  
  
4th.  Finally, refactorize each block to Base16 in their own digit, resulting the original bin byte converted to 2-digits Hexadecimal value.  
  
E.g.:  
    *  **R - R - Y - C**  
       `11`-`11`-`01`-`10` 
       `1111` - `0110`  
Now, reorder it BYPAIR/RightToLeft:  
    * *11 at the begining? So, ...*  
         **1       1**  
      *11 at the second? So, ...*  
         **11      11**  
      *01 on 3rd position? So, ...*  
         **111     110**  
      *10 the fourth? So, ...*  
         **1110    1101**  
    * *The final Base16 conversion on each block ...*  
              **E D**  
         
### Coordinates On-Screen

1. It works by the video memory addresses available:
  * `C000` is the first address.
  * Then, you put something on this. Remember, it's an horizontal 4 Pixels-per-block.
  * The next, obvius, address is 'C001'. Once again, remember it does not follow the first by one pixels, by one BLOCK-OF-4-PIXELS instead.

2. The video rastering starts, widthly, on the TOP-LEFT.
   
3.Using video mode 1, the max. width, in mem. addresses, are:
  * C000 to C7FF = 2047 mem. addresses.
  * Next line starts on `C800` to `CFFF`.
  * There's not available a direct 1:1 conversion between addreses and pixels coordinates, and/or blocks.

