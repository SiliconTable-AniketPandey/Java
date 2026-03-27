package opps;

// What is a class?
    // Class is a bluprint for an object. It tells the virtual machine how to make an object of that particular type.

//   or in more technical terms:
//      A class is a user-defined type that defines the structure (variables) and behavior (methods) of objects.


public class whatAreObjects_1 {


    // static means this belongs to the class itself, not to any object.
    // Static things can be used without creating an object of that class.
    // If you put the blueprint class and the main class you will have to declare the blueprint class as static. IT IS REQUIRED FOR IT TO WORK as main is static and cannot access things which are non static
    
    

    // You CAN declare a non-static class inside a class that contains main, but you CANNOT create its object directly inside main unless you first create an object of the outer class. This is because main is static, and static methods cannot directly use non-static members without an object.


    static class Dog{ // this is a blueprint of dog (it's a class)
        int size; // Things an object knows about itself is called instance variables 
        String breed;
        String name;

        void bark(){ // Method Construction. Things an object can do are called methods
            System.out.println("Ruff! Ruff!");
        }
    }

    public static void main(String[] args) { 
        Dog d = new Dog();
        d.size = 40; 
        d.bark(); 
    }
}

// Class (Blueprint)
// ---------------
// | Dog          |
// |--------------|
// | size         | < --- Instance Variables (state)
// | breed        | < --- Instance Variables (state)
// | name         | < --- Instance Variables (state)
// | bark()       | < --- Method (behaviour)
// ---------------


// Objedct is created only when we do ``new dog()``

// Object (Instance in memory) 
// ---------------
// | Dog object   |  <------- reference variable = d
// |--------------|
// | size = 40    |
// | breed = null |
// | name = null  |
// ---------------