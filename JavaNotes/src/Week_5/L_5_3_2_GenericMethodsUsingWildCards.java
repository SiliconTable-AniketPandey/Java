package Week_5;

import java.util.LinkedList;


public class L_5_3_2_GenericMethodsUsingWildCards {
    

    // Method using wildcard
    public static void printList(LinkedList<?> list){
        for (Object element : list){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        java.util.LinkedList<Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(20);

        printList(stringList);
        printList(intList);



    }

}


/*

? What this program is about?

    * This program demonstrates **Wildcards (?) in Java Generics**

    * Wildcard (?) means:
        → "Unknown type"

    * Example:
        LinkedList<?> list

        → This means:
            A LinkedList of some type (we DON'T know which)


? Why are we studying this?

    * Earlier (Topic 1):
        → Arrays allowed unsafe behavior (runtime crash)

    * Then (Topic 2):
        → Generics fixed this using strict type checking

    * Now:
        → We want flexibility like arrays
        → BUT without losing safety

    * Wildcards help us achieve:
        → Flexibility + Safety


? VERY IMPORTANT CONFUSION (Cleared)

    * At first glance, it looks like:
        → "We ARE adding elements (stringList.add, intList.add)"

    * YES, we are adding — BUT:

        → That is happening in:
            LinkedList<String>
            LinkedList<Integer>

        → NOT in:
            LinkedList<?> list

    * This is the KEY difference


? Where are we actually using wildcard?

    public static void printList(LinkedList<?> list)

    * Here:
        → We DO NOT know the type of list

        → It could be:
            LinkedList<String>
            LinkedList<Integer>
            LinkedList<Double>


? Why can't we do list.add()?

    * Suppose Java allowed this:

        list.add("Hello");

    * Now imagine:

        LinkedList<Integer> intList = new LinkedList<>();
        printList(intList);

    * Inside method:
        list.add("Hello");  // ❌ inserting String into Integer list

    * This breaks type safety

    * Therefore:
        → Java blocks ALL add operations for wildcard


? Then why are we allowed to add earlier?

    * Because:

        LinkedList<String> stringList = new LinkedList<>();

    * Here:
        → Type is KNOWN = String

    * So:
        stringList.add("Apple")  // ✅ allowed

    * Summary:

        Known type → add allowed
        Unknown type (?) → add NOT allowed


? What is the REAL PURPOSE of wildcard?

    * Wildcards are NOT used to CREATE lists

    * They are used to ACCEPT lists as input

    * Goal:
        → Accept multiple types safely

    * Example:

        void printList(LinkedList<?> list)

        → Can accept:
            LinkedList<String>
            LinkedList<Integer>
            LinkedList<Double>


? Why not use LinkedList<Object>?

    * Because:

        LinkedList<String> ≠ LinkedList<Object>

    * So this will NOT work:

        void printList(LinkedList<Object> list)

    * That is why wildcard is needed


? What can we do with wildcard?

    * Allowed:
        → Read elements
        → Treat them as Object

    * Not Allowed:
        → Add elements
        → Modify structure


? Dry Run (Line-by-Line Execution)

    Line 1:
        LinkedList<String> stringList = new LinkedList<>();

        → Creates a list of Strings


    Line 2:
        stringList.add("Apple");

    Line 3:
        stringList.add("Banana");

        → stringList = ["Apple", "Banana"]


    Line 4:
        LinkedList<Integer> intList = new LinkedList<>();

        → Creates a list of Integers


    Line 5:
        intList.add(10);

    Line 6:
        intList.add(20);

        → intList = [10, 20]


    Line 7:
        printList(stringList);

        → list becomes LinkedList<?>
        → Actual type = String

        Loop runs:

            element = "Apple" → printed
            element = "Banana" → printed


    Line 8:
        printList(intList);

        → list becomes LinkedList<?>
        → Actual type = Integer

        Loop runs:

            element = 10 → printed
            element = 20 → printed


? Final Understanding (MOST IMPORTANT)

    * Generics (<T>):
        → Type is known
        → Can read + write

    * Wildcards (?):
        → Type is unknown
        → Only safe to read

    * Wildcards are used when:
        → We don't care about type
        → We only need to use data (not modify it)


? One-line intuition

    * <T> → "I know the type, I will use it fully"
    * ?   → "I don’t know the type, I will only read safely"


*/