

# Java Memory Management & Garbage collector
2 types of memory:
-------------------
- Stack
- Heap

Both stack and heap are created by JVM and stored in RAM

## Types of memory stored in stack and heap
### Stack Memory:
* stack stores temporary variables and separate memory block for methods
* primitive data type
* store refernce of the heap objects (when we create an object using new)
   - reference is stored in stack
* Each thread has its own stack memory (but they share a common heap memory)
* variable within a scope is only visible and as soon as any variable goes out of the scope, it gets deleted from the stack(in LIFO)
* when stack memory gets full, it throws "java.lang.StackOverflowError"

### Heap Memory:
* Store objects
* There is no order of allocating the memory
* Garbage Collector is used to delete the unreferenced objects from heap
    -  System.gc to run garbage collector else it runs periodically by JVM
    - There is no gurantess that System.gc will run the garbage collector, it totally depends on the JVM

* StringLiterals are stored in Stringpools and string pools are stored in heap memory


### Additional Notes:
-- temporary variables?? variable within a method
-- Different types of references:
- storng references
- weak refernces
- soft references
- phantom references
https://www.geeksforgeeks.org/types-references-java/

## References
- Stack stores the object, heap stores the reference of the object

// Strong reference:

Person obj = new Person();
new Person() is stored in Heap
Person obj is stored in stack

^ this is a strong reference

// Weak reference:

WeakReference<Person> weakObj =  new WeakReference<Person>(new Person());
when the gc runs it will free up the space for the obj in hbeap memory, and you will get the value null

// Soft Reference:

Soft reference is a type of weak reference, which asks JVM that you are allowed to free the object but do it only when the heap memory is full