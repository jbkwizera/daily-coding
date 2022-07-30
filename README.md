#### Table of Contents
1. [Daily coding problems](#daily-coding-problems)
2. [Easy](#easy)
    - [Problem #1 - ```TwoSum.java```](#easy-1)
    - [Problem #101 - ```Goldbach.java```](#easy-101)
3. [Medium](#medium)
    - [Problem #3 - ```BTreeSerialization.java```](#medium-3)
    - [Problem #5 - ```carcdr.py```](#medium-5)
    - [Problem #102 - ```ContiguousKSum.java```](#medium-102)
    - [Problem #122 - ```MatrixMaxPath.java```](#medium-122)
4. [Hard](#hard)
    - [Problem #2 - ```ProductExceptMe.java```](#hard-2)
    - [Problem #4 - ```SmallestMissingPositive.java```](#hard-4)

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
<a name="medium-3"></a>
### Problem #3 - ```BTreeSerialization.java```
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class
```
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```
The following test should pass:
```
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
```
<a name="medium-5"></a>
### Problem #5 - ```carcdr.py```
```cons(a, b)``` constructs a pair, and ```car(pair)``` and ```cdr(pair)``` return the first and last element of that pair. For example, ```car(cons(3, 4))``` returns ```3```, and ```cdr(cons(3, 4))``` returns ```4```.

Given this implementation of ```cons```:
```
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
```
Implement ```car``` and ```cdr```.

<a name="medium-102"></a>
### Problem #102 - ```ContiguousKSum.java```
Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.

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

## Hard
<a name="hard-2"></a>
### Problem #2 - ```ProductExceptMe.java```
Given an array of integers, return a new array such that each element at index ```i``` of the new array is the product of all the numbers in the original array except the one at ```i```.

For example, if our input was ```[1, 2, 3, 4, 5]```, the expected output would be ```[120, 60, 40, 30, 24]```. If our input was ```[3, 2, 1]```, the expected output would be ```[2, 3, 6]```.

Follow-up: what if you can't use division?

<a name="hard-4"></a>
### Problem #4 - ```SmallestMissingPositive.java```
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input ```[3, 4, -1, 1]``` should give ```2```. The input ```[1, 2, 0]``` should give ```3```.

You can modify the input array in-place.