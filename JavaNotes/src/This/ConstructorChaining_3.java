package This;

// ============================================
// THEORY SECTION — READ THIS FIRST
// ============================================

// 1️⃣ What is Constructor Chaining?
// Constructor chaining means one constructor calls another constructor
// in the SAME class using this(...).
//
// RULE:
// this(...) must be the FIRST statement in a constructor.
//
// When Java sees this(...):
// It pauses current constructor.
// Jumps to the called constructor.
// Executes it fully.
// Then returns back to the original constructor.
// Then continues remaining statements.
//
// Think of it like nested function calls.
// Stack grows downward, then unwinds upward.


// 2️⃣ How Java decides which constructor to execute?
//
// Java matches constructor based on:
// - Number of parameters
// - Type of parameters
//
// Example:
// Dog('O') → compiler sees char argument
// It looks for Dog(char)
// It finds Dog(char)
// So it jumps there.
//
// Then inside Dog(char),
// it sees this(16, "Nirma")
// Compiler finds Dog(int, String)
// Then inside that constructor,
// it sees this(32, "Mala", 'C')
// Compiler finds Dog(int, String, char)


// 3️⃣ Variable Shadowing Rule
//
// If a constructor or method has parameters with SAME name as instance variables:
//
// Inside that method:
// - Name alone refers to parameter (LOCAL variable)
// - this.name refers to object's instance variable
//
// Example:
// this.name = name;
//
// Left side → instance variable
// Right side → parameter
//
// If you write:
// name = name;
// That means parameter = parameter (object untouched)


// 4️⃣ How System.out.println decides which variable?
//
// Java always looks in this order:
//
// 1. Local variable / parameter
// 2. Instance variable
//
// So if parameter name exists,
// it hides instance variable.
//
// If parameter does NOT exist,
// Java uses instance variable.


// ============================================
// ACTUAL CODE WITH DEEP DRY RUN COMMENTS
// ============================================

class Dog {

    // ===============================
    // Instance variables (HEAP MEMORY)
    // ===============================
    int size;
    String name;
    char color;

    // =====================================
    // CONSTRUCTOR 3 (int, String, char)
    // =====================================
    Dog(int size, String name, char color) {
        // PARAMETERS (STACK MEMORY)
        // size = 32
        // name = "Mala"
        // color = 'C'

        // INSTANCE VARIABLES (HEAP BEFORE ASSIGNMENT)
        // size = 0
        // name = null
        // color = '\u0000'

        this.size = size;   // object.size = 32
        this.name = name;   // object.name = "Mala"
        this.color = color; // object.color = 'C'

        // MEMORY TABLE AFTER ASSIGNMENT:
        //
        // -------------------------------
        // | Parameter | Object Variable |
        // -------------------------------
        // | 32        | 32              |
        // | Mala      | Mala            |
        // | C         | C               |
        // -------------------------------

        System.out.println("Size " + size + " name: " + name + " color: " + color);
        // OUTPUT 1:
        // Size 32 name: Mala color: C
        //
        // Why?
        // size → parameter (32)
        // name → parameter ("Mala")
        // color → parameter ('C')
        //
        // Parameters shadow instance variables.
    }


    // =====================================
    // METHOD
    // =====================================
    public void Food(int s, String n, char c) {

        // PARAMETERS:
        // s = 100
        // n = "Apple"
        // c = 'G'

        size = s;
        // size refers to instance variable (no parameter named size)
        // object.size = 100

        // object now:
        // size = 100
        // name = "Mala"
        // color = 'C'

        System.out.println("Size " + size + " name: " + name + " color: " + color);

        // OUTPUT 4:
        // Size 100 name: Mala color: C
        //
        // Why?
        // size → instance variable (100)
        // name → instance variable ("Mala")
        // color → instance variable ('C')
    }


    // =====================================
    // CONSTRUCTOR 2 (int, String)
    // =====================================
    Dog(int size, String name) {

        // PARAMETERS:
        // size = 16
        // name = "Nirma"

        this(32, "Mala", 'C');
        // JUMP to constructor 3
        // That sets object values to:
        // size = 32
        // name = "Mala"
        // color = 'C'

        // Now back here.

        // MEMORY TABLE NOW:
        //
        // ----------------------------------
        // | Parameter | Object Variable    |
        // ----------------------------------
        // | 16        | 32                 |
        // | Nirma     | Mala               |
        // | -         | C                  |
        // ----------------------------------

        System.out.println("Size " + size + " name: " + name + " color: " + color);

        // OUTPUT 2:
        // Size 16 name: Nirma color: C
        //
        // Why?
        // size → parameter (16)
        // name → parameter ("Nirma")
        // color → no parameter named color here
        // so it uses instance variable → 'C'
    }


    // =====================================
    // CONSTRUCTOR 1 (char)
    // =====================================
    Dog(char color) {

        // PARAMETER:
        // color = 'O'

        this(16, "Nirma");
        // JUMP to constructor 2
        // That internally calls constructor 3

        // After constructor chain finishes,
        // object state is:
        //
        // size = 32
        // name = "Mala"
        // color = 'C'

        // MEMORY TABLE:
        //
        // ----------------------------------
        // | Parameter | Object Variable    |
        // ----------------------------------
        // | O         | C                  |
        // ----------------------------------

        System.out.println("Size " + size + " name: " + name + " color: " + color);

        // OUTPUT 3:
        // Size 32 name: Mala color: O
        //
        // Why?
        // size → instance variable (32)
        // name → instance variable ("Mala")
        // color → parameter ('O') shadows instance variable
    }

}


// =====================================
// MAIN
// =====================================

public class ConstructorChaining_3 {
    public static void main(String[] args) {

        Dog d = new Dog('O');
        // Constructor chain executes in this order:
        //
        // 1. Dog(char)
        // 2. Dog(int, String)
        // 3. Dog(int, String, char)
        //
        // Then unwinds:
        // 3 → 2 → 1

        d.Food(100, "Apple", 'G');
    }
}