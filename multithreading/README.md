# Multthreading

## Process
- Process is an instance of the program that is getting executed
- It has its own resources like memory, thread, etc.
- OS allocates these resources to process when it gets executed

Lets say, You have a java file Test.java, the steps for execution involves:
- Compilation(javac Test.java): generates bytecode that can be executed using JVM
- Execution(java Test): at this point, JVM starts the new Process (here Test class has psvm method)
- JVM creates a process, the process requires memory as well, it has its own heap memory
- Two prcess don't share resources each other and can execute parallely


## Threads
- Thread is known as light weight process
  OR
- Smallest sequence of instructions that are executed by CPU independently
- 1 process can have multiple threads
- When a process is created, it starts with 1 thread and that initial thread is known as 'main thread' and from that we can create multiple threads to perform tasks concurrenlty


## More about process and threads
- a jvm has a stack memory, and a heap memory 
- but if we go a bit in depth, JVM has heap, stack, code segment, Data segment, registers, Program Counter and others
-  So when we are executing a program
  - Step 1: It will create a process
  - A new JVM instance is created which includes all the memories assigned as discussed above

## How much memory does process get?
While creating the process "java MainClass" command, a new JVM instance will get created and we can tell how much heap memory needs to be allocated

`java -Xms256m -Xmx2g MainClass`

=> -xms<size> -> This will set the initial heap size, above 256MB is allocated
=> -xmx<size> -> This will set the maximum heap size process can get, above 2GB is allocated.  If it tries to allocate more memory then "OutOfMemory" error will occur.

## Threads
- Register, Stack, Counter -> They are locally allocated to each thread, threads don't share these with each other
- Code Segments and Data Segments are being shared between all threads
- heap memory is being shared between all threads

## Code Segment
- It contains the compiled bytecode(machine code) of the java program
- it's read only
- all threads within the same process shares the code segment

## Data segment
- Contains the global and static variables
- All threads within the same process shares teh data segment
- threads can read and modify the same data
- Synchronization is required between multiple threads

## Heap
- objects created at runtime using the "new" keyword are allocated in the heap
- Heap is shared among all the threads of the same process(but not within the process)
- threads can read and modify the heap data 
- Synchronization is required between multiple threads

## Stack
- each thread has its own stack
- it manages method calls, local variables

## Register
- JIT compiler compiles and converts the bytecode into machine code, it uses register to optimise the generated machine code
- also helps in context switching
- each thread has its own register

## Counter
- Also known as program counter, it points to the instruction which is getting executed
- increments its counter after successfull execution of the instruction

All these are managed by JVM