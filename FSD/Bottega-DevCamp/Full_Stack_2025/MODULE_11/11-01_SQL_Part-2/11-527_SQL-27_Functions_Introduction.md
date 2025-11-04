# 11-527 SQL 27 - Functions Introduction

## What are SQL Functions?

**SQL functions** allow you to perform processes and calculations on data directly in queries.

## What are They For?

### 1. Summary Reports
- Create reports for managers/clients
- Summarise data
- Generate statistics

### 2. Web Applications
- Display totals in dashboards
- Calculate metrics in real time
- Generate user statistics

### 3. Calculations and Computations
- Sum entire columns
- Count records
- Calculate averages
- Find maximums and minimums

## Aggregate Functions

### What is an Aggregate Function?

An **aggregate function** takes a collection of data and returns **a single result**.

### Characteristics

- **Input**: Multiple records/values
- **Output**: A single value
- **Purpose**: Summarise data

### Conceptual Examples

| Function | Input | Output |
|----------|-------|--------|
| SUM | All revenues | Total revenue |
| COUNT | All records | Number of records |
| AVG | All sales | Average of sales |
| MAX | All prices | Maximum price |
| MIN | All prices | Minimum price |

## Types of Functions We Will See

### 1. Aggregate Functions
- SUM (sum)
- COUNT (count)
- AVG (average)
- MAX (maximum)
- MIN (minimum)

### 2. Processing Functions
- Calculations on data
- Transformations
- Mathematical operations

## Use Cases

### Reports
- "What is the total revenue for the month?"
- "How many users registered this week?"
- "What is the average sales per day?"

### Dashboards
- Display KPIs (Key Performance Indicators)
- Real-time metrics
- Summary statistics

### Data Analysis
- Identify trends
- Compare periods
- Calculate business metrics

## Export Data

At the end of this section we will also see:
- How to export query results
- Generate reports in Excel
- Share processed data

## Advantage of SQL Functions

Instead of:
1. Bringing all data to your application
2. Processing it with code (JavaScript/Python)
3. Calculating totals

You can:
1. Let SQL do the calculation
2. Receive only the final result
3. Much more efficient

## Conceptual Example

```sql
-- Without function: fetch 1000 records and sum them in code
SELECT revenue FROM sales;  -- 1000 rows

-- With function: SQL sums and returns 1 result
SELECT SUM(revenue) FROM sales;  -- 1 row with the total
```

## Why Use Functions?

1. **Efficiency**: SQL processes data faster than your code
2. **Less traffic**: You only send the final result
3. **Cleaner code**: Less logic in the application
4. **Performance**: The database is optimised for this


## Important Vocabulary

- **Aggregate Function**: Function that takes multiple values and returns one
- **Summary Report**: Summary report with totals and statistics
- **Computation**: Calculation or processing of data
