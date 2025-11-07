# 1.4: Q&A, Exercises & Experiments

---

## Questions and Answers

### Debugging and Testing

**Q: Why not use StdRandom to generate random values instead of maintaining the file 1Mints.txt?**

A: Easier debugging and experiment reproducibility. StdRandom produces different values each call, so re-running after bug fixes may not validate the fix. Whilst `initialize()` in StdRandom addresses this, reference files like 1Mints.txt simplify test case addition during debugging. Enables different programmers to compare performance across computers without input model concerns. Post-debugging, test on random data (e.g., DoublingTest, DoublingRatio use this approach).

---

### Experimental Consistency

**Q: I ran DoublingRatio on my computer, but results were inconsistent. Some ratios weren't close to 8. Why?**

A: Discussed in "caveats" section. Most likely, the operating system performed other tasks during experiments. Mitigation: invest more experimental time. Modify DoublingTest to run 1,000 times per N value, yielding much more accurate running time estimates (see Exercise 1.4.39).

---

### Tilde Notation Formalism

**Q: What exactly does "as N grows" mean in the tilde notation definition?**

A: Formal definition: $f(N) \sim g(N)$ means $\lim_{N \to \infty} \frac{f(N)}{g(N)} = 1$

---

### Big-Oh Notation

**Q: I've seen other notations for describing order of growth. What's the story?**

A: **Big-Oh notation** is widely used: $f(N)$ is $O(g(N))$ if constants $c$ and $N_0$ exist such that $|f(N)| < c \cdot g(N)$ for all $N > N_0$.

**Useful for**: Asymptotic upper bounds on algorithm performance (important in algorithm theory).

**Not useful for**: Performance prediction or algorithm comparison.

---

### Why Big-Oh Limitations

**Q: Why not use Big-Oh for performance prediction?**

A: Describes **only upper bounds**—actual performance may be much better. Algorithm running time might be both $O(N^2)$ and $\sim a N \log N$. Cannot justify doubling ratio tests (Proposition C).

---

### Big-Oh Prevalence

**Q: Why is Big-Oh notation so widely used?**

A: Facilitates order-of-growth bounds even for complicated algorithms lacking feasible precise analysis. Compatible with **Big-Omega** ($\Omega$) and **Big-Theta** ($\Theta$) notations:

- **Big-Omega**: $f(N)$ is $\Omega(g(N))$ if constants $c, N_0$ exist with $|f(N)| > c \cdot g(N)$ for $N > N_0$
  - Describes **lower bounds** on worst-case performance
  
- **Big-Theta**: $f(N)$ is $\Theta(g(N))$ if $f(N)$ is both $O(g(N))$ and $\Omega(g(N))$
  - Describes **optimal algorithms** (no better asymptotic performance possible)

---

### Precise vs Upper Bounds

**Q: Aren't upper bounds on asymptotic performance important?**

A: Yes, but we prefer **precise results** using cost models because they provide superior algorithm performance information and are derivable for discussed algorithms.

**Examples**:
- Better: *"ThreeSum uses ~N³/2 array accesses"*
- Better: *"cnt++ executes ~N³/6 times (worst case)"*
- Weaker: *"ThreeSum running time is O(N³)"*

---

### Linearithmic Algorithm Detection

**Q: When order of growth is N log N, doubling tests yield hypothesis ~aN (linear). Problem?**

A: Not really problematic for performance prediction. Between N=16,000 and N=32,000, plots of $14N$ and $N \lg N$ are very similar—data fits both. As N increases, curves converge. Careful experimentation required to confirm linearithmic (not linear) running time.

---

### Array Initialisation Cost

**Q: Does int[] a = new int[N] count as N array accesses (zero-initialisation)?**

A: Most likely yes—assumption used throughout this book. Sophisticated compiler implementations might optimise away this cost for huge sparse arrays.

---

## Exercises

### Exercise 1.4.1: Triple Counting Formula

**Problem**: Show that the number of different triples from N items is precisely $\frac{N(N-1)(N-2)}{6}$.

**Hint**: Use mathematical induction.

---

### Exercise 1.4.2: ThreeSum with Overflow Handling

**Problem**: Modify ThreeSum to work correctly when int values are so large that adding two might cause overflow.

---

### Exercise 1.4.3: Plotting with StdDraw

**Problem**: Modify DoublingTest to use StdDraw, producing standard and log-log plots from text, rescaling so plot fills substantial window portion.

---

### Exercise 1.4.4: TwoSum Analysis Table

**Problem**: Develop a table like page 181 (statement execution frequencies) for TwoSum.

---

### Exercise 1.4.5: Tilde Approximations

**Problem**: Give tilde approximations for:

a) $N - 1$ → $\sim N$

b) $1 - 1/N$ → $\sim 1$

c) $(1 - 1/N)(1 - 2/N)$ → $\sim 1$

d) $2N^3 - 15N^2 - N$ → $\sim 2N^3$

e) $\lg(2N) / \lg N$ → $\sim 1 + \lg 2 / \lg N$ → $\sim 1$

f) $\lg(N^2 + 1) / \lg N$ → $\sim 1 + \lg 1 / \lg N$ → $\sim 1$

g) $N^{100} / 2^N$ → $\sim 0$ (exponential dominates polynomial)

---

### Exercise 1.4.6: Code Fragment Order of Growth

**Problem**: Give order of growth as function of N for code fragment running times:

**a)**
```java
int sum = 0;
for (int n = N; n > 0; n /= 2)
    for(int i = 0; i < n; i++)
        sum++;
```
**Answer**: $N + N/2 + N/4 + \ldots + 1 = 2N - 1$ → $\sim N$ (linear)

**b)**
```java
int sum = 0;
for (int i = 1; i < N; i *= 2)
    for (int j = 0; j < i; j++)
        sum++;
```
**Answer**: $1 + 2 + 4 + \ldots + N = 2N - 1$ → $\sim N$ (linear)

**c)**
```java
int sum = 0;
for (int i = 1; i < N; i *= 2)
    for (int j = 0; j < N; j++)
        sum++;
```
**Answer**: $\lg N$ outer iterations, each with $N$ inner iterations → $\sim N \lg N$ (linearithmic)

---

### Exercise 1.4.7: ThreeSum Arithmetic Operations

**Problem**: Analyse ThreeSum under cost model counting arithmetic operations and comparisons involving input numbers.

---

### Exercise 1.4.8: Equal Pairs Program

**Problem**: Determine number of pairs in input file that are equal.

**Constraint**: If brute-force quadratic, use `Arrays.sort()` for linearithmic solution.

---

### Exercise 1.4.9: Doubling Ratio Prediction Formula

**Problem**: Give formula predicting programme running time for problem size N when:
- Doubling factor: $2^b$
- Running time for size $N_0$: $T$

**Answer**: $T(N) = T \cdot 2^{b(\log_2(N/N_0))} = T \cdot (N/N_0)^b$

---

### Exercise 1.4.10: Binary Search Modification

**Problem**: Modify binary search to always return smallest index matching search element (maintain logarithmic running time).

---

### Exercise 1.4.11: StaticSETofInts Extension

**Problem**: Add instance method `howMany()` to StaticSETofInts finding occurrence count for given key in time $\propto \log N$ (worst case).

---

### Exercise 1.4.12: Common Elements in Sorted Arrays

**Problem**: Given two sorted N-integer arrays, print all elements appearing in both, in sorted order. Running time: $\propto N$ (worst case).

---

### Exercise 1.4.13: Memory Requirements

**Problem**: Using text assumptions, give memory needed for object representations:

a) Accumulator
b) Transaction
c) FixedCapacityStackOfStrings (capacity C, N entries)
d) Point2D
e) Interval1D
f) Interval2D
g) Double

---

## Creative Problems

### Problem 1.4.14: 4-Sum Algorithm

Develop an algorithm for the **4-sum problem** (find all 4-tuples summing to 0).

---

### Problem 1.4.15: Faster 3-Sum

**Warmup**: Develop `TwoSumFaster` using linear algorithm (after sorting) instead of binary-search linearithmic approach.

**Main**: Apply similar idea for quadratic 3-sum algorithm.

---

### Problem 1.4.16: Closest Pair (1D)

**Problem**: Given array $a[]$ of N double values, find **closest pair**—two values with smallest difference.

**Requirement**: Linearithmic worst-case running time.

---

### Problem 1.4.17: Farthest Pair (1D)

**Problem**: Given array $a[]$ of N double values, find **farthest pair**—two values with largest difference.

**Requirement**: Linear worst-case running time.

---

### Problem 1.4.18: Local Minimum in Array

**Problem**: Given array $a[]$ of N distinct integers, find **local minimum**: index $i$ where $a[i-1] < a[i] < a[i+1]$.

**Requirement**: $\sim 2 \lg N$ comparisons (worst case).

**Answer**: Examine middle $a[N/2]$ and neighbours. If local minimum, stop; else search half with smaller neighbour.

---

### Problem 1.4.19: Local Minimum in Matrix

**Problem**: Given N×N array of N² distinct integers, find **local minimum**: pair $(i,j)$ where:
$$a[i][j] < a[i+1][j], \quad a[i][j] < a[i][j+1], \quad a[i][j] < a[i-1][j], \quad a[i][j] < a[i][j-1]$$

**Requirement**: $\propto N$ (worst case).

---

### Problem 1.4.20: Bitonic Search

**Problem**: **Bitonic array**: increasing sequence immediately followed by decreasing sequence. Given bitonic N-integer array, determine if given integer exists.

**Requirement**: $\sim 3 \lg N$ comparisons (worst case).

---

### Problem 1.4.21: Binary Search on Distinct Values

**Problem**: Develop binary search for StaticSETofInts where `contains()` running time: $\sim \lg R$ (where R = distinct integers in constructor array).

---

### Problem 1.4.22: Binary Search (Addition/Subtraction Only)

**Problem**: Given ascending-order N distinct-integer array, determine if given integer exists. Constraints: **only addition/subtraction, constant extra memory**.

**Requirement**: $\propto \log N$ (worst case).

**Answer**: Use Fibonacci numbers (exponential growth like powers of 2). Maintain search range $[i, i + F_k]$, keep $F_k, F_{k-1}$ in variables. Each step: compute $F_{k-2}$ by subtraction, check $i + F_{k-2}$, update range to $[i, i+F_{k-2}]$ or $[i+F_{k-2}, i+F_{k-2}+F_{k-1}]$.

---

### Problem 1.4.23: Binary Search for Fraction

**Problem**: Using logarithmic "Is number less than x?" queries, find rational $p/q$ where $0 < p < q < N$.

**Hint**: Fractions with denominators $< N$ cannot differ by more than $1/N^2$.

---

### Problem 1.4.24: Egg Drop (Multiple Eggs)

**Problem**: N-story building, plenty of eggs. Egg breaks if thrown from floor F or higher. Devise strategy determining F such that:
- Broken eggs: $\sim \lg N$
- Throws: $\sim \lg N$

Then reduce cost to $\sim 2\lg F$.

---

### Problem 1.4.25: Egg Drop (Two Eggs Only)

**Problem**: Only two eggs. Cost model: number of throws. Strategy determining F with:
- Throws: $\leq 2\sqrt{N}$

Then reduce to $\sim c\sqrt{F}$.

**Context**: Search hits (egg intact) cheaper than misses (egg broken).

---

### Problem 1.4.26: 3-Collinearity to 3-Sum

**Problem**: Given algorithm finding N collinear point triples, show it solves 3-sum.

**Strong Hint**: $(a, a^3), (b, b^3), (c, c^3)$ are collinear **iff** $a + b + c = 0$.

---

### Problem 1.4.27: Queue via Two Stacks

**Problem**: Implement queue with two stacks—each queue operation: constant amortised stack operations.

**Hint**: Push→pop sequence reverses. Repeat → restores order.

---

### Problem 1.4.28: Stack via Single Queue

**Problem**: Implement stack with single queue—each stack operation: linear queue operations.

**Hint**: Delete: retrieve all queue elements one-at-a-time, append at end (except last—delete/return).

---

### Problem 1.4.29: Steque via Two Stacks

**Problem**: Implement steque (Exercise 1.3.32) with two stacks—constant amortised steque operations.

---

### Problem 1.4.30: Deque via Stack + Steque

**Problem**: Implement deque with stack and steque—constant amortised operations.

---

### Problem 1.4.31: Deque via Three Stacks

**Problem**: Implement deque with three stacks—constant amortised deque operations.

---

### Problem 1.4.32: Amortised Analysis Proof

**Problem**: Prove: starting empty resizing array Stack, M-operation sequence uses array accesses $\propto M$.

---

### Problem 1.4.33: Memory on 32-Bit Machine

**Problem**: Give memory requirements for Integer, Date, Counter, int[], double[], double[][], String, Node, Stack (linked-list) on 32-bit machine.

**Assumptions**: 4-byte references, 8-byte object overhead, 4-byte padding multiple.

---

### Problem 1.4.34: Hot or Cold Guessing

**Problem**: Guess secret integer (1 to N). Feedback: equal (stop), hotter (closer), colder (farther).

**Part 1**: Algorithm with $\leq \sim 2\lg N$ guesses.

**Part 2**: Algorithm with $\leq \sim 1\lg N$ guesses.

---

### Problem 1.4.35: Stack Time Costs

**Problem**: Justify time cost table for pushdown stack implementations:

| Data Structure | Item Type | Push N Values (Data Refs) | Push N Values (Objects) |
|---|---|---|---|
| Linked List | int | 2N | N |
| Linked List | Integer | 3N | 2N |
| Resizing Array | int | ~5N | lg N |
| Resizing Array | Integer | ~5N | ~N |

**Cost model**: Data references + objects created.

---

### Problem 1.4.36: Stack Space Usage

**Problem**: Justify space usage table for pushdown implementations:

| Data Structure | Item Type | Space (N values, bytes) |
|---|---|---|
| Linked List | int | ~32N |
| Linked List | Integer | ~64N |
| Resizing Array | int | ~4N to ~16N |
| Resizing Array | Integer | ~32N to ~56N |

**Constraint**: Static nested class for linked-list nodes (avoids non-static overhead).

---

## Experiments

### Experiment 1.4.37: Autoboxing Penalty

**Problem**: Determine autoboxing/auto-unboxing performance penalty.

**Approach**: Develop `FixedCapacityStackOfInts`, compare via DoublingRatio with generic `FixedCapacityStack<Integer>` (many push/pop operations).

---

### Experiment 1.4.38: Naive 3-Sum Evaluation

**Problem**: Evaluate naive 3-sum inner loop:

```java
for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
        for (int k = 0; k < N; k++)
            if (i < j && j < k)
                if (a[i] + a[j] + a[k] == 0)
                    cnt++;
```

**Approach**: DoublingTest variant computing runtime ratio (naive vs. ThreeSum).

---

### Experiment 1.4.39: Improved Doubling Test Accuracy

**Problem**: Modify DoublingRatio accepting second command-line argument (timeTrial() calls per N).

**Experiment**: Run for 10, 100, 1,000 trials; comment on result precision.

---

### Experiment 1.4.40: 3-Sum Random Analysis

**Problem**: Formulate and validate hypothesis: number of N random-integer triples summing to 0.

**Advanced**: Mathematical model for uniformly distributed values (−M to M, M not small).

---

### Experiment 1.4.41: Comparative Running Times

**Problem**: Estimate execution time (million numbers) for TwoSumFast, TwoSum, ThreeSumFast, ThreeSum.

**Approach**: DoublingRatio.

---

### Experiment 1.4.42: Problem Size Limits

**Problem**: Estimate maximum P where you can run TwoSumFast, TwoSum, ThreeSumFast, ThreeSum on $2^P$ thousand numbers.

**Approach**: DoublingRatio.

---

### Experiment 1.4.43: Resizing Arrays vs Linked Lists

**Problem**: Validate hypothesis: resizing arrays faster than linked lists for stacks.

**Approach**: DoublingRatio variant computing runtime ratio (two implementations).

---

### Experiment 1.4.44: Birthday Problem

**Problem**: Write programme accepting N, generating random sequence (0 to N−1) until repetition.

**Hypothesis**: First repetition at $\sim \sqrt{N}/2$.

**Approach**: Experimental validation.

---

### Experiment 1.4.45: Coupon Collector Problem

**Problem**: Generate random integers (0 to N−1) until all values appear.

**Hypothesis**: All values appear after $\sim N H_N$ generations (where $H_N = 1 + 1/2 + 1/3 + \ldots + 1/N$).

**Approach**: Experimental validation.

---
