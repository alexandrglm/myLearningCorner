# 10-179:   Digital Literacy
## Answering Impossible Interview Questions

Today I’m going to discuss the best ways for answering impossible interview questions.

How would you like to be asked the question:

> “How long would it take to sort 1 trillion numbers?” or “How many planes are there in the sky at a given moment?”

If that doesn’t sound like your idea of fun you’re not alone and many organizations have stopped asking impossible or seemingly impossible questions, however, there are still interviewers who like to ask them so I thought it would be helpful to discuss.

First and foremost, if you get asked one of these questions, the interviewer’s top goal is not seeing if you know the answer or not, instead they are looking to observe your problem-solving skills. 

Typically the best approach is to take a systematic strategy so you can show that you have an organized thought process.

## Answering Impossible Interview Questions – Case Studies

Let’s take the first question as an example: “How long would it take to sort 1 trillion numbers?” That seems like a challenging task until you establish a base case, such as: 
>“How long would it take to sort 10 numbers?”

If you know your algorithms you would most likely choose to use a sorting algorithm, such as Quicksort, since it has an average sorting time of O(n lg n), which would be O(100 lg 100) after swapping out n for the total number of integers.  
So it’s actually trivial to sort 1 trillion integers, since it would be O(1,000,000,000,000 lg 1,000,000,000,000).

In this question, the interviewer is first wanting to ensure that you know popular algorithms and that you have a clear understanding of which algorithm would be the right fit for the task.

For “How many planes are there in the sky at a given moment?” ...  

This is a guesstimate question and the actual answer doesn’t matter at all, instead the interviewer wants to see how you walk through an analytical problem and also how detailed oriented you are.

For this, I would start by asking the interviewer filtering questions, such as All the planes in the world or only in the US? Does this only include commercial planes or private jets and military aircraft? And questions that show that you know how to properly think through each of the parameters you would need to know to properly answer the question. 

From there break down the problem into subproblems, say the interviewer says that they only want the list of commercial planes in the air in the US, you can start to create an estimate on how many flights leave an airport each hour, set an average duration of the flights, etc. 

From there you can multiply that base case by the estimated number of airports in the US and you will have your guesstimate, and more importantly, you will show the interviewer that you have thought through the problem.

---

I hope that this guide has helped give you a strategy on answering impossible interview questions and good luck with the job hunt!
