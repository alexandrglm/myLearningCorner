# **Amstrad CPC Video Modes and Colour Palettes**
## **Video Modes**

| **Mode** | **Resolution** | **Simultaneous Colors** | **Description**                               |
|----------|----------------|-------------------------|-----------------------------------------------|
| **0**    | 160x200        | 16                     | Low resolution, maximum number of colors, High FPS     |
| **1**    | 320x200        | 4                      | Medium resolution, balanced for most uses.    |
| **2**    | 640x200        | 2                      | High resolution, limited colors.              |
| **3**    | 160x200        | 4                      | Undocumented, Low-res, Low-Color, presumibly so high FPS              |

---

## **Color Palette**

The Amstrad CPC uses a hardware palette of 27 unique colors, encoded as **hardware values (0-31)**.  
This is the mapping of **Firmware values**, **Hardware values**, and their **RGB representation**.

| **Firmware** | **Hardware** | **Color**            | **RGB % (R, G, B)**     |
|--------------|--------------|----------------------|-------------------------|
| 0            | 20 (0x14)    | Black               | 0, 0, 0                 |
| 1            | 4 (0x04)     | Blue                | 0, 0, 50                |
| 2            | 21 (0x15)    | Bright Blue         | 0, 0, 100               |
| 3            | 28 (0x1C)    | Red                 | 50, 0, 0                |
| 4            | 24 (0x18)    | Magenta             | 50, 0, 50               |
| 5            | 29 (0x1D)    | Mauve               | 50, 0, 100              |
| 6            | 12 (0x0C)    | Bright Red          | 100, 0, 0               |
| 7            | 5 (0x05)     | Purple              | 100, 0, 50              |
| 8            | 13 (0x0D)    | Bright Magenta      | 100, 0, 100             |
| 9            | 22 (0x16)    | Green               | 0, 50, 0                |
| 10           | 6 (0x06)     | Cyan                | 0, 50, 50               |
| 11           | 23 (0x17)    | Sky Blue            | 0, 50, 100              |
| 12           | 30 (0x1E)    | Yellow              | 50, 50, 0               |
| 13           | 0 (0x00)     | White               | 50, 50, 50              |
| 14           | 31 (0x1F)    | Pastel Blue         | 50, 50, 100             |
| 15           | 14 (0x0E)    | Orange              | 100, 50, 0              |
| 16           | 7 (0x07)     | Pink                | 100, 50, 50             |
| 17           | 15 (0x0F)    | Pastel Magenta      | 100, 50, 100            |
| 18           | 18 (0x12)    | Bright Green        | 0, 100, 0               |
| 19           | 2 (0x02)     | Sea Green           | 0, 100, 50              |
| 20           | 19 (0x13)    | Bright Cyan         | 0, 100, 100             |
| 21           | 26 (0x1A)    | Lime                | 50, 100, 0              |
| 22           | 25 (0x19)    | Pastel Green        | 50, 100, 50             |
| 23           | 27 (0x1B)    | Pastel Cyan         | 50, 100, 100            |
| 24           | 10 (0x0A)    | Bright Yellow       | 100, 100, 0             |
| 25           | 3 (0x03)     | Pastel Yellow       | 100, 100, 50            |
| 26           | 11 (0x0B)    | Bright White        | 100, 100, 100           |

---

## **Notes**
- **Firmware Colors**: Used by the Amstrad CPC firmware and user programs.  
- **Hardware Colors**: Directly mapped to the PAL chip and Gate Array.  
- Use the **Hardware values** for functions like `cpct_setPalette_asm`.

