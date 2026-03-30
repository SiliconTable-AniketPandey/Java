package Week_5;

class InstanceofVsReflection{
    // using instanceof (works only when type is known before hand)
    public static boolean isManagerUsingInstanceof(Object obj){
        return obj instanceof Manager12;
    }

    // Using reflection (works even when type is unknown beforehand)
    public static boolean areSameClassUsingReflection(Object o1, Object o2){
        return o1.getClass() == o2.getClass();
    }
}

class Employee13{
    String name;

    public Employee13(String name) {
        this.name = name;
    }
}

class Manager12 extends Employee13{
    int bonus;

    public Manager12(String name, int bonus) {
        super(name);
        this.bonus = bonus;
    }

    
}

public class L_5_3_5_instanceof_vs_Reflection {
    
    public static void main(String[] args) {
        
        Employee13 e1 = new Employee13("Alice");
        Manager12 m1 = new Manager12("Bob", 5000);
        String str = "Hello";

        // instanceof usage
        System.out.println("Is e1 a Manager? " + InstanceofVsReflection.isManagerUsingInstanceof(e1));
        System.out.println("Is m1 a Manager? " + InstanceofVsReflection.isManagerUsingInstanceof(m1));

        // Reflection usage
        System.out.println("e1 vs m1 same class? " + InstanceofVsReflection.areSameClassUsingReflection(m1, m1));
        System.out.println("e1 vs str same class? " + InstanceofVsReflection.areSameClassUsingReflection(e1, str));

    }

}


/*
====================================================================
SECTION 1: PURPOSE OF THE PROGRAM
====================================================================

This program compares two approaches for type checking in Java:

1. instanceof (compile-time known type checking)
2. Reflection using getClass() (runtime type inspection)

The goal is to understand the limitation of instanceof and why
reflection is needed when types are not known in advance.


====================================================================
SECTION 2: CORE CONCEPTS
====================================================================

Concept 1: instanceof

Syntax:
    object instanceof ClassName

Meaning:
    Checks whether the object is an instance of a specific class
    or any of its subclasses.

Important:
    The class (e.g., Manager) must be known at compile time.

------------------------------------------------------------

Concept 2: Reflection using getClass()

Syntax:
    object.getClass()

Meaning:
    Returns the runtime class of the object as a Class object.

Comparison:
    o1.getClass() == o2.getClass()

This works even when we do not know the types beforehand.


====================================================================
SECTION 3: LIMITATION OF instanceof
====================================================================

instanceof requires a fixed type.

Example:
    obj instanceof Manager

This only works because "Manager" is explicitly written in code.

Problem:
    If we want to compare two arbitrary objects:

        Are they of the same class?

We cannot write:

        o1 instanceof o2   (INVALID in Java)

Reason:
    instanceof expects a class name, not a variable.

Therefore, instanceof cannot solve general type comparison problems.


====================================================================
SECTION 4: INTERNAL MEMORY MODEL
====================================================================

Objects in Heap:

    e1  ---> Employee object
    m1  ---> Manager object
    str ---> String object

Class objects in Metaspace:

    Class<Employee>
    Class<Manager>
    Class<String>

Inheritance:

    Manager ---> Employee

So:

    m1 is both:
        - Manager
        - Employee (due to inheritance)

Hidden links:

    e1  ---> Class<Employee>
    m1  ---> Class<Manager>
    str ---> Class<String>


====================================================================
SECTION 5: HOW instanceof WORKS INTERNALLY
====================================================================

Expression:
    obj instanceof Manager

JVM logic:

    1. Get class of obj
    2. Traverse its inheritance hierarchy
    3. Check if Manager exists in that hierarchy

So:

    m1 instanceof Manager  --> true
    m1 instanceof Employee --> true

Because Manager extends Employee.


====================================================================
SECTION 6: HOW getClass() WORKS DIFFERENTLY
====================================================================

Expression:
    o1.getClass() == o2.getClass()

JVM logic:

    1. Fetch Class object of o1
    2. Fetch Class object of o2
    3. Compare references

Important:
    This checks EXACT class equality (no inheritance considered)


====================================================================
SECTION 7: DETAILED DRY RUN
====================================================================

Execution starts from main()

------------------------------------------------------------

Line:
    Employee e1 = new Employee("Alice");

Action:
    Employee object created in heap.
    Points to Class<Employee>.

------------------------------------------------------------

Line:
    Manager m1 = new Manager("Bob", 5000);

Action:
    Manager object created.
    Points to Class<Manager>.
    Also inherits from Employee.

------------------------------------------------------------

Line:
    String str = "Hello";

Action:
    String object created.
    Points to Class<String>.

------------------------------------------------------------

Call:
    isManagerUsingInstanceof(e1)

Inside function:
    e1 instanceof Manager

Check:
    e1 is of type Employee
    Employee is NOT a subclass of Manager

Result:
    false

Output:
    Is e1 a Manager? false

------------------------------------------------------------

Call:
    isManagerUsingInstanceof(m1)

Inside function:
    m1 instanceof Manager

Check:
    m1 is of type Manager

Result:
    true

Output:
    Is m1 a Manager? true

------------------------------------------------------------

Call:
    areSameClassUsingReflection(e1, m1)

Inside function:

    e1.getClass() --> Class<Employee>
    m1.getClass() --> Class<Manager>

Comparison:
    Class<Employee> != Class<Manager>

Result:
    false

Output:
    e1 vs m1 same class? false

------------------------------------------------------------

Call:
    areSameClassUsingReflection(e1, str)

Inside function:

    e1.getClass() --> Class<Employee>
    str.getClass() --> Class<String>

Comparison:
    Class<Employee> != Class<String>

Result:
    false

Output:
    e1 vs str same class? false

------------------------------------------------------------

Final Output:

    Is e1 a Manager? false
    Is m1 a Manager? true
    e1 vs m1 same class? false
    e1 vs str same class? false


====================================================================
SECTION 8: KEY DIFFERENCE (IMPORTANT)
====================================================================

instanceof:
    - Requires known type
    - Supports inheritance
    - Cannot compare arbitrary objects

getClass():
    - Works with unknown types
    - Checks exact class only
    - Enables reflection-based logic


====================================================================
SECTION 9: KEY TAKEAWAY
====================================================================

instanceof is useful when you know what you are checking.

Reflection (getClass) is necessary when you do not know the
types beforehand and need to inspect them dynamically.

====================================================================
*/