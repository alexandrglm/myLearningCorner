# B1_05: The Pixel Format / Video modes introduction
Video class: [Youtube Link](https://youtu.be/1v2DKEWMKNg)    
Materials used: [ 1.T05.formatoPixeles.pdf ](https://github.com/alexandrglm/elearning_tools/blob/9fbf9fd84dfc8a0c79fb6fee964eee4361816353/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T03.laMagiaDelHexadecimal.pdf)  
***

#### Content:  
- What a pixel format is / What is used for.  
- Pixel format examples.  
- Video mode 1 pixel format on AMSTRAD CPC.  
- Coding examples / Tips and tricks for a fast conversion.  
***

## Pixel format
- The set of rules for storing pixel data in memory so it can be interpreted correctly by the CRTC.
- It **encodes pixel colour in memory** to be shown on-screen.
- There are many pixel formats availables, each with different characteristics, mainly focused on memory usage efficiency.
***
## Pixel Stoarage in Video Memory
### Case 1: 1 byte = 1 pixel
* Each byte represents a single pixel, and each value in the byte corresponds to a specific characteristic, as colour.  
⚠️ For a resolution of 320x200 pixels, this format would require 64 KB of memory, which is inefficient on systems like the CPC with 64 KB total memory.

### Case 2: 2 Bits = 1 pixel (AMSTRAD CPC Video Mode 1)
* Each pixel is represented by 2 bits, allowing 1 byte to store data for 4 pixels.
✅ On the memory sage side, this requires only 16 KB for video memory, leaving more space for other system functions, so it's completely allowed to be used in this AMSTRAD system.
***
## Mode 1 Pixel Format (Amstrad CPC) - A deeper introduction.
### Mode 1 Overview:
#### Encoding Structure:
- Uses 2 bits per pixel, enabling 4 pixels to fit in 1 byte.
- Supports 4 colours palette, with each combination of 2 bits representing a specific colour:

| **Bits** | **colour**     |
|----------|---------------|
| `00`     | Dark Blue     |
| `01`     | Yellow        |
| `10`     | Cyan          |
| `11`     | Red           |

#### Storage Structure
- Bits for each pixel are interleaved and not stored sequentially (e.g., pixel 1 uses bits 7 and 3, pixel 2 uses bits 6 and 2).
- Bits are read **right-to-left**, which determines their association with colours.
***


