# B1_06: Video Memory distribution
Video class: [Youtube Link](https://youtu.be/sDFBbLqe3X4)    
Materials used: [ 1.T06.distribucionDeLaMemoriaDeVideo.pdf ](https://github.com/alexandrglm/elearning_tools/blob/e11b767d79b3f5c9a20572a333016694d1feeac4/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T06.distribucionDeLaMemoriaDeVideo.pdf)  
***

#### Content:  
- How video memory is distributed.
- Character memory distribution roots.
- Understanding memory lineality and How to organise it.
- Memory map: Placing an object on-screen. 
***

The Amstrad CPC video memory is a fundamental component for controlling the screen.  
It stores pixel data that determines the colors and patterns displayed.  
Understanding how this memory is structured and accessed is key to drawing individual pixels or shapes.  

## Video Memory details
* `Size`: 16,000 bytes.
* `Resolution (Mode 1)`: 320 x 200 pixels.
* `Memory Organization`: The memory **is linear**, starting at address 0x0000 and ends at 0xFFFF. However, the video memory must translate this 1D structure into the 2D representation of the screen.
***

## Memory Organization by Characters
The screen is divided into characters, each representing an 8x8 pixel block.
![image](https://github.com/user-attachments/assets/b84c2d43-3d71-4c7a-bb3a-d2c7dae6aa4f)
    * __Mode 1 Screen Layout__ :  
        - 40 characters wide x 25 characters tall = 1000 characters.  
        - Each character is made up of 8 rows of pixels, requiring 8 bytes.  

## Pixel Row Ordering

* **Linear Arrangement**
   The memory stores pixel rows sequentially for each line across all characters.  
        - First, the first row of all characters is stored.  
        - Then, the second row, and so on, until all 8 rows are stored.  

    Example:  
      ```text
        Row 1: Pixel rows for all characters in the first row of the screen.  
        Row 2: Pixel rows for all characters in the second row of the screen.  
        Each row starts at a specific memory address and continues sequentially.  
      ```

## Address Calculation

Draw a specific pixel or character by calculating the corresponding memory address.  
Example:

- **Horizontal Offset (X)**:
  Each character is 8 pixels wide. Memory advances by 2 bytes per 8 pixels in Mode 1.  

- **Vertical Offset (Y)**:
  Each pixel row is stored sequentially across the width of the screen.  
  Rows are 2048 bytes (0x800) apart in memory.  

#### FORMULAS
##### 1. Base Address for a Row
Example: Row 2 starts at `0x0800`.  

```formula
Base Address = 0x0000 + (Row Number × 0x800)  
```
  
##### 2. Address for a Character or Pixel within a Row:  
Example: Offset adjusts for specific pixels within a byte.  

```formula
Address = Base Address + (Character Column × 2) + Offset  
```
***
## Memory Example
![image](https://github.com/user-attachments/assets/2e275a36-cad8-428e-86c3-19109edaec8f)  
* Row 1: Starts at `0x0000`, ends at `0x07FF`.  
* Row 2: Starts at `0x0800`.  
* Row 3: Starts at `0x1000`.  
* Character Offset: If a character spans **multiple rows, add the offset for each** subsequent row.  
***
## Practical Drawing
#### Drawing Pixels:

    Each byte in memory represents 4 pixels in Mode 1.  
    Colours are determined by the 2 bits per pixel format.  

#### Drawing Rows:

    To draw across multiple rows, add 0x800 for each vertical step.  
***
### Video Memory Map**

## Memory Map table
![image](https://github.com/user-attachments/assets/ae857552-41ad-4403-87c3-70b15d22fe58)
