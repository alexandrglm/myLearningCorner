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



***
# Better explained

### **Color Conversion in Mode 1 (Amstrad CPC)**  

#### **Steps to Convert Colors in Pixel Blocks**  

1. **Understand the binary encoding of each color:**  
   -  `00` - **Transparent (Blue)**  
   -  `01` - **Yellow**  
   - `10` - **Cyan**  
   - `11` - **Red**

2. **Choose the 4 colors you need to fill a pixel block** and align them in two mental rows:  
   - The top row is the color order (e.g., **R - R - Y - C**).
   - The bottom row is the binary equivalent: `11` - `11` - `01` - `10`.

3. **Reorder the binary row in pairs, from right to left**, into two 4-bit blocks:  
   - Start with the first two bits and continue shifting pairs.  
     For example:  
     - First pair (`11`): **1       1**  
     - Second pair (`11`): **11      11**  
     - Third pair (`01`): **111     110**  
     - Fourth pair (`10`): **1110    1101**

4. **Convert each 4-bit block to Base 16 (Hexadecimal):**  
   - Using the reordered binary, calculate each block:  
     - `1110` → `E`  
     - `1101` → `D`  
   - The final Hexadecimal value for this block is **ED**.


***
## Full list of values.
| Block | Hex value |
|-------|-----------|
| BBBB | 00 |
| BBBY | 01 |
| BBBC | 10 |
| BBBR | 11 |
| BBYB | 02 |
| BBYY | 03 |
| BBYC | 12 |
| BBYR | 13 |
| BBCB | 20 |
| BBCY | 21 |
| BBCC | 30 |
| BBCR | 31 |
| BBRB | 22 |
| BBRY | 23 |
| BBRC | 32 |
| BBRR | 33 |
| BYBB | 04 |
| BYBY | 05 |
| BYBC | 14 |
| BYBR | 15 |
| BYYB | 06 |
| BYYY | 07 |
| BYYC | 16 |
| BYYR | 17 |
| BYCB | 24 |
| BYCY | 25 |
| BYCC | 34 |
| BYCR | 35 |
| BYRB | 26 |
| BYRY | 27 |
| BYRC | 36 |
| BYRR | 37 |
| BCBB | 40 |
| BCBY | 41 |
| BCBC | 50 |
| BCBR | 51 |
| BCYB | 42 |
| BCYY | 43 |
| BCYC | 52 |
| BCYR | 53 |
| BCCB | 60 |
| BCCY | 61 |
| BCCC | 70 |
| BCCR | 71 |
| BCRB | 62 |
| BCRY | 63 |
| BCRC | 72 |
| BCRR | 73 |
| BRBB | 44 |
| BRBY | 45 |
| BRBC | 54 |
| BRBR | 55 |
| BRYB | 46 |
| BRYY | 47 |
| BRYC | 56 |
| BRYR | 57 |
| BRCB | 64 |
| BRCY | 65 |
| BRCC | 74 |
| BRCR | 75 |
| BRRB | 66 |
| BRRY | 67 |
| BRRC | 76 |
| BRRR | 77 |
| YBBB | 08 |
| YBBY | 09 |
| YBBC | 18 |
| YBBR | 19 |
| YBYB | 0A |
| YBYY | 0B |
| YBYC | 1A |
| YBYR | 1B |
| YBCB | 28 |
| YBCY | 29 |
| YBCC | 38 |
| YBCR | 39 |
| YBRB | 2A |
| YBRY | 2B |
| YBRC | 3A |
| YBRR | 3B |
| YYBB | 0C |
| YYBY | 0D |
| YYBC | 1C |
| YYBR | 1D |
| YYYB | 0E |
| YYYY | 0F |
| YYYC | 1E |
| YYYR | 1F |
| YYCB | 2C |
| YYCY | 2D |
| YYCC | 3C |
| YYCR | 3D |
| YYRB | 2E |
| YYRY | 2F |
| YYRC | 3E |
| YYRR | 3F |
| YCBB | 48 |
| YCBY | 49 |
| YCBC | 58 |
| YCBR | 59 |
| YCYB | 4A |
| YCYY | 4B |
| YCYC | 5A |
| YCYR | 5B |
| YCCB | 68 |
| YCCY | 69 |
| YCCC | 78 |
| YCCR | 79 |
| YCRB | 6A |
| YCRY | 6B |
| YCRC | 7A |
| YCRR | 7B |
| YRBB | 4C |
| YRBY | 4D |
| YRBC | 5C |
| YRBR | 5D |
| YRYB | 4E |
| YRYY | 4F |
| YRYC | 5E |
| YRYR | 5F |
| YRCB | 6C |
| YRCY | 6D |
| YRCC | 7C |
| YRCR | 7D |
| YRRB | 6E |
| YRRY | 6F |
| YRRC | 7E |
| YRRR | 7F |
| CBBB | 80 |
| CBBY | 81 |
| CBBC | 90 |
| CBBR | 91 |
| CBYB | 82 |
| CBYY | 83 |
| CBYC | 92 |
| CBYR | 93 |
| CBCB | A0 |
| CBCY | A1 |
| CBCC | B0 |
| CBCR | B1 |
| CBRB | A2 |
| CBRY | A3 |
| CBRC | B2 |
| CBRR | B3 |
| CYBB | 84 |
| CYBY | 85 |
| CYBC | 94 |
| CYBR | 95 |
| CYYB | 86 |
| CYYY | 87 |
| CYYC | 96 |
| CYYR | 97 |
| CYCB | A4 |
| CYCY | A5 |
| CYCC | B4 |
| CYCR | B5 |
| CYRB | A6 |
| CYRY | A7 |
| CYRC | B6 |
| CYRR | B7 |
| CCBB | C0 |
| CCBY | C1 |
| CCBC | D0 |
| CCBR | D1 |
| CCYB | C2 |
| CCYY | C3 |
| CCYC | D2 |
| CCYR | D3 |
| CCCB | E0 |
| CCCY | E1 |
| CCCC | F0 |
| CCCR | F1 |
| CCRB | E2 |
| CCRY | E3 |
| CCRC | F2 |
| CCRR | F3 |
| CRBB | C4 |
| CRBY | C5 |
| CRBC | D4 |
| CRBR | D5 |
| CRYB | C6 |
| CRYY | C7 |
| CRYC | D6 |
| CRYR | D7 |
| CRCB | E4 |
| CRCY | E5 |
| CRCC | F4 |
| CRCR | F5 |
| CRRB | E6 |
| CRRY | E7 |
| CRRC | F6 |
| CRRR | F7 |
| RBBB | 88 |
| RBBY | 89 |
| RBBC | 98 |
| RBBR | 99 |
| RBYB | 8A |
| RBYY | 8B |
| RBYC | 9A |
| RBYR | 9B |
| RBCB | A8 |
| RBCY | A9 |
| RBCC | B8 |
| RBCR | B9 |
| RBRB | AA |
| RBRY | AB |
| RBRC | BA |
| RBRR | BB |
| RYBB | 8C |
| RYBY | 8D |
| RYBC | 9C |
| RYBR | 9D |
| RYYB | 8E |
| RYYY | 8F |
| RYYC | 9E |
| RYYR | 9F |
| RYCB | AC |
| RYCY | AD |
| RYCC | BC |
| RYCR | BD |
| RYRB | AE |
| RYRY | AF |
| RYRC | BE |
| RYRR | BF |
| RCBB | C8 |
| RCBY | C9 |
| RCBC | D8 |
| RCBR | D9 |
| RCYB | CA |
| RCYY | CB |
| RCYC | DA |
| RCYR | DB |
| RCCB | E8 |
| RCCY | E9 |
| RCCC | F8 |
| RCCR | F9 |
| RCRB | EA |
| RCRY | EB |
| RCRC | FA |
| RCRR | FB |
| RRBB | CC |
| RRBY | CD |
| RRBC | DC |
| RRBR | DD |
| RRYB | CE |
| RRYY | CF |
| RRYC | DE |
| RRYR | DF |
| RRCB | EC |
| RRCY | ED |
| RRCC | FC |
| RRCR | FD |
| RRRB | EE |
| RRRY | EF |
| RRRC | FE |
| RRRR | FF |
