package Week_5;


class LinkedList<T> {
    private Node head;

    private class Node{
        T data; // Type is decided at call time
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void insert(T data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public T head(){
        if (head == null){
            return null;
        }
        return head.data;
    }
}

public class L_5_2_5_GenericClasses {
    public static void main(String[] args) {
        
        LinkedList<Integer> intList = new LinkedList<>();
        intList.insert(10);
        intList.insert(20);

        
        LinkedList<String> strList = new LinkedList<>();
        strList.insert("Hello");
        strList.insert("World");

        System.out.println("Integer List Head: "+ intList.head());
        System.out.println("String List Head: "+ strList.head());

    }
}

/*
====================== DOCUMENTATION ======================

0. PURPOSE OF THIS PROGRAM (WHY ARE WE DOING THIS?)
--------------------------------------------------
- This program demonstrates how to build a LinkedList using GENERICS.

- Problem before generics:
    • We had to use Object type → allowed ANY type
    • This caused:
        ❌ Mixing of different types (bad design)
        ❌ Need for type casting while retrieving
        ❌ Runtime errors instead of compile-time errors

- Requirement:
    ✔ We want a data structure (like LinkedList) that:
        - Works for ANY type (Integer, String, etc.)
        - But stores ONLY ONE type at a time (homogeneous)
        - Does NOT require casting
        - Is type-safe at compile time

- Solution:
    → GENERICS (LinkedList<T>)

- So this program shows:
    👉 How one class can safely work for multiple types
    👉 Without rewriting code for each type


1. GENERIC CLASS THEORY
-----------------------
- LinkedList<T> is a generic class.
- T is a type variable → actual type is decided at object creation.
- Example:
    LinkedList<Integer> → T = Integer
    LinkedList<String> → T = String

- This ensures:
    ✔ Type safety (no wrong types allowed)
    ✔ No casting required
    ✔ Reusability (same class works for all types)


2. OBJECT CREATION (VERY IMPORTANT)
----------------------------------
LinkedList<Integer> intList = new LinkedList<>();

- Left side → defines reference type
- Right side → creates object
- <> (diamond operator) automatically infers Integer

Memory:
STACK: intList → reference
HEAP:  LinkedList object (head = null)


3. INSERT OPERATION FLOW (STEP-BY-STEP)
--------------------------------------

CALL: intList.insert(10)

Step 1: Method resolves as
    insert(Integer data)

Step 2: Create node
    Node newNode = new Node(10)

Memory:
newNode → [data=10, next=null]

Step 3: Check
    head == null → TRUE

Step 4:
    head = newNode

IMPORTANT:
- No object copy happens
- Only reference is assigned

Now:
head → Node(10)


4. SECOND INSERT (insert(20))
-----------------------------

Step 1:
newNode → Node(20)

Step 2:
head != null → go to else

Step 3:
temp = head → Node(10)

Step 4:
temp.next == null → loop stops

Step 5:
temp.next = newNode

Final structure:
head → [10] → [20] → null


5. KEY CONCEPT (YOUR DOUBT ANSWERED)
-----------------------------------

Line:
    head = newNode;

Explanation:
- newNode is a reference (address of object)
- head gets SAME address
- Both point to SAME object

So:
    head --------\
                    → Node(10)
    newNode -----/

Java ALWAYS copies references, NOT objects.


6. FINAL OUTPUT FLOW
-------------------

intList.head()

→ returns head.data
→ returns 10

Output:
Head: 10


====================== CORE TAKEAWAY ======================

- Generics solve the problem of unsafe Object usage
- They provide:
    ✔ Compile-time safety
    ✔ No casting
    ✔ Code reusability

- Generic LinkedList:
    → One implementation
    → Works for all types safely

==========================================================
*/