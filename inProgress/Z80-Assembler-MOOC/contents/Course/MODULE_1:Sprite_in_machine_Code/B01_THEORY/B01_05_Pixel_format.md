# B1_05: The Pixel Format / Video modes introduction
Video class: [Youtube Link](https://youtu.be/1v2DKEWMKNg)    
Materials used: [ 1.T05.formatoPixeles.pdf ](https://github.com/alexandrglm/elearning_tools/blob/9fbf9fd84dfc8a0c79fb6fee964eee4361816353/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T03.laMagiaDelHexadecimal.pdf)  
***

#### Content:  
- What a pixel format is / What is used for.  
- Pixel format examples.  
- Video mode 1 pixel format on AMSTRAD CPC.  
- Coding examples
- Tips and tricks for a fast conversion.  
***

## Pixel format
- The set of rules for storing pixel data in memory so it can be interpreted correctly by the CRTC.  
- It **encodes pixel colour in memory** to be shown on-screen.  
- There are many pixel formats availables, each with different characteristics, mainly focused on memory usage efficiency.  
![image](https://github.com/user-attachments/assets/70252140-60f7-4292-8f20-5e6e2dde4365)

***
## Pixel Stoarage in Video Memory
### Case 1: 1 byte = 1 pixel
* Each byte represents a single pixel, and each value in the byte corresponds to a specific characteristic, as colour.    
⚠️ For a given resolution of 320x200 pixels, this format would require 64 KB of memory, which is inefficient on systems like the CPC with 64 KB total memory.  

### Case 2: 2 Bits = 1 pixel (AMSTRAD CPC Video Mode 1)
* Each pixel is represented by 2 bits, allowing 1 byte to store data for 4 pixels.  
✅ On the memory sage side, this requires only 16 KB for video memory, leaving more space for other system functions, so it's completely allowed to be used in this AMSTRAD system.  
***
## Mode 1 Pixel Format (Amstrad CPC) - A deeper introduction.
![image](https://github.com/user-attachments/assets/6ef9f919-5a26-4c2c-95c7-3d1893923600)

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
- **Bits for each pixel are interleaved and not stored sequentially** (e.g., pixel 1 uses bits 7 and 3, pixel 2 uses bits 6 and 2).  
- Bits are read **right-to-left**, which determines their association with colours.  
***
# Encoding Pixels
## The enconding process
This examples follows a 4-pixels encoding process:  

    1. Identify the colour for each pixel (e.g., yellow, yellow, cyan, cyan).  
    2. Map the color to its 2-bit representation.  
    3. Place the bits in their correct positions within the byte:  
        * Pixel 1 (Yellow): Bits 7 and 3 → 01. 
        * Pixel 2 (Yellow): Bits 6 and 2 → 01.  
        * Pixel 3 (Cyan): Bits 5 and 1 → 10.  
        * Pixel 4 (Cyan): Bits 4 and 0 → 10.  

**Resulting Byte (Binary)**: `01011010`  
**Hexadecimal Representation**: **5A**  
***
# Tips & Tricks
## Practical Approach to Encoding Pixels

### **CASE 1: Simplified Method for Encoding `01011010`**

In **Mode 1**, a byte can represent 4 pixels, where each pixel is encoded using **2 bits**.  
These bits are divided into two **4-bit groups**, each corresponding to a **hexadecimal digit**.
***

### **Step-by-Step Encoding**
This simplified method allows you to treat the byte as two independent hexadecimal digits, making it easier to encode pixel colors into memory.  
With practice, hexadecimal encoding can be performed directly without converting to binary at every step.  

1. **Pixel colours  →  Their Binary Values**:  
   - Red → `11`  
   - Yellow → `01`  
   - Cyan → `10`  

2. **Bit Mapping and Hexadecimal Digits**:  
   - Each pixel's bits are placed in specific positions within the byte:  
     - **Left Hex Digit (Bits 7-4):** Red (`11`), Yellow (`01`) → **`5`**  
     - **Right Hex Digit (Bits 3-0):** Cyan (`10`), Cyan (`10`) → **`A`**  

3. **Final Byte Calculation**:  
   - Combine the two hex digits to form the byte: **`5A`**  
   - Binary Representation: **`01011010`**


| **Pixel Order**      | 1     | 2      | 3     | 4      |
|-----------------------|-------|--------|-------|--------|
| **Pixel Color**       | Red   | Yellow | Cyan  | Cyan   |
| **Binary Value (Bits)** | `11`  | `01`   | `10`  | `10`   |

| **Bits (Binary)**     | `0101` | `1010` |
|-----------------------|--------|--------|
| **Hex Digits**        | `5`    | `A`    |

---

### Remember:

💡👉 **Mode 1 pros**  
Optimizes memory by storing 4 pixels per byte.  
Supports 4 colors, balancing visual quality against the system limitations.  
  
💡👉 **Direct Hex Encoding**  
Direct encoding in hexadecimal can simplify the process with practice.  
  
💡👉 **Interleaved Bits**   
Bits for pixels are not sequential.  
  
💡👉 **Right-to-left Reading**  
Pixel order requires careful attention during encoding.  
  
💡👉 **Efficiency vs. Complexity**  
The format can optimize memory usage but increasing programming complexity.  

 
