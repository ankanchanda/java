# Functional Interface
- if an interface contains only one abstract method -> it is known as functional interface
- Also Known as SAM Interface(Single Abstract Method)
- @FunctionalInterface can be used but it's optional, it restricts to create only one abstract method
- In interface if we define the object class methods like tostring hash, etc. you don't have to provide definition for it
- We can use other methods like default, static or methods inherited from object class

## Implementation
- using implements
- using anonymous class
- using labda expression: lamda expression is a way to implement the functional interface

## Types of Functional Interface
(already inbuilt)
- Consumer
    - Represent and operation that accepts a single input parameter and returns no result
    - Present in package: java.util.function
- Supplier
    - Represent the supplier of the result. Accept no input parameter but produce a result
    - Present in package: java.util.function
- Function
    - Accepts one argument, processes it and produces a result
    - Present in package: java.util.function
- Predicate
    - Accepts one argument and always returns boolean
    - Present in package: java.util.function

## Interfaces extending
- Functional Interface extending another interface which has some abstract method -> not allowed
    - as the parent's class abstract method also becomes a part of the functional interface which invalidates the definition of functional interface
- Functional interface extending interface which doesn't have any abstract method -> allowed
- Interface extending functional interface -> allowed
- Functional Interface extending other Fucntional Interface with different methods -> not allowed
- Functional Interface extending other functional interface with same method -> allowed
