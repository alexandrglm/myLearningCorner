# Bernoulli Algorithm: Reservoir Sampling Guide

## Definitions

The Bernoulli algorithm definito

> A probabilistic method used to select a random element from a stream of data when the total size is unknown. 

> It implements **reservoir sampling**, a technique that ensures each element has an equal probability of being selected.

---

## Mathematical Foundation

### Bernoulli Trial

A Bernoulli trial is a random experiment with exactly two possible outcomes: success or failure.  

The probability of success is *p*, where *0 ≤ p ≤ 1*.

In the exercise `RandomWord` implementation:

#### **Probability of success**

`1.0 / i` (where *i* is the current position)

- **Success**: Replace the stored word with the current word
- **Failure**: Keep the previously stored word

---

### Why This Works: The Key Insight

For uniform random selection from *n* elements:

- The 1st element is always selected (probability = 1/1 = 100%)
- The 2nd element replaces it with probability 1/2 (50%)
- The 3rd element replaces it with probability 1/3 (~33%)
- The *i*-th element replaces it with probability 1/*i*

This ensures that after processing all *n* elements, each element has exactly **1/*n* probability** of being the final selection.

---

### Mathematical Proof (Intuition)

For any element at position *j*:  

- Probability it was selected at position *j*: 
> 1/*j*

- Probability it survived (wasn't replaced) from *j* to *n*: 
> (1 − 1/*j*+1) × (1 − 1/*j*+2) × ... × (1 − 1/*n*)

This product simplifies to:

> (*j* / *j*+1) × (*j*+1 / *j*+2) × ... × (*n*−1 / *n*) = *j* / *n*

So, combined:  

> (1/*j*) × (*j*/*n*) = **1/*n***


Thus, every element has equal probability regardless of position.


---

## Algorithm Implementation

### Code Example Structure

```java
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
```

1. **Initialisation**: `whatNeeded = null`, counter `i = 0`

2. **For each word**: Increment counter `i`

3. **Bernoulli test**: Call `StdRandom.bernoulli(1.0 / i)`
   - Returns `true` with probability 1/*i*
   - Returns `false` with probability 1 − (1/*i*)

4. **Conditional update**: If test succeeds, replace `whatNeeded`

5. **Return**: Output the final selected word


### Time and Space Complexity

- **Time**: O(*n*) — process each element once
- **Space**: O(1) — store only one word regardless of stream size

This is superior to alternatives like storing all elements (O(*n*) space) or processing the entire stream before selection.

---

## Properties and Guarantees

### Uniformity

Every element in the stream has exactly equal probability of selection: 1/*n*, where *n* is the total number of elements processed.

### Online Processing

The algorithm works with **streaming data**—it doesn't require knowing the total size beforehand. This is essential for:

- Processing infinite streams
- Handling data of unknown length
- Memory-efficient sampling


### Independence

Each invocation of the algorithm is independent. Running it twice on the same stream will produce different results (with equal probability distributions).



## Practical Applications

- **Database sampling**: Select a random row from a table without loading all rows

- **Log analysis**: Sample events from continuous log streams

- **A/B testing**: Randomly assign users to test groups as they arrive

- **Randomised algorithms**: Probabilistic data structure initialisation

- **Statistical sampling**: Obtain unbiased samples from large datasets


## REal Limitations

- **Single selection only**: This approach selects one element. For multiple selections, use reservoir sampling with larger reservoir size

- **Probabilistic**: Results vary between runs (by design), as intended.

- **Order-dependent**: Each position has different probability until all elements are processed

- **Requires good RNG**: Depends on quality of `StdRandom.bernoulli()` implementation

---

## `algs4`lib -> BERNOULLI -> `StdRandom` 

### Source & ManDoc
[Here](https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html#bernoulli-double-)


### Package
`edu.princeton.cs.algs4`

#### Class 
`StdRandom`- `edu.princeton.cs.algs4.StdRandom `

```java
public final class StdRandom

extends Object
```

The StdRandom class provides static methods for generating random number from various discrete and continuous distributions, including uniform, Bernoulli, geometric, Gaussian, exponential, Pareto, Poisson, and Cauchy. It also provides method for shuffling an array or subarray and generating random permutations.

**Conventions**. By convention, all intervals are half open. For example, uniformDouble(-1.0, 1.0) returns a random number between -1.0 (inclusive) and 1.0 (exclusive). Similarly, shuffle(a, lo, hi) shuffles the hi - lo elements in the array a[], starting at index lo (inclusive) and ending at index hi (exclusive).

**Performance**. The methods all take constant expected time, except those that involve arrays. The shuffle method takes time linear in the subarray to be shuffled; the discrete methods take time linear in the length of the argument array.

**Additional information**. For additional documentation, see Section 2.2 of Computer Science: An Interdisciplinary Approach by Robert Sedgewick and Kevin Wayne.

**Author:**
*Robert Sedgewick, Kevin Wayne*

