#### Table of Contents
1. [Daily coding problems](daily-coding-problems)
2. [Easy](easy)
    - [Problem #1 - ```TwoSum.java```](easy-1)
    - [Problem #101 - ```Goldbach.java```](easy-101)
3. [Medium](medium)
    - [Problem #102 - ```ContiguousKSum.java```](medium-102)
    - [Problem #122 - ```MatrixMaxPath.java```](medium-122)
4. [Hard](hard)

# Daily Coding Problems
My solutions to coding problems asked during technical interviews of different companies.

## Easy
<a name="easy-101"></a>
### Problem #101 - ```Goldbach.java```
Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.

A solution will always exist. See [Goldbach's conjecture](https://en.wikipedia.org/wiki/Goldbach%27s_conjecture).

Example:
```
Input: 4
Output: 2 + 2 = 4
```
If there are more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then ```[a, b] < [c, d]``` if a < c OR a == c AND b < d.

<a name="easy-1"></a>
### Problem #1 - ```TwoSum.java```
Given a list of numbers and a number ```k```, return whether any two numbers from the list add up to ```k```.

For example, given ```[10, 15, 3, 7]``` and ```k``` of ```17```, return true since ```10 + 7``` is ```17```.

Bonus: Can you do this in one pass?

## Medium
<a name="medium-122"></a>
### Problem #122 - ```MatrixMaxPath.java```
You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix
```
0 3 1 1
2 0 0 4
1 5 3 1
```
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

<a name="medium-102"></a>
### Problem #102 - ```ContiguousKSum.java```
Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.

## Hard
