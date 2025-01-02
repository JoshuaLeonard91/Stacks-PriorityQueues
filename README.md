# Stacks and Priority Queues

## Overview
The **Stacks and Priority Queues** project demonstrates:
- Implementation of a stack and a priority queue of `Country` objects using arrays.
- Handling data parsed from a CSV file containing information about countries and regions.
- Applying concepts of data structures (stack and priority queue) and user interaction through a menu system.

This project processes data for 145 countries, allowing the user to interact with the stack and priority queue to manage and query country objects.

## Objectives
- Reuse the `Country` class from Project 1 to store country data.
- Implement a stack for `Country` objects with operations such as push, pop, and print.
- Implement a priority queue for `Country` objects, prioritized by COVID Case Fatality Rate (CFR).
- Allow user interaction to manipulate and query data using a menu-driven interface.

## Features
1. **Country Class**:
   - Fields: `name`, `capital`, `population`, `GDP`, `COVID cases`, `COVID deaths`, and `area`.
   - Methods:
     - Getters and setters for all fields.
     - Constructor for initialization.
     - Method to compute derived fields like CFR, Case Rate, Death Rate, GDP per capita, and Population Density.
     - Method to print a formatted `Country` object.

2. **Stack Class**:
   - Implements a stack of `Country` objects using an array.
   - Operations:
     - `push`: Adds a `Country` object to the top of the stack.
     - `pop`: Removes and returns a `Country` object from the top of the stack.
     - `printStack`: Prints the stack contents from top to bottom.
     - `isEmpty`: Checks if the stack is empty.
     - `isFull`: Checks if the stack is full.

3. **PriorityQ Class**:
   - Implements a priority queue of `Country` objects using a sorted array based on CFR (ascending order).
   - Operations:
     - `insert`: Inserts a `Country` object into the priority queue (O(N) operation).
     - `remove`: Removes and returns the `Country` object with the highest priority (lowest CFR, O(1) operation).
     - `printQueue`: Prints the priority queue contents in order.
     - `isEmpty`: Checks if the priority queue is empty.
     - `isFull`: Checks if the priority queue is full.

4. **Project2 Class**:
   - Main class managing the program's flow and user interaction.
   - Reads data from `Countries2.csv` and populates the stack and priority queue.
   - Offers the user the following menu:
     1. Print stack.
     2. Pop a country object from the stack.
     3. Push a country object onto the stack.
     4. Print priority queue.
     5. Remove a country object from the priority queue.
     6. Insert a country object into the priority queue.
     7. Exit the program.

## Requirements
- **Java Development Kit (JDK) 8 or higher**
- Input File: `Countries2.csv` (containing country data)

## Implementation Details
### Stack:
1. **Constructor**:
   - Creates a stack array based on a user-provided size.
2. **Operations**:
   - `push`: Adds a `Country` object to the stack if not full.
   - `pop`: Removes and returns the `Country` object at the top of the stack if not empty.
   - `printStack`: Prints the stack contents from top to bottom.
   - `isEmpty`/`isFull`: Checks the stack's state.

### Priority Queue:
1. **Constructor**:
   - Creates a priority queue array based on a user-provided size.
2. **Operations**:
   - `insert`: Inserts a `Country` object into the queue while maintaining order by CFR.
   - `remove`: Removes and returns the `Country` object with the lowest CFR.
   - `printQueue`: Prints the queue contents in order.
   - `isEmpty`/`isFull`: Checks the queue's state.

### User Menu:
- Provides the following options:
  1. Print the stack contents.
  2. Pop a `Country` object from the stack.
  3. Push a `Country` object onto the stack (user provides data).
  4. Print the priority queue contents.
  5. Remove a `Country` object from the priority queue.
  6. Insert a `Country` object into the priority queue (user provides data).
  7. Exit the program.

### Report Formatting:
- Example Stack or Priority Queue Report:
  ```plaintext
  Stack or Priority Queue Contents:
  Burundi Bujumbura 0.005052 414.254 0.126 427.204

 
