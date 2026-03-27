package This;

// Class Cat is a blueprint
class Cat{

    // ===========================
    // Instance variables (belong to object)
    // ===========================
    int size = 10;           // object's size
    String name = "Whatever"; // object's name
    char color = 'B';         // object's color


    // This is NOT a constructor (because it has return type void)
    // It is a normal method.
    public void CatProperties(int size, String name, char color){

        // ===========================
        // IMPORTANT CONCEPT:
        // These parameters SHADOW the instance variables.
        // That means:
        // parameter "size" hides object "size"
        // parameter "name" hides object "name"
        // parameter "color" hides object "color"
        // ===========================


        size = size + 5;
        // This modifies ONLY the parameter "size"
        // It does NOT change object.size
        // Because we did NOT use this.size


        this.name = name;
        // This modifies the object's name.
        // this.name → object variable
        // name → parameter
        // So object.name = parameter name


        color = color;
        // This does absolutely nothing.
        // Left side → parameter
        // Right side → parameter
        // Object's color is untouched.


        System.out.println("Size: "+size+" name: "+name+" color:"+color);

        // This prints the PARAMETER values, not object values.
    }

}

public class WhatIsThis_2 {

    public static void main(String[] args) {

        // Step 1: Object creation
        Cat cat = new Cat();

        // ===========================
        // MEMORY STATE AFTER CREATION
        // ===========================
        // Object cat:
        //
        // size  = 10
        // name  = "Whatever"
        // color = 'B'
        // ===========================


        cat.CatProperties(-100,"lambda",'R');

        // ===========================
        // METHOD CALL DRY RUN
        // ===========================

        // Parameters received:
        //
        // size  = -100
        // name  = "lambda"
        // color = 'R'
        //
        // Table representation:
        //
        // -----------------------------------------
        // | Parameter        | Object Variable    |
        // -----------------------------------------
        // | size = -100      | size = 10         |
        // | name = "lambda"  | name = "Whatever" |
        // | color = 'R'      | color = 'B'       |
        // -----------------------------------------

        // Now inside method:

        // size = size + 5
        // parameter size becomes:
        // -100 + 5 = -95

        // this.name = name
        // object.name becomes:
        // "lambda"

        // color = color
        // parameter remains 'R'
        // object.color still 'B'

        // ===========================
        // STATE BEFORE METHOD ENDS
        // ===========================

        // -----------------------------------------
        // | Parameter        | Object Variable    |
        // -----------------------------------------
        // | size = -95       | size = 10         |
        // | name = "lambda"  | name = "lambda"   |
        // | color = 'R'      | color = 'B'       |
        // -----------------------------------------

        // Printed inside method:
        // Size: -95 name: lambda color:R


        // After method finishes:
        // Parameters disappear (stack cleared)
        // Object remains.


        cat.name = "Whatever";
        // Now object.name changes back to "Whatever"

        // Final object state:
        //
        // size  = 10
        // name  = "Whatever"
        // color = 'B'


        System.out.println("Color: "+cat.color+" name: "+cat.name+" color: "+cat.color);

        // Output:
        // Color: B name: Whatever color: B

    }
}