package DeepAndShallowCopy;   // Tells Java this file belongs to this package

// ---------------- ENGINE CLASS ----------------
class Engine{

    int power;   // Instance variable of Engine object

    Engine(int power){   // Constructor of Engine
        // When we call: new Engine(500)
        // A new Engine object is created in memory
        // The parameter 'power' receives 500
        this.power = power;  
        // this.power refers to the instance variable of the object
        // power (right side) is the constructor parameter
        // So the Engine object now stores power = 500
    }
}

// ---------------- CAR CLASS ----------------
class Car{

    String name;   // Instance variable for car name
    Engine engine; // Instance variable that stores a REFERENCE to Engine object

    Car(String name, Engine engine){

        // When we call: new Car("BMW", e1)

        // Step 2.1:
        // 'name' parameter receives "BMW"
        this.name = name;  
        // So this Car object's name becomes "BMW"

        // Step 2.2:
        // 'engine' parameter receives whatever e1 was pointing to
        // That means the reference (address) of Engine object is copied here
        this.engine = engine;  
        // Now this Car object stores the SAME Engine reference as e1
        // No new Engine is created here
    }

    // -------- SHALLOW COPY CONSTRUCTOR --------
    Car(Car other){

        // When we call: new Car(c1)

        // Step 3.1:
        // Java copies the reference stored in c1 into 'other'
        // So:
        // other ---> same Car object as c1

        // Step 3.2:
        this.name = other.name; // String is immutable so it will not change anyways
        // Copies the value of name from c1 into the new Car object
        // Since String is immutable, this is safe

        // Step 3.3:
        this.engine = other.engine; // int is mutable only reference is copied and it can change
        // IMPORTANT:
        // This copies the reference of the Engine
        // It does NOT create a new Engine
        // So both cars now point to the SAME Engine object
    }
}


// ---------------- MAIN CLASS ----------------
public class ShallowCopy {

    public static void main(String[] args) {

        // -------- STEP 1 --------
        Engine e1 = new Engine(500);

        // Dry run:
        // 1. New Engine object created in memory
        //    Engine(power = 500)
        // 2. e1 stores reference to that Engine object

        // Memory conceptually:
        // e1 ---> Engine(power=500)


        // -------- STEP 2 --------
        Car c1 = new Car("BMW", e1);

        // Dry run:
        // 1. New Car object created in memory
        // 2. "BMW" passed into constructor
        // 3. e1 reference passed into constructor
        // 4. this.name = "BMW"
        // 5. this.engine = e1 (reference copied)

        // Memory now:
        // e1 --------\
        //              \
        //               ---> Engine(power=500)
        //              /
        // c1.engine ---/


        // -------- STEP 3 --------
        Car c2 = new Car(c1);

        // Dry run:
        // 1. New Car object created in memory (separate from c1)
        // 2. c1 reference copied into parameter 'other'
        //    other ---> same object as c1
        // 3. this.name = other.name  ("BMW")
        // 4. this.engine = other.engine  (Engine reference copied)

        // Memory now:
        //
        // e1 --------\
        //              \
        //               ---> Engine(power=500)
        //              /
        // c1.engine ---/
        // c2.engine ---/
        //
        // IMPORTANT:
        // c1 and c2 are DIFFERENT Car objects
        // but they share the SAME Engine object


        // -------- PRINTING VALUES --------
        System.out.println("c1.power:"+c1.engine.power);
        // Goes to c1
        // then goes to its engine
        // then reads power
        // prints 500

        System.out.println("c2.power:"+c2.engine.power);
        // Goes to c2
        // then goes to its engine
        // but engine is SAME object as c1.engine
        // prints 500

        System.out.println("c1.name:"+c1.name);
        // Prints BMW

        System.out.println("c2.name:"+c2.name);
        // Prints BMW

        c2.engine.power = 200;

        System.out.println("c2.power:"+c2.engine.power); // 200 because it was explicitely set, but original object's value is changed
        System.out.println("e1.power:"+e1.power); // 200 Original changed because c2 was 'referencing' to e1's object it was never actually copied. And that is why it is called shallow copy

        System.out.println("c1.power:"+c1.engine.power); // Also 200 since c2.engine.power chenged e1.power

    }
}