## Immutable class
- we cannot change the value of an object once it is created
- Declare class as final so that it cannot be extended
- all class members should be private, so that direct access can be avoided
- Class members are initialized only once using constructor
- There shouldn't be any setter methods which are generally to change the value.
- Just getter methods, and returns the copy of the member variable
- Example: String, Wrapper class