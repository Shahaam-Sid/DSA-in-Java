# Data Structures and Algorithms in Java

## Overview

This repository contains theory and practical implementations of Data Structures and Algorithms as I work through the textbook.

**Reference Book:** *Data Structures and Algorithms in Java* (6th Edition) by Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser

## Learning Progress

### **1. Fundamental Data Structures**

#### Arrays
- [**Game Entries**](./Fundamental%20Data%20Structures/Arrays/Game%20Entries/) - Demonstrates basic array operations including insertion, deletion, and sorting of game score entries
- [**Insertion Sort**](./Fundamental%20Data%20Structures/Arrays/Insertion%20Sort/InsertionSort.java) - Implementation of the insertion sort algorithm with step-by-step sorting
- [**Arrays & Random**](./Fundamental%20Data%20Structures/Arrays/RandArr/ArrRand.java) - Exploration of array manipulation and Java's Random class methods
- [**Caesar Cipher**](./Fundamental%20Data%20Structures/Arrays/Caeser%20Cipher/CaeserCipher.java) - Classic encryption algorithm using character array transformations
- [**Tic Tac Toe**](./Fundamental%20Data%20Structures/Arrays/Tic%20Tac%20Toe/TicTacToe.java) - Complete game implementation using 2D arrays
- [**Equivalence in Arrays**](./Fundamental%20Data%20Structures/Arrays/EquivalenceinArrays/EquivalenceTesingArrays.java) - Equals method in Arrays


#### Linked Lists
- [**Singly Linked List**](./Fundamental%20Data%20Structures/Linked%20Lists/Singly%20Linked%20Lists/SInglyLinkedList.java) - Singly Linked List, nested Node class, Equivalent implementation, Cloning and Ex. R-3.6, R-3.12 and C-3.25
- [**Circular Linked List**](./Fundamental%20Data%20Structures/Linked%20Lists/Circular%20Linked%20Lists/CircularLinkedList.java) - Circular Linked List, nested Node class and  Ex. R-3.15, C-3.30, C-3.34
- [**Doubly Linked List**](./Fundamental%20Data%20Structures/Linked%20Lists/Doubly%20Linked%20Lists/DoublyLinkedList.java) - Doubly Linked List, nested Node class and Ex. R-3.16, C-3.35, C-3.26

#### Exercises

*Exercises independent of Classes Above are here, else in the respective class*

- [**Array 1**](./Fundamental%20Data%20Structures/Exercises/ArrEx1.java) - Array Exercises R-3.2, C-3.17, C-3.18 and C-3.24
- [**Array 2**](./Fundamental%20Data%20Structures/Exercises/ArrEx2.java) - Array Exercise P-3.36
- [**Doubly Circular LL**](./Fundamental%20Data%20Structures/Exercises/DoublyCircularLL.java) - Exercise C-3.32, Doubly Circular Linked List Implementation
- [**Game Entries using Singly Linked List**](./Fundamental%20Data%20Structures/Exercises/Game%20Entry/) - Exercise P-3.37, Implementation of Game Entry and Scoreboard using Singly Linked List

### **2. Algorithm Analysis**

#### Experimental Studies
- [**Tracking Time**](./Algorithm%20Analysis/Tracking%20Time/TimeTrack.java) - Tracking time taken for algorithm

### **3. Recursion**

#### Illustrative Examples
- [**Factorial**](./Recursion/Examples/Factorial.java) - Recursive Algorithm for Factorial (!)
- [**Ruler**](./Recursion/Examples/Ruler.java) - Prints a Ruler using Recursion
- [**Binary Search**](./Recursion/Examples/BinarySearch.java) - Binary Seach Implementation using Array
- [**File System**](./Recursion/Examples/FileSys.java) - Calculate Disk Usage of Directories & Files using Recursion

#### Further Examples
- [**Linear Recursion**](./Recursion/Further%20Examples/LinearRecursion.java) - Linear Recursion Examples, Summation of Array, Reversal of Array and two versions of Power Calculations
- [**Binary Recursion**](./Recursion/Further%20Examples/BinaryRecursion.java) - Binary Recursion Example, Binary Summation
- [**Multiple Recursion**](./Recursion/Further%20Examples/MultipleRecursion.java) - Multiple Recursion Example, Puzzle Solve

#### Amok Recursion
- [**Fibonacci Sequence**](./Recursion/Amok%20Recursion/Fibbonaci.java) - Good (Efficient) and Bad (Inefficient) Recursive Functions for Fibonacci Sequence


## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or text editor

### Running the Code
Navigate to any implementation directory and compile/run the Java files:

```bash
javac FileName.java
java FileName
```

## Progress Tracking

- [x] Arrays
- [x] Linked Lists
- [x] Algorithm Analysis
- [x] Recursion
- [ ] Stacks
- [ ] Queues
- [ ] Deques
- [ ] List and Iterator ADTs
- [ ] Trees
- [ ] Priority Queues
- [ ] Heaps
- [ ] Map
- [ ] Hash Tables
- [ ] Skip Lists
- [ ] Search Trees
- [ ] Sorting and Selection
- [ ] Text Processing
- [ ] Graph Algorithms
- [ ] Memory Management
- [ ] B-Trees

## Repository Structure

```
DSA in Java
│   .gitignore
│   README.md
│   
├───Algorithm Analysis
│   └───Tracking Time
│           TimeTrack.java
│
├───Fundamental Data Structures
│   ├───Arrays
│   │   ├───Caeser Cipher
│   │   │       CaeserCipher.java
│   │   │
│   │   ├───Cloning
│   │   │       CloningArrays.java
│   │   │
│   │   ├───EquivalenceinArrays
│   │   │       EquivalenceTesingArrays.java
│   │   │
│   │   ├───Game Entries
│   │   │       GameEntry.java
│   │   │       Scoreboard.java
│   │   │
│   │   ├───Insertion Sort
│   │   │       InsertionSort.java
│   │   │
│   │   ├───RandArr
│   │   │       ArrRand.java
│   │   │
│   │   └───Tic Tac Toe
│   │           TicTacToe.java
│   │
│   ├───Exercises
│   │   │   ArrEx1.java
│   │   │   ArrEx2.java
│   │   │   DoublyCircularLL.java
│   │   │
│   │   └───Game Entry
│   │           GameEntry.java
│   │           ScoreBoardLL.java
│   │
│   └───Linked Lists
│       ├───Circular Linked Lists
│       │       CircularLinkedList.java
│       │
│       ├───Doubly Linked Lists
│       │       DoublyLinkedList.java
│       │
│       └───Singly Linked Lists
│               SInglyLinkedList.java
│
└───Recursion
    ├───Amok Recursion
    │       Fibbonaci.java
    │
    ├───Examples
    │       BinarySearch.java
    │       Factorial.java
    │       FileSys.java
    │       Ruler.java
    │
    └───Further Examples
            BinaryRecursion.java
            LinearRecursion.java
            MultipleRecursion.java
```

---

*This repository is actively being updated as I progress through the course material.*