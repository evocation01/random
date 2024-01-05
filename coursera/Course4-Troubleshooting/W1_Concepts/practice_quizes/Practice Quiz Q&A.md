# Practice Quiz: Introduction to Debugging

### 1.What is part of the final step when problem solving?

    Long-term remediation

### 2.Which tool can you use when debugging to look at library calls made by the software?

    ltrace

### 3.What is the first step of problem solving?

    Gathering information

### 4.What software tools are used to analyze network traffic to isolate problems? (Check all that apply)

    tcpdump
    wireshark

### 5.The strace (in Linux) tool allows us to see all of the _____ our program has made.

    System calls

# Practice Quiz: Understanding the Problem

### 1.When a user reports that an "application doesn't work," what is an appropriate follow-up question to gather more information about the problem?

    What should happen when you open the app?

### 2.What is a heisenbug?

    The observer effect.

### 4.How do we verify if a problem is still persisting or not?

    Attempt to trigger the problem again by following the steps of our reproduction case


# Terms and definitions from Course 4, Module 1

### Binary search: 
    A search algorithm used to find a specific item in a sorted list or array by repeatedly dividing the search space in half until the desired item is found or determined to be absent

### Bisecting: Dividing in two, also a Git command

Debuggers: Tools that follow the code line by line, inspect changes in variable assignments, interrupt the program when a specific condition is met, and more

### Debugging: 
    The process of identifying, analyzing, and removing bugs in the actual code of a system in the application

### Linear search: 
    The process of searching each line of data until the desired data entry is located
 
### Observer effect: 
    The idea that observing a phenomenon alters the phenomenon
 
### System calls: 
    The calls that the programs running on our computer make to the running kernel
 
### Troubleshooting: 
    The process of solving any kind of problem in the system running the application


### When debugging scripts, what is the primary type of issue that effective debugging can help address?
    Syntax errors and typos in the code

### When is it permissible to calculate the sum of two different data types in Python? Select all that apply
    never

#### PQ: Slow Code
* Which of the following is NOT considered an expensive operation?
    Parsing a file
    Downloading data over the network
    Going through a list
    - Using a dictionary

* Which of the following may be the most expensive to carry out in most automation tasks in a script?
    - Loops

* What command, keyword, module, or tool can be used to measure the amount of time it takes for an operation or program to execute? (Check all that apply)
- time
- kcachegrind
    profile data visualization
- cProfile
    deterministic profiling

* Which of the following statements represents the most sound advice when writing scripts?
- Awesome! If we don't notice any slowdown, then there's little point trying to speed it up.

* In Python, what is a data structure that stores multiple pieces of data, in order, which can be changed later?
- Lists

#### PQ: When slowness problems get complex


