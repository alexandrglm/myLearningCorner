import time

#class Exercise:
 #   constructor




def Username():
       
    return input("Please, give me your full name: ")

def WhatTimeIsIt():

    thisTime = time.localtime().tm_hour

    if 6 <= thisTime < 12 : return "Morning"
    if 12 <= thisTime < 18 : return "Day"
    if 18 <= thisTime < 21 : return "Evening"
    return "Night"


def Greetings(name, dayPart):



    print(f'Hello {name}! Good {dayPart}!')

name = Username()
dayPart = WhatTimeIsIt()
Greetings(name, dayPart)