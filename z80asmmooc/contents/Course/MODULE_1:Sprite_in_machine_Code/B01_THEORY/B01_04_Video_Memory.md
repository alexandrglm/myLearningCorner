# B1_04: Video Memory introduction
Video class: [Youtube Link](https://youtu.be/ljKnt2rmpeI)  
Materials used: [ 1.T04.laMemoriaDeVideo.pdf ](https://github.com/alexandrglm/elearning_tools/blob/9fbf9fd84dfc8a0c79fb6fee964eee4361816353/z80asmmooc/contents/Course/MODULE_1%3ASprite_in_machine_Code/B01_THEORY/B01_materials/1.T03.laMagiaDelHexadecimal.pdf)
***

#### Content:  
- What video memory is and how it works (AMSTRAD CPC related).
- How a CRT screen works.
- Refresh rate: The delay while video-mem. manipulating and its on-screen appearance.
- Common related issues / Becoming a virtue from the deffective (i)
***

# Definitions, Components, Functionality
Video memory stores datasets that are read by the *CRCT* (Cathode Ray Tube Controller) to send visual information to the monitor. 
This is a universal concept in computing, though the organization and formats may vary between systems.
![image](https://github.com/user-attachments/assets/69e97767-000c-43d0-85f5-1be4374a34b7)  

The Amstrad CPC integrates its computer within the keyboard, while the monitor is a separate electronic device connected via a cable.  
The *CRCController* chip on the motherboard constantly sends data from video memory to the monitor to create the desired objects to be displayed.  

A specific area of RAM, starting at address 0000 (Remember, a 8-bit data adresses bus), is designated as video memory.  
Changing this memory alters what is displayed on the screen.  
  
So, the **CRCController*ontroller* :
      
      1. Reads this memory.
      2. Decodes the data into pixels.
      3. Sends them to the monitor. 

## Shared Memory Access:

Both the CPU and *CRCController* share video memory. When the CPU writes to this memory, the next time the *CRCController* reads it, the updated data is displayed.
***

# Technical Diagram: Workflow

## Data Flow
![image](https://github.com/user-attachments/assets/83bff7ec-ac82-4a8a-9b15-51790fec2295)  
    
    1. CPU → Writes data to video memory.  
    2. *CRCController* → Reads video memory → Decodes data into pixels → Sends data to the monitor.  
    3. Monitor → Displays the decoded image.  

## Refresh Mechanism:
The *CRCController* refreshes the screen 50 times per second (50 Hz), redrawing the entire screen line by line.  
![image](https://github.com/user-attachments/assets/f5325f00-4ea9-40b2-9533-3c6deba20765)  
Modifications in memory are not instantly visible on-screen.  
The update appears after the *CRCController* completes a full screen refresh cycle.  

***
# Use case: Understanding the Video Memory

### *CRCController* and Memory Interaction
- Writing specific values into video memory determines the color and position of pixels on the screen.  
- The *CRCController* decodes these values and translates them into visual information.  

### Screen Refresh Optimization
Managing memory updates during non-drawing phases of the refresh cycle (e.g., vertical blanking) helps avoid flickering and ensures smooth graphics.
***
# Becoming a virtue from the deffect

⚠️ Graphical performance can be affected or **improved** by taking in count what defectives technical limitations the CRT screens have.

## Delayed Updates:
Changes to video memory are visible only after the screen refreshes, creating a small delay.  


## Flickering:
Occurs when video memory is modified while the *CRCController* is drawing the same region.  
This may result in incomplete or mixed visual updates.  
For instance, half of a sprite might display updated data, while the other half shows the previous state.
