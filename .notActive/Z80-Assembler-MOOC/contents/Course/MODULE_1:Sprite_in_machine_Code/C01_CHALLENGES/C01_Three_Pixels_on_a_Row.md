![image](https://github.com/user-attachments/assets/1737d72c-532f-40b1-bf65-e15c5c62783d)  
![image](https://github.com/user-attachments/assets/4fec4339-8ccc-45e3-a5bd-3159e77b1d65)



```text
3E - 08 CYAN - BLUE BLUE BLUE on MEM. ADDRESS C2D3
+
3E - 88 RED/BLUE/BLUE/BLUE on MEM. ADDRESS C2D5
+
3E - 80 YELLOW/BLUE/BLUE/BLUE on MEM. ADDRESS C2D7
+
JUMP RELATIVE the FE -> Infinite Loop
+
Set the PC on 4000:

```
```hex
4000: 3E 08 32 D3 C2 3E 88 32 D5 C2 3E 80 32 D7 C2 18
4001:  FE 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
```

```asm
ld a,#08
ld #C2D3, a
ld a,#88
ld #C2D5, a
ld a,#80
ld #C2D7,a
jr  loop
```

***
# Drafts & Garbage
![image](https://github.com/user-attachments/assets/79e09eab-ef88-47b1-b880-d78311ea1401)
    3 pixes,  separados en la misma fila.
    Debajo de 3 letras.
    De 3 colores distintos.

1. Colours:    R - C - Y
3E 88 - 3E 08 - 3E 80

2. Positions:    32 XX YY
`A` - `M`  - `S`
`A` = C0FE - A init
`A` = C100

- 32 


1100 0000
1000 1000
88

1000 0000
0000 1000
08

0100 0000
1000 0000
80


## Drafts
4000:  3E 88 32 00 C0 18 FE 00 00 00 00 00 00 00 00 00
4010:  00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00

# Positions
Top-Left 0x0 ->    C000  

~~**XX-YY - HORIZONTAL - VERTICAL**~~
![image](https://github.com/user-attachments/assets/65d64634-2f00-4ace-a56a-3fe543542735)  

C000 0% X 0%  
C200 30% X 40%  
C205 
![image](https://github.com/user-attachments/assets/db8de0ec-9dd6-43f5-b780-4a9666c75ae6)

***
### Drafts *test&try*
1. 
4000:  3E 88 32 10 D0 18 FE 00 00 00 00 00 00 00 00 00
Posición 10 D0 
![image](https://github.com/user-attachments/assets/ddb2f250-8635-4be8-bbbf-48cdaed3ee91)  

2.  11 D0 position  
![image](https://github.com/user-attachments/assets/6bb58126-27da-4974-9f6a-aaa0881e4fe8)  

3.  1A D0 position  
![image](https://github.com/user-attachments/assets/cb5b57a9-c63c-4d69-a65b-41794df13f6f)  

4. 00 D5 Vertical media pantalla
5. 
***

# Colours
ld a, nn = 32
NN block -> Hex1+Hex2 = 4pixels/block
88 = Red - Empty - Empty - Empty
44 = Red - Empty - Empty - Empty
22 = Red - Empty - Empty - Empty
84 = Yellow - Cyan - Empty - Empty
8A = Red - Empty - Cian - Empty
12 = Cyan - Yellow - Empty - Empty
00 = Empty all



8x = Red - Empty
A8 = Red - Empty - Yellow - Empty


Four colors (mode1):
00 	Dark Blue
01 	Yellow
10 	Cyan
11 	Red

~~Example 1:~~
~~Red - Blue("Transparent" as screen bg is the same blue) - Red - Yellow~~
~~1 0 1 1  1 0 1 0~~
~~B A~~
~~ld a,#BA~~
~~3E BA~~

~~Example 2: **WRONG**~~
~~Yellow - Cyan - Red - Yellow~~

~~0110 1101~~
~~6D~~
 ~~**6D is Cyan - Red - Yellow - Cyan**~~

 00    B
 01    Y
 10    C    
 11    R

#### Test 1: **OK**

R - Y - C - C  
11 - 01 - 10 - 10  
11011010  
1 1 0 0   1 0 1 1  
CB  
![image](https://github.com/user-attachments/assets/cb2e19d7-35ff-4802-a3ea-4264dab30254)  


#### Test 2  : **WRONG**
Y - R - R - B  
0111 1100  
1110   0110  
E6  
**E6 es B Y R R**  
**EN vez de darles la vuelta en binario, dales la vuelta en el primer paso**  


#### Test 3
R R R R    
11 11 11 11  
FF  

#### Test 4
B B B B  
0000 0000  
00  

#### Test 5
C C C C  
1010 1010  
0000    1111  
0F  

#### Test 6
Y Y Y Y
01 01 01 01
1111    0000
F0

#### Test 7
R Y Y R  
1101 0111
1111    1001
F9

#### Test 8 
C Y R Y  
1001 1101
0111 1010
7A



Aid 1: Bin to hex memorising table, then, practicing, conversions will be automatically calculated

| Base2  | Base16 |
|-----------|-------------|
| 0000      | 0           |
| 0001      | 1           |
| 0010      | 2           |
| 0011      | 3           |
| 0100      | 4           |
| 0101      | 5           |
| 0110      | 6           |
| 0111      | 7           |
| 1000      | 8           |
| 1001      | 9           |
| 1010      | A           |
| 1011      | B           |
| 1100      | C           |
| 1101      | D           |
| 1110      | E           |
| 1111      | F           |


