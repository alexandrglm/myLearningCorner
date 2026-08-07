# 1.4: Analysis of Algorithms

## Core Questions

As programmers gain experience using computers to solve difficult problems and process large data sets, two fundamental questions arise:

>   **How long will my programme take?**
>   **Why does my programme run out of memory?**

These questions depend on many factors: computer properties, data characteristics, and the algorithm implementation. Despite this complexity, straightforward approaches based on the **scientific method** provide useful answers.

---

## Scientific Method for Algorithm Analysis

The scientific method applies effectively to understanding programme running time:

1. **Observe** some feature with precise measurements
2. **Hypothesize** a model consistent with observations
3. **Predict** events using the hypothesis
4. **Verify** predictions through further observations
5. **Validate** by repeating until hypothesis and observations agree

**Key principles**:
- Experiments must be **reproducible** (others can validate results)
- Hypotheses must be **falsifiable** (provably wrong when incorrect)
- We validate consistency with observations, never absolute correctness

---

## Observing Programme Performance

### Making Quantitative Measurements

**Advantage over natural sciences**: We can simply run the programme—every execution is a scientific experiment relating the programme to the physical world.

### Problem Size and Running Time

**Qualitative observations**:

1. **Problem size** characterises computational difficulty (input size or command-line argument)
2. **Running time increases with problem size**, but by how much?
3. **Running time is often relatively insensitive to input itself**—depends primarily on problem size

When this relationship holds, we focus on quantifying the relationship between problem size and running time.

### Example: ThreeSum

**Problem**: Count triples in N integers that sum to 0.

```java
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }
}
```

**Test input**: 1Mints.txt (1 million random integers)

**Question**: How many triples sum to 0? How does running time relate to problem size N?

---

## Measuring Running Time

### Stopwatch Data Type

**Purpose**: Measure programme running time reliably.

```java
public class Stopwatch {
    private final long start;
    
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
```

**Key advantage**: Enables accurate measurements for experimental data generation.

### Experimental Results

**DoublingTest programme**: Generates random input arrays, doubling size each step, measuring ThreeSum running times.

| N | Time (seconds) |
|---|---|
| 250 | 0.0 |
| 500 | 0.0 |
| 1,000 | 0.1 |
| 2,000 | 0.8 |
| 4,000 | 6.4 |
| 8,000 | 51.1 |

---

## Analysing Experimental Data (p176)

### Log-Log Plot Analysis

Plotting data on **log-log scale** reveals a **straight line with slope 3**, suggesting:

$$\lg(T(N)) = 3 \lg N + \lg a$$

Equivalent to:

$$T(N) = a N^3$$

**Solving for *a***: Using T(8000) = 51.1 seconds:
$$a = 9.98 \times 10^{-11}$$

**Predictive model**:
$$T(N) = 9.98 \times 10^{-11} \cdot N^3$$

**Prediction**: T(16,000) ≈ 408.8 seconds (≈ 6.8 minutes). Actual: 409.3 seconds.

---

## Mathematical Models (p178)

### Knuth's Insight

Despite complicating factors, it is possible to build mathematical models describing programme running time.

**Two primary factors determine total running time**:

1. **Cost of executing each statement** (computer/compiler/OS property)
2. **Frequency of execution of each statement** (programme/input property)

Multiplying frequencies by costs and summing for all instructions yields running time.

### Tilde Approximations

Frequency analyses produce complex mathematical expressions. **Tilde notation (~)** simplifies by ignoring low-order terms:

**Definition**: $g(N) \sim f(N)$ indicates $g(N)/f(N) \to 1$ as $N \to \infty$.

**Example**: 
$$\frac{N^3}{6} - \frac{N^2}{2} - \frac{N}{3} \sim \frac{N^3}{6}$$

**Typical tilde approximations**:

| Function | Tilde Approximation | Order of Growth |
|----------|-------------------|-----------------|
| $N^3/6 - N^2/2 - N/3$ | $\sim N^3/6$ | $N^3$ |
| $N^2/2 - N/2$ | $\sim N^2/2$ | $N^2$ |
| $\lg N + 1$ | $\sim \lg N$ | $\lg N$ |
| $3$ | $\sim 3$ | $1$ |

### Common Orders of Growth

| Order | Description | Function |
|-------|---|----------|
| 1 | Constant | Constant |
| $\lg N$ | Logarithmic | Binary logarithm |
| $N$ | Linear | Linear |
| $N \lg N$ | Linearithmic | Divide and conquer |
| $N^2$ | Quadratic | Nested loops |
| $N^3$ | Cubic | Triple nested loops |
| $2^N$ | Exponential | Exhaustive search |

---

## Anatomy of ThreeSum Analysis (p181)

**Statement frequencies**:

| Statement | Block | Frequency | Total Time |
|-----------|-------|-----------|-----------|
| E: `cnt++` | $t_0$ | *x* (input-dependent) | $t_0 x$ |
| D: `if` test | $t_1$ | $N^3/6 - N^2/2 - N/3$ | $t_1(N^3/6 - N^2/2 - N/3)$ |
| C: `for k` | $t_2$ | $N^2/2 - N/2$ | $t_2(N^2/2 - N/2)$ |
| B: `for j` | $t_3$ | $N$ | $t_3 N$ |
| A: `for i` | $t_4$ | $1$ | $t_4$ |

**Grand total** (assuming *x* small):
$$\sim \frac{t_1}{6} N^3$$

**Order of growth**: $N^3$

**Inner loop**: The statements executed most frequently dominate running time.

---

## Cost Models and Propositions (p182)

### Cost Model

A **cost model** defines basic operations for algorithms solving specific problems.

**Example (3-sum)**: Count **array accesses** (reads/writes).

### Proposition B

**The brute-force 3-sum algorithm uses $\sim N^3/2$ array accesses.**

**Proof**: Algorithm accesses 3 numbers for each of $\sim N^3/6$ triples.
$$3 \times \frac{N^3}{6} = \frac{N^3}{2}$$

---

## Developing Running Time Models

**Steps**:

1. **Develop input model** (problem size definition)
2. **Identify inner loop** (most-executed statements)
3. **Define cost model** (operations in inner loop)
4. **Determine execution frequency** (mathematical analysis required)

### Binary Search Example

- **Input model**: Array of size N
- **Inner loop**: Single while loop statements
- **Cost model**: Compare operation
- **Analysis**: At most $\lg N + 1$ compares

### Whitelist Example

- **Input model**: N whitelist numbers, M standard input numbers (M >> N)
- **Inner loop**: While loop in binary search
- **Cost model**: Compare operation
- **Analysis**: At most $M(\lg N + 1)$ compares
- **Order of growth**: $M \lg N$

---

## Order-of-Growth Classifications (p186)

### Constant Time - 1

```java
a = b + c;
```

Programme executes fixed operations; running time independent of N.

### Logarithmic - lg N

```java
// Binary search (see page 47)
```

Barely slower than constant. Base of logarithm irrelevant for order of growth.

### Linear - N

```java
double max = a[0];
for (int i = 1; i < N; i++)
    if (a[i] > max) max = a[i];
```

Constant time per input element. Running time proportional to N.

### Linearithmic - N lg N

```java
// Mergesort (Algorithm 2.4)
// Quicksort (Algorithm 2.5)
```

Prototypical: divide-and-conquer algorithms.

### Quadratic - N²

```java
for (int i = 0; i < N; i++)
    for (int j = i+1; j < N; j++)
        if (a[i] + a[j] == 0)
            cnt++;
```

Two nested loops processing all pairs.

### Cubic - N³

```java
for (int i = 0; i < N; i++)
    for (int j = i+1; j < N; j++)
        for (int k = j+1; k < N; k++)
            if (a[i] + a[j] + a[k] == 0)
                cnt++;
```

Three nested loops (e.g., ThreeSum).

### Exponential - 2^N

Extremely slow; impractical for large N. Critical in algorithm theory.


| Description       | Order of Growth | Typical Code Framework | Example                                                                                                                       |
| ----------------- | --------------- | ---------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| Statement         | Constant        | (1)                    | (a = b + c;)                                                                                                                  |
| Add two numbers   | Logarithmic     | (\log N)               | Divide in half in binary search                                                                                               |
| Find the maximum  | Linear          | (N)                    | `double max = a[0]; for (int i = 1; i < N; i++) if (a[i] > max) max = a[i];`                                                  |
| Mergesort         | Linearithmic    | (N \log N)             | Divide and conquer                                                                                                            |
| Check all pairs   | Quadratic       | (N^2)                  | `for (int i = 0; i < N; i++) for (int j = i+1; j < N; j++) if (a[i] + a[j] == 0) cnt++;`                                      |
| Check all triples | Cubic           | (N^3)                  | `for (int i = 0; i < N; i++) for (int j = i+1; j < N; j++) for (int k = j+1; k < N; k++) if (a[i] + a[j] + a[k] == 0) cnt++;` |
| Check all subsets | Exponential     | (2^N)                  | Exhaustive search                                                                                                             |



---

## Designing Faster Algorithms (p189)

### 2-Sum Problem

**Brute-force**: Quadratic ($N^2$)

**Faster solution**: Sort, then binary search for complements.

```java
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.rank(-a[i], a) > i)
                cnt++;
        return cnt;
    }
}
```

**Running time**: $N \lg N$ (sort) + $N \lg N$ (binary searches) = $N \lg N$

### 3-Sum Problem

**Brute-force**: Cubic ($N^3$)

**Faster solution**: Sort, then for each pair, binary search for complement.

```java
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if (BinarySearch.rank(-a[i]-a[j], a) > j)
                    cnt++;
        return cnt;
    }
}
```

**Running time**: $N^2 \lg N$

### Comparison

| Algorithm | Time Complexity |
|-----------|-----------------|
| TwoSum | $N^2$ |
| TwoSumFast | $N \lg N$ |
| ThreeSum | $N^3$ |
| ThreeSumFast | $N^2 \lg N$ |



---

## Doubling Ratio Experiments (p192)

**Simple shortcut** for predicting performance and determining order of growth:

1. **Develop input generator** (realistic input model)
2. **Run DoublingRatio programme** (calculates ratio of consecutive running times)
3. **Run until ratios approach limit** $2^b$

**Conclusions**:
- Order of growth ≈ $N^b$
- Predict future running times by multiplying last time by $2^b$

### Example (ThreeSum)

| N | Time (s) | Ratio |
|---|----------|-------|
| 250 | 0.0 | 2.7 |
| 500 | 0.0 | 4.8 |
| 1,000 | 0.1 | 6.9 |
| 2,000 | 0.8 | 7.7 |
| 4,000 | 6.4 | 8.0 |
| 8,000 | 51.1 | 8.0 |
| 16,000 | 408.8 | 8.0 |
| 32,000 | 3,270.4 | 8.0 |
| 64,000 | 26,163.2 | 8.0 |

**Ratio approaches 8** → Order of growth ≈ $N^3$ (since $2^3 = 8$)

### Proposition C (Doubling Ratio)

If $T(N) \sim a N^b \lg N$, then:
$$T(2N)/T(N) \sim 2^b$$

---

## Performance Prediction

### Feasibility of Large Problems

**Question**: Will my programme solve this problem in reasonable time?

**Answer**: Use order of growth to extrapolate.

**Example** (programme takes few hours for N):

| Order | Function | Time for 10N | Time (10x faster) |
|-------|----------|-------------|------------------|
| Linear | $N$ | Day | Few hours |
| Linearithmic | $N \lg N$ | Day | Few hours |
| Quadratic | $N^2$ | Few weeks | Day |
| Cubic | $N^3$ | Several months | Few weeks |
| Exponential | $2^N$ | Never | Never |

### Moore's Law Consideration

**Moore's Law**: ~2x speed every 18 months, ~10x every 5 years.

**Problem**: Cannot keep pace with quadratic/cubic algorithms:
- Quadratic: 2x faster computer → solve ~$\sqrt{2}$x larger problems
- Cubic: 2x faster computer → solve $\sqrt[3]{2}$x larger problems
- Doubling ratio test determines if algorithm is quadratic/cubic (ratio ≠ 2)

---

## Caveats and Considerations (p195)

### Large Constants

Ignoring constant coefficients may mislead if constants are large (e.g., $c = 10^6$).

### Nondominant Inner Loop

Assumption that inner loop dominates may fail; cost model may need refinement.

### Instruction Time Variation

Modern systems use **caching**; accessing elements in huge arrays takes longer if non-contiguous.

### System Considerations

Multiple programmes compete for resources; results may not be reproducible.

### Input Dependence

Running time may vary widely based on input. Modification of ThreeSum ("does triple exist?") ranges from constant to cubic.

### Multiple Problem Parameters

Algorithms often have multiple parameters. Example: whitelisting has both N (whitelist size) and M (input size).

---

## Handling Input Dependence (p197)

### Input Models

**Approach**: Model input type carefully.

**Challenges**:
- Model may be unrealistic
- Analysis may be mathematically difficult

### Worst-Case Performance Guarantees

**Approach**: Pessimistic view—what's worst-case running time?

**Applications**: Nuclear reactors, pacemakers, vehicle brakes (catastrophic failure risk).

**Proposition D**: Linked-list implementations of Bag, Stack, Queue have **constant-time worst-case** operations.

### Randomised Algorithms (p198)

**Approach**: Introduce randomness for probabilistic guarantees.

**Examples**:
- **Quicksort**: Quadratic worst-case, but linearithmic with randomisation
- **Hashing**: Linear worst-case, but constant-time probabilistically

Guarantees: Chance of failure < chance of computer struck by lightning.

### Amortised Analysis

**Approach**: Spread expensive operation cost across many operations.

**Example**: Resizing array Stack—single push may take linear time, but average is constant.

**Proposition E**: Resizing array Stack has **constant average** array accesses per operation.

---

## Memory Analysis (p200)

### Primitive Types

| Type | Bytes |
|------|-------|
| boolean | 1 |
| byte | 1 |
| char | 2 |
| int | 4 |
| float | 4 |
| long | 8 |
| double | 8 |

### Objects

**Memory = object overhead (16 bytes) + instance variables + padding (multiple of 8)**

**Examples**:
- `Integer`: 24 bytes
- `Date` (3 int): 32 bytes
- `Counter` (String ref + int): 32 bytes

### Linked Lists

**Node** (inner class): 40 bytes (16 overhead + 8 extra + 8 item ref + 8 next ref)

**Stack of N Integers**: 32 + 64N bytes

### Arrays

| Type | Memory |
|------|--------|
| `int[N]` | ~4N |
| `double[N]` | ~8N |
| `Date[N]` | ~40N |
| `double[M][N]` | ~8MN |

### Strings

**String object**: 40 bytes (overhead + 3 ints + array ref)

**String of length N**: 64 + 2N bytes

**Substring**: 40 bytes (reuses character array)

---

## Perspective (p205)

### Balancing Performance and Clarity

**Most common mistake**: Over-optimising prematurely.

**Wisdom**: *"Premature optimisation is the root of all evil"* — C.A.R. Hoare

**Priority order**:
1. **Clear, correct code**
2. **Performance optimisation** (only if significant benefit)

### When to Optimise

**Ignore performance** if:
- Running time negligible (few seconds)
- Improved algorithm development cost exceeds execution time savings

**Pursue optimisation** if:
- Brute-force quadratic algorithm runs for days
- Linear/linearithmic alternative available
- Handling huge problem sizes

---

## Summary

**Key takeaway**: Understanding **order of growth** enables you to predict programme performance, understand computational limitations, and make informed algorithm choices.

Combining **scientific method** (experiments), **mathematical analysis** (cost models), and **empirical validation** provides powerful framework for algorithm analysis and programme optimisation.
