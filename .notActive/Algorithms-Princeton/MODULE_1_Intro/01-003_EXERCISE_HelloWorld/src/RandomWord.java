/* *****************************************************************************
 *  Name:              Alexander Gomez
 *  Coursera User ID:  749357c739894c3fed50b8c38d1578c7
 *  Last modified:     November 7, 2025
 **************************************************************************** */

/* 1st -> Need imports */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {

    public static void main(String[] args) {

        String whatNeeded = null;
        int i = 0;

        while (!StdIn.isEmpty()) {

            String chosenWord = StdIn.readString();
            i++;


            if (StdRandom.bernoulli(1.0 / i)) {

                whatNeeded = chosenWord;

            }

        }

        StdOut.println(whatNeeded);

    }
}
