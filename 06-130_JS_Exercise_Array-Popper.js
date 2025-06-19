// Array-Popper exercise

/*
[1,2,3,4,5]

1
5
2
4
3
shift - pop - shift - pop - shift (END)
*/

class Popper {

    constructor(theArray) {

        this.theArray = theArray
        this.esInicial = true
    }

    popAndShift() {

        this.esInicial = !this.esInicial;

        return this.esInicial ? this.theArray.pop() : this.theArray.shift() 

    }


}


// Instanciacion de la clase
/*
let newArray = [1,2,3,4,5]*/

const ap = new Popper([1,2,3,4,5])

console.log( ap.popAndShift() )
console.log( ap.popAndShift() )
console.log( ap.popAndShift() )
console.log( ap.popAndShift() )
console.log( ap.popAndShift() )


// deberia fallar
console.log( ap.popAndShift() )