// ? == vs equals() and overriding equals()



package Week_3;

// This class represents an Employee object
class Employee8 {

    // Instance variable: stores employee name
    private String name;


    public Employee8(String name) {

        this.name = name;
    }

    // Overriding equals() from Object class
    // This method compares object contents, not memory address
    @Override
    public boolean equals(Object o) {

        // First check whether the incoming object is of type Employee8
        if (o instanceof Employee8) {

            // Typecast Object into Employee8
            // Now we can access Employee8 data safely
            Employee8 e8 = (Employee8) o;

            // Compare names of both Employee8 objects
            return this.name.equals(e8.name);
        }

        // If object is not Employee8, they are not equal
        return false;
    }
}


public class L3_3_8_Overriding_Equals {
    public static void main(String[] args) {

        // Creating first Employee8 object
        Employee8 e9 = new Employee8("Ravi");

        // Creating second Employee8 object
        // Same content, but different object in memory
        Employee8 e10 = new Employee8("Ravi");

        // e11 points to the same object as e9
        Employee8 e11 = e9;

        // == checks reference equality
        // e9 and e10 are different objects
        System.out.println(e9 == e10);   // false

        // equals() checks content equality because we overrode it
        // e9 and e11 have same content
        System.out.println(e9.equals(e11)); // true

        // e9 and e11 point to the same object
        System.out.println(e9 == e11);   // true

        // e9 and e10 are different objects
        // but their names are the same
        System.out.println(e9.equals(e10)); // true
    }
}