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


## Heap Memory
* Heap memory is divided into two parts
    - Young Generation
        + Eden
        + S0 (Surviver 0)
        + S1 (Surviver 1)
    - Old/Tenured Generation
    - Permanent Generation -> Metaspace(non-heap)

* When you create a new object it goes to Eden
* First time garbage colector invokes(Mark and Sweep Algorithm),first it will mark all the objects which has no reference and it's allowed to be deleted. Sweep algo will remove the objects from memory and put the surviving objects on S0 and age will be added(minor gc)
* Another object gets created before garbage collector runs for second time so the new objects will be placed on eden
* Garbage Collector invokes for 2nd time, it will check the objects which don't have reference be it Eden, S0 or S1, it will mark the objects and then Sweep it will remove the objects from the memory. Eden's and S0 will be moved to S1 with increase in age.
* A thresold is kept on age, let's say thresold is 3, so when age 3 is reached, it has to promote the objects
* Third time, gc runs, it marks the object with no references and then sweep deletes them. Then the survivors are again put to S0 from both eden and S1 with increase in their age, if the obj has age 3(or above thresold) it will be moved to old generation
* In old generation, it has a major gc unlike minor gc which is in young generation
* In old generation, gc runs less periodically


## Garbage collector
* Mark and sweep algorithm
* Mark and sweep with compact memory
    - Marked whatever objects that needs to be deleted and then with heap I have freed up the memory
    - With compact, iot compacts the survivors so that the free space is at last which can be utilised by new objects

### Versions of GC
1. Serial GC -> 
    1 thread is used and this thread will work in minor GC to free up the space and 1 thread for major GC

    Disadvantages:
    1. It will be slow
    2. GC is expensive, whenever gc work starts, all the application thread stops

2. Parallel GC -> default in Java 8
    Multiple threads depending upon the core helps to execute the gc and hence the pause time is less

3. Concurrent Mark and Sweep (CMS) ->
    While your application threads are working, your gc threads are working as well concurrently, but JVM doesn't gurantee that

4. G1 GC
    100% concurrent + Compaction