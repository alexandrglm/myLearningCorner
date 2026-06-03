# 01-001: What is BI - Business Intelligence?

![](./img/01-001.png)

In a society where we are inundated with data, companies need systems that allow them to analyse the vast amount of information and transform it into something useful and of value.

Business Intelligence responds precisely to this need, seeking to offer predictive models based on historical facts that provide companies with better competitive positioning and greater customer satisfaction.

---

![](./img/01-002.png)

This critical concept is not new and since its definition in the 1960s, its evolution has been constant.

BI cannot be defined as a technology or as a tool. Its definition is broader.

> **Business Intelligence is understood to be** the set of technologies, methodologies and strategies focused on treating the data that a company has and converting it into useful knowledge that allows for better decision-making and improving its effectiveness and competitiveness.

---

![](./img/01-004.png)

## Some of the Technologies that Form Part of Business Intelligence

* Data origin
* Data loading into a central repository
* Data transformation
* Data extraction
* Data Warehouse
* Data mining and modelling
* OLAP - OLTP
* Information presentation
* Reports
* Dashboards

---

## Need for Business Intelligence

![](./img/01-005.png)
![](./img/01-006.png)

These are some situations in which the implementation of a Business Intelligence system is necessary:

1. Decision-making without foundation
2. Communication problems within or outside the company
3. Massive and decentralised use of Excel spreadsheets
4. Multiple regression approach for variance analysis
5. Information does not flow between departments or arrives duplicated
6. There are information silos
7. Inefficient sales and marketing tasks
8. Excessive volume of information that makes it unmanageable
9. Manual processes

---

![](./img/01-007.png)

## The Implementation of a Business Intelligence System Responds to Questions Such As

| # | Question |
|---|----------|
| **01** | What happened? |
| **02** | Why did it happen? |
| **03** | Where are we now? |
| **04** | What is going to happen? |

---

The implementation of a business intelligence project is a complex process for which it is necessary to follow good practices.

Good practices help achieve objectives, effectively coordinating:

* Technology
* Strategies
* Methodologies

---

![](./img/01-008.png)

## When Does a BI Strategy Not Exist?

It is possible to detect that a strategy does not exist when we detect some of the following points within an organisation:

* The IT department is the cause of all problems
* BI is not critical to management
* BI is considered the same as reporting
* Information continues to be decentralised
* It is not possible to measure results or know why things happened
* Data Mining is the same as BI
* No investment is made in technology or expert BI personnel
* It is thought that BI is only for executives or middle management

---

## The Implementation of a Business Intelligence Strategy

![](./img/01-009.png)
![](./img/01-010.png)

It is a long-term and complex process that involves multiple departments, processes and resources, among which it is worth highlighting:

### 01. Create a BI Centre of Excellence

> Unifies knowledge in technologies, methodologies, strategy, led by a sponsor at executive level and executed by business analysts.

### 02. Define Standards

> To unify both existing and future technologies.

### 03. Measure the Results of Analytical Applications

> By means of data mining tools or similar that facilitate decision-making.

### 04. Learn from Successes and Failures

> By reviewing case studies and consulting with companies in the sector to determine what has worked and what has not.

### 05. Evangelise the Organisation

> Raise awareness among all staff, from management to the last employee.

---

![](./img/01-011.png)

> This type of project involves a cultural transformation of the entire organisation in which it is necessary to have answers to some of the following questions:

* What business problems or needs are you seeking to solve?
* What in particular must be answered and with what priority?
* How do we currently obtain an answer?
* What data sources and from which departments are necessary? (marketing, operations, human resources, etc.)
* How is the quality of the data?
* What amount of data should be saved as historical?
* How frequently should the data be updated?

---

## EDA - Exploratory Data Analysis

![](./img/01-012.png)

### What is EDA?

**Exploratory data analysis** is a data analysis approach to reveal the important characteristics of a dataset, mainly through visualisation.

One must know the data well:

* Distributions (symmetrical, normal, skewed)
* Data quality problems
* Outliers
* Correlations and interrelationships
* Functional relationships
* Derived attributes, primary keys, foreign keys, etc.
* Static attributes, dynamic attributes, etc.

---

## Introduction to Exploratory Data Analysis (EDA)

![](./img/01-013.png)

### 1

> Exploratory data analysis refers to the process of conducting initial investigations into the nature of the data to identify patterns, intercept anomalies, evaluate hypotheses and check assumptions with the help of statisticians and graphical representation tools.

### 2

> It is a highly recommended practice to understand the nature of the data and try to extract as much information as possible from the outset.

---

## Importance of EDA

![](./img/01-014.png)

* Find the most relevant features and variables in the dataset
* Test hypotheses or validate assumptions about the characteristics of the dataset
* Check the quality of data and information for subsequent processing
* Provide relevant insights or conclusions about the data to stakeholders
* Verify the relationships existing in the data
* Search for atypical patterns in the structure of the data

---

## Process of Exploratory Data Analysis (EDA)

![](./img/01-015.png)

```mermaid
graph LR
    A[Business objective] --> B[Requirements]
    B --> C[Data collection]
    C --> D[EDA: model definition]
    D --> E[Evaluation]
    E --> F[Ensure operation]
    F --> G[Deployment]
    G --> H[Monitoring]

    style A fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style B fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style C fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style D fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style E fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style F fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style G fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style H fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
```

### 1. Business Objective

Define what you wish to achieve.

**Example:** Agriculture company → Know market trends in order to act with advantage over the competition.

### 2. Requirements

For this, a series of data requirements to be analysed must be formulated.

**Example:** Historical sales data together with contextualised data.

### 3. Data Collection

Based on the requirements formulated.

### 4. EDA: Model Definition

It is used to provide a response to the inference scheme model that is being pursued.

### 5. Evaluation

### 6. Ensure Operation

### 7. Deployment

All of this leads to deployment.

### 8. Monitoring

Finally, performance monitoring is carried out to ensure the correct response. This step leads to a new iteration, which allows adding data, redefining the model, or even modifying business objectives.

---

## Two Typologies of Data

![](./img/01-016.png)

* **Structured data:** CSV file, Excel file, database, etc.
* **Unstructured data:** video, image, sound, etc.

---

## Important Tips When Analysing Preliminary Data

### Obtain a General Overview of the Data

![](./img/01-017.png)

#### 1

> Make sure your first visualisation is based on data (without models).

#### 2

> Think about interactivity and visuals:
> * **Humans are the best pattern recognisers**
> * Use as many dimensions as your data allows (2, 3, x, y, z, space, colour, time, etc.)

#### 3

> Visualisation is useful in the early stages of data mining:
> * Detect outliers (for example, assess data quality)
> * Check assumptions (for example, normal or skewed distributions?)
> * Identify useful raw data and transformations (for example, log(x))

#### Conclusion

It is always worthwhile to examine the data!

---
