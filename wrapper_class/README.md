# Wrapper Class
We can understand wrapper class through two things
- Autoboxing
- Unboxing

There are 8 primitive types
1. int
2. char
3. boolean
4. float
5. long
6. short
7. double
8. byte

for each primitive type -> we have wrapper/reference
1. int -> Integer
2. char -> Character
3. boolean -> Boolean
4. float -> Float
5. long -> Long
6. short -> Short
7. double -> Doublt
8. byte -> Byte

**Why for each type, we need a respective wrapper type?**

Advantages:
- Reference capability: in primitive we cannot store the object which ahs a disadvanatage that if two objects are pointing to the same reference then if one changes the value it changes for both
- primitive data types are stored in the stack and not heap
- All the collections work on reference datatypes only

**Autoboxing:** Primitive to Wrapper class
**Unboxing:** Wrapper class to primitive