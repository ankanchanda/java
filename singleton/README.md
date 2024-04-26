# Singleton Class:
The objective of this class is to create only 1 and one object. Ex: DB Connection

**Different ways of creating singleton class:**
1. Eager solution
    
    <a href="EagerSolution.java">EagerSolution.java</a><br>
    Created in advance.
    
    Disadvantage:
    - Even though it is not used, object is created and already stored in memory
2. Lazy initialization
    
    <a href="LazyInitialization.java">LazyInitialization.java</a><br>
    Disadvantage:
    - if two threads come in parallel that calls the getInstance() method then two objects will be created
3. Synchronization Block
    <a href="SynchronizationBlock.java">SynchronizationBlock.java</a><br>
    Disadvantage:
    - puting synchronized at method level is making it exteremely slow
    - for example there are so many placed where we are calling the getInstance method
    - not parallel just in sync, so it will create a lock and unlock it everytime
4. Double check lock (there is a memory issue solved through Volatile instance variable)
    
    <a href="DoubleLocking.java">DoubleLocking.java</a><br>
    Disadvantage:
    - Each CPU has multiple cores, and each core has their cache(L1 cache) and then they have access to memory
    - Now both Thread 1 and thread 2 comes parallely or even if not parallel, so thread 1's computation is happening in core 1, so connObj has new reference to memory. it's still in cache.
    - for performance purpose, all the cores stores the data into L1 cache and periodically sync up with the memory
    - so whatever memory has been assigned to the object, it it still present in the L1 cache, and the sync up between the caches hasn't been done in the cores
    - Now lets say thread 2 is coming and its computation is being done in core 2, so it will have no knowledge about connObj and then it will check in the memory which won't have any reference and hence it will create a new object
    - Another memory issue is called reordering
    
    Solution
    - both of this issue has been solved using Volatile
    - purpose of volatile is that, all the read and write for the object associated with volatile is always happened from memory instead of cache.

    Disadvantage of the solution:
    - all the read writes are happening from memory instead of cache hence it makes it slow a bit
5. Bill Pugh Solution
    
    <a href="BillPughSolution.java">BillPughSolution.java</a><br>
    Uses the concept of eagerly solution and instead of initializing the object in the class, it initializes inside a nested static class, because the static classes are not loaded in the memory before it is used.
 
6. Enum SIngleton
    <a href="EnumSolution.java">EnumSolution.java</a><br>
    Enums solve all the problems as they by default has private constructor and Enums are singleton -> one instance per JVM 