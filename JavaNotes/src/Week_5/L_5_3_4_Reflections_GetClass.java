package Week_5;


public class L_5_3_4_Reflections_GetClass {

        // Function to check if two objects belong to same class
    public static boolean areSameClass(Object o1, Object o2) {
        return o1.getClass() == o2.getClass();
    }
    public static void main(String[] args) {
        // Different types of Objects

        String str1 = "Hello";
        String str2 = "World";
        Integer num = 10;

        // Custom class Object
        Employee12 emp = new Employee12("Jhon");

        // Comparing same type
        System.out.println("str1 vs str 2: " + areSameClass(str1, str2));

        // Comparing custom class with String
        System.out.println("str1 vs emp: " + areSameClass(str1, emp));

    }    
}

class Employee12{
    String name;

    Employee12(String name){
        this.name = name;
    }
}


/*
====================================================================
SECTION 1: PURPOSE OF THE PROGRAM
====================================================================

This program demonstrates runtime type inspection using Java reflection.

The goal is to determine whether two arbitrary objects belong to the
same class without knowing their types at compile time.

This cannot be solved generically using instanceof because instanceof
requires explicit knowledge of the type being checked.

Reflection allows us to inspect the runtime type of objects dynamically.


====================================================================
SECTION 2: CORE CONCEPT USED
====================================================================

Method:
    getClass()

Description:
    Every object in Java internally maintains a reference to a Class
    object that represents its runtime type.

    The method getClass() retrieves this Class object.

Return Type:
    Class<?> (a special class in Java that represents metadata of a class)

Comparison:
    o1.getClass() == o2.getClass()

Meaning:
    We are comparing whether both objects point to the same Class object.


====================================================================
SECTION 3: INTERNAL MEMORY MODEL (JVM LEVEL)
====================================================================

JVM maintains:

1. Heap:
   Stores actual objects.

2. Method Area / Metaspace:
   Stores class metadata as Class objects.

Each class loaded into JVM has exactly one Class object.

Representation:

    Heap:
        "Hello"   ---> reference str1
        "World"   ---> reference str2
        10        ---> reference num
        Employee object ---> reference emp

    Metaspace:
        Class<String>
        Class<Integer>
        Class<Employee>

Hidden relationship:

    "Hello"  ------> Class<String>
    "World"  ------> Class<String>
    10       ------> Class<Integer>
    emp      ------> Class<Employee>

Each object internally contains a hidden pointer to its Class object.

getClass() returns this pointer.


====================================================================
SECTION 4: WHY '==' WORKS HERE
====================================================================

Normally, '==' compares memory references.

Since JVM creates only one Class object per class,
all objects of the same type refer to the same Class object.

Therefore:

    str1.getClass() == str2.getClass()  --> true
    str1.getClass() == num.getClass()   --> false


====================================================================
SECTION 5: SYNTAX AND RULES
====================================================================

Syntax:
    object.getClass()

Rules:

1. Works on any object (built-in or user-defined)
2. Returns runtime type, not compile-time type
3. Safe and does not require casting
4. Comparison using '==' is valid for Class objects
5. This is an example of introspection (read-only reflection)


====================================================================
SECTION 6: LIMITATIONS
====================================================================

1. This method only inspects type; it does not modify behavior
2. Cannot determine subclass relationships (for that, instanceof is used)
3. Only checks exact class equality


====================================================================
SECTION 7: DETAILED DRY RUN (LINE-BY-LINE EXECUTION)
====================================================================

Execution starts from main()

------------------------------------------------------------

Line:
    String str1 = "Hello";

Action:
    A String object "Hello" is created in heap.
    Reference stored in variable str1.
    Object internally points to Class<String>.

------------------------------------------------------------

Line:
    String str2 = "World";

Action:
    Another String object "World" is created.
    Reference stored in str2.
    Also points to Class<String>.

------------------------------------------------------------

Line:
    Integer num = 10;

Action:
    Integer object created.
    Reference stored in num.
    Points to Class<Integer>.

------------------------------------------------------------

Line:
    Employee emp = new Employee("John");

Action:
    Employee constructor is called.
    Object created in heap.
    Field 'name' initialized to "John".
    Object points to Class<Employee>.

------------------------------------------------------------

Function Call:
    areSameClass(str1, str2)

Inside function:

    o1.getClass() --> returns reference to Class<String>
    o2.getClass() --> returns reference to Class<String>

Comparison:
    Class<String> == Class<String> --> true

Output:
    str1 vs str2: true

------------------------------------------------------------

Function Call:
    areSameClass(str1, num)

Inside function:

    o1.getClass() --> Class<String>
    o2.getClass() --> Class<Integer>

Comparison:
    Class<String> == Class<Integer> --> false

Output:
    str1 vs num: false

------------------------------------------------------------

Function Call:
    areSameClass(str1, emp)

Inside function:

    o1.getClass() --> Class<String>
    o2.getClass() --> Class<Employee>

Comparison:
    Class<String> == Class<Employee> --> false

Output:
    str1 vs emp: false

------------------------------------------------------------

Final Output:

    str1 vs str2: true
    str1 vs num: false
    str1 vs emp: false


====================================================================
SECTION 8: KEY TAKEAWAY
====================================================================

getClass() exposes the internal link between an object and its
class metadata stored in the JVM.

Reflection begins with the ability to inspect this relationship
at runtime.

====================================================================
*/