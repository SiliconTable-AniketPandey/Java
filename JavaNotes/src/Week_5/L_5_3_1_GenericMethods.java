package Week_5;

import java.util.LinkedList;

public class L_5_3_1_GenericMethods {
    public static <T> void printLinkedList(LinkedList<T> list){
        for (T element : list){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        
        
        // String list
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        // String list
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(20);

        // Calling same method for different types
        printLinkedList(stringList);
        printLinkedList(intList);


    }
}


/*

? What this program is about?

    * This program demonstrates **Generic Methods in Java**

    * A generic method allows us to:
        → Write one method that works with multiple data types

    * Instead of writing separate methods for each type,
        we use a type parameter <T>


? Why are we studying this?

    * Without generics:
        → We need multiple methods (code duplication)

    * With generics:
        → One method works for all types
        → Cleaner and reusable code

    * This improves:
        → Maintainability
        → Flexibility


? What is <T>?

    * <T> is called a **type parameter**

    * It represents a placeholder for a data type

    * It is decided at compile time

    * Examples:
        T = String
        T = Integer
        T = Double


? How does the method work?

    public static <T> void printList(LinkedList<T> list)

    * <T> → declares generic type
    * LinkedList<T> → list can contain any type
    * T element → each element is of type T

    * This allows the same method to work for:
        LinkedList<String>
        LinkedList<Integer>
        LinkedList<Double>


? Dry Run (Line-by-Line Execution)

    Line 1:
        LinkedList<String> stringList = new LinkedList<>();

        → Creates a list that stores Strings


    Line 2:
        stringList.add("Apple");

        → Adds "Apple" to list

    Line 3:
        stringList.add("Banana");

        → List becomes: ["Apple", "Banana"]


    Line 4:
        LinkedList<Integer> intList = new LinkedList<>();

        → Creates a list that stores Integers


    Line 5:
        intList.add(10);

        → Adds 10

    Line 6:
        intList.add(20);

        → List becomes: [10, 20]


    Line 7:
        printList(stringList);

        → Compiler replaces T with String

        Method becomes:
            printList<String>(stringList)

        Loop execution:

            element = "Apple" → printed
            element = "Banana" → printed


    Line 8:
        printList(intList);

        → Compiler replaces T with Integer

        Method becomes:
            printList<Integer>(intList)

        Loop execution:

            element = 10 → printed
            element = 20 → printed


? Key Concept

    * Generic methods allow:
        → Code reuse
        → Type safety

    * The same method works for multiple types
    without losing type checking


? Final Understanding

    * <T> is a placeholder for a type
    * It is resolved at compile time
    * One method can handle multiple data types safely

*/