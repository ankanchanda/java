### Agenda
- Intro to Multithreading
- Runnable Interface
- Print Hello World in a different thread
- Print numbers from 1 to 100
- Executors and thread pools


CPU is responsible for execution of task
- Quad Core
- Octa Core

Core: Execution Unit of CPU

-----------
| C1 | C2 |
-----------
| C3 | C4 |
-----------

1 Core -> 1 Task
QuadCore -> 4task at a time

For additional taks, move it to queue
4gHz -> Frequency of the core -> 4 * 10^9 tasks/sec

GPU??
1000's of cores

One core can execute only one task at a time

1 core
|------T1-----|----T2-----|------T3-----|
=>Multiple tasks are running but is making progress in one taks at any moment

Thread is a part of process which could be independently executed by a core
Thread is the smallest unit of execution


1. Thinkg in terms of task, not in terms 
example: no. of threads

Task: Hello World
create a class for this task

2. Make this class implement the runnable interface

3. Override the run method => code that we want to run in a separate thread

sout("hello worrld");

4. create the task object
    HelloWorldPrinter hwp = new HelloWorldPrinter()
 
5. already assigned a task, now create a thread to execute the task
Create an object of thread class(provided  by java)
Thread t = new Thread(hwp)

6. Execute the thread
    t.start()


Task: Print numbers from 1 to 100
1. Create a task Class: NumberPrinter
    class NumberPrinter
2. Make this class implement the runnable interface
    class NumberPrinter implements Runnable interface
3. override the run method
class NumberPrinter{
    NumberPrinter(int x){
        number = x;
    }
    run(){
        print(number)
    }
}

4. create 100 objects of helloworld printer using loops

for(i=1; i<=100; i++){
    NumberPrinter np = new NumberPrinter(i);
    Thread t = new Thread();
    t.start();
}


### Thread Pool (Executor)
reusing threads

#### Trade off
Finding sweet spot