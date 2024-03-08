## Java
Platform independent language supporting oop

**Advantages**
- Portability (WORA)[Write Once Run Anywhere]


### [Java Code] -> Compiler -> [Byte Code] -> JVM -> [Machine Code]

## JVM
Java Virtual Machine, abstract machine, doesn't exist physically. It's platform dependent. JVM has JIT(Just In Time) compiler, it will take byte code and generate the machine code.

ByteCode -> .class extension

## JRE
It has JVM and class libraries

          JRE
|_____________________|
|   class Libraries   |
|  |______________|   |
|  |      JVM     |   |
|  |______________|   |
|_____________________|

## JDK
- programming languages
- compiler (javac)  -> .class
- debugger

JDK = JRE + PL + Compiler + Debugger

All three JVM JDK and JRE are platform dependent


## JSE(Java Standard Editon) -> core java
## JEE (Java/Jakarta Enterprise Edition) -> JSE + APIs like Transactional API, rollback, commit, servelets, JSP used in ecommerce, etc.
## JME (Java Micro/Mobile Edition) -> API for mobile application

- filename = classname
- 1 file can have only one public class
