package Week_5;

class MaskingLinkedList<T>{
    private T data;

    // Correct insert method (no <T> here)
    public void insert(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }
}



public class L_5_2_4_TypeVariableMasking {
    public static void main(String[] args) {
        MaskingLinkedList<Integer> list = new MaskingLinkedList<>();

        list.insert(10);
        // list.insert("Hello") // ❌ Compile-time error (GOOD)

        System.out.println("Stored Value: "+list.getData());
    }    
}



/*
====================== DOCUMENTATION ======================

0. PURPOSE OF THIS PROGRAM (WHY ARE WE DOING THIS?)
--------------------------------------------------
- This program demonstrates the MOST BASIC use of GENERICS.

- Problem before generics:
    • If we used Object:
        - Could store ANY type (Integer, String, etc.)
        - But required casting while retrieving
        - Errors happen at runtime

- Requirement:
    ✔ Store only ONE type per object
    ✔ Avoid casting
    ✔ Catch errors at compile-time

- Solution:
    → GENERICS (LinkedList<T>)

- This program shows:
    👉 How type safety is enforced
    👉 Why we should NOT redefine <T> inside methods


1. GENERIC CLASS THEORY
-----------------------
- class LinkedList<T>
    → T is a type variable

- When object is created:
    LinkedList<Integer> list

    → T becomes Integer everywhere

- So internally:
    private T data → becomes → private Integer data

- Ensures:
    ✔ Only Integer allowed
    ✔ No casting needed


2. OBJECT CREATION (VERY IMPORTANT)
----------------------------------
LinkedList<Integer> list = new LinkedList<>();

- Left side:
    Defines type → LinkedList<Integer>

- Right side:
    Creates object

- <> → diamond operator (type inferred)

Memory:
STACK: list → reference
HEAP:  LinkedList object (data = null)


3. INSERT OPERATION (FULL DRY RUN)
---------------------------------

CALL:
    list.insert(10)

Step 1:
Method resolves as:
    insert(Integer data)

Step 2:
Parameter assignment:
    data = 10

Step 3:
Execute:
    this.data = data

Meaning:
    object.data = 10

Memory after execution:
HEAP:
    LinkedList object:
        data = 10


4. IMPORTANT CONCEPT (REFERENCE + this)
--------------------------------------

- "this.data" refers to instance variable (inside object)
- "data" refers to method parameter

So:
    this.data = data

means:
    object's data = passed value


5. TYPE SAFETY (VERY IMPORTANT)
-------------------------------

list.insert("Hello"); ❌

Why error?

Because:
    T = Integer

So method expects:
    insert(Integer data)

But we passed:
    String → mismatch → COMPILE-TIME ERROR

This is the MAIN advantage of generics.


6. WHAT IF WE DID WRONG (RELATION TO PREVIOUS TOPIC)
---------------------------------------------------

If we wrote:

    public <T> void insert(T data)

Then:
    - This T becomes NEW type variable
    - It hides class T

Result:
    list.insert("Hello"); ✅ (WRONG behavior)

→ Breaks type safety

So:
    NEVER redefine <T> inside generic class methods


7. GET METHOD FLOW
-----------------

CALL:
    list.getData()

Step 1:
Return type:
    T → Integer

Step 2:
Return:
    return data → 10

Output:
    Stored value: 10


====================== CORE TAKEAWAY ======================

- Generics allow:
    ✔ Type-safe storage
    ✔ No casting
    ✔ Reusable code

- T is fixed at object creation
- All methods must use SAME T
- Never redefine <T> inside class methods

==========================================================
*/