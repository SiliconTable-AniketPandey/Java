package Week_5;

class Ticket5 {
    void show() {
        System.out.println("This is a Ticket");
    }
}

class ETicket5 extends Ticket5 { 
    void show() {
        System.out.println("This is an E-Ticket");
    }
}

public class L_5_3_0_ArrayCovariance {
    public static void main(String[] args) {
        
        // Step 1: Create ETicket array
        ETicket5[] eTickets = new ETicket5[3];

        // Step 2: Assign to parent reference (Covariance)
        Ticket5[] tickets = eTickets;

        // Step 3: Valid insertion
        tickets[0] = new ETicket5(); // Works fine

        // Step 4: Invalid insertion (ArrayStoreException)
        // Even though 'tickets' is a Ticket5 reference, the actual 
        // memory allocated is for an ETicket5 array.
        
        tickets[1] = new Ticket5(); 
        
        System.out.println("Error: Cannot store a Ticket5 in an ETicket5 array!");
        

        System.out.println("Program finished.");
    }
}


/*

? What this program is about?

    * This program is about demonstrating **Array Covariance in Java**

    * Covariant Arrays mean:

        * If Child is a subclass of Parent, then:
            Child[] can be assigned to Parent[]

        * Example:

            class Ticket {}
            class ETicket extends Ticket {}

            Then:
                ETicket[] eTickets = new ETicket[5];
                Ticket[] tickets = eTickets;   // ✅ Allowed


? Why are we studying this?

    * Because Java allows this assignment at compile time,
      but it can cause **runtime errors**

    * This creates a problem in type safety

    * Understanding this helps us see:
        → Why Java Generics were introduced
        → Why arrays are considered unsafe compared to generics


? Why does Java allow this?

    * Arrays in Java are designed to be **polymorphic**

    * Meaning:
        * You can treat subclass objects as parent objects

    * This provides flexibility:
        * Same code can work on different object types
        * Useful in generic-style programming


? What is the problem here?

    * Arrays are checked at **runtime**, not fully at compile time

    * This means:
        * Compiler allows unsafe assignments
        * JVM catches errors later → causes crash

    * This leads to:
        → ArrayStoreException


? Key Concept

    * Arrays are:
        → Covariant (flexible assignment)
        → Runtime type-checked

    * Because of this:
        → They are NOT fully type-safe


? Dry Run (Line-by-Line Execution)

    Line 1:
        ETicket[] eTickets = new ETicket[3];

        → Creates an array of size 3
        → All values are initially null

        Memory:
            eTickets → [null, null, null]
            Type of array = ETicket[]


    Line 2:
        Ticket[] tickets = eTickets;

        → Allowed due to covariance
        → tickets now refers to SAME array

        Important:
            Reference type = Ticket[]
            Actual array type = ETicket[]


    Line 3:
        tickets[0] = new ETicket();

        → Valid operation

        Why?
            ETicket fits inside ETicket[]

        Memory:
            [ETicket, null, null]


    Line 4:
        tickets[1] = new Ticket();

        → Compiler allows this (because tickets is Ticket[])

        BUT:

        Actual array type = ETicket[]

        So JVM checks:
            "Can Ticket go inside ETicket[]?"

        → NO ❌

        → Runtime Error occurs:
            ArrayStoreException


    Line 5:
        System.out.println("Done");

        → This line is NEVER executed
        → Program crashes before reaching here


? Final Understanding

    * Java allows:
        Child[] → Parent[]

    * But this creates unsafe situations

    * Therefore:
        → Arrays are not fully type-safe
        → Errors are caught at runtime, not compile time

    * This limitation leads to:
        → Introduction of Generics (which are safer)


*/
