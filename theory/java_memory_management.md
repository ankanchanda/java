

# Java Memory Management & Garbage collector
2 types of memory:
-------------------
- Stack
- Heap

Both stack and heap are created by JVM and stored in RAM

## Types of memory stored in stack and heap
### Stack:
* stack stores temporary variables and separate memory block for methods
* primitive data type
* store refernce of the heap objects (when we create an object using new)
   - reference is stored in stack
* Each thread has its own stack memory (but they share a common heap memory)
* variable within a scope is only visible and as soon as any variable goes out of the scope, it gets deleted from the stack(in LIFO)
* when stack memory gets full, it throws "java.lang.StackOverflowError"


### Additional Notes:
-- temporary variables?? variable within a method
-- Different types of references:
- storng references
- weak refernces
- soft references
- phantom references
https://www.geeksforgeeks.org/types-references-java/