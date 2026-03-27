package Week_3;

class Employee5{
    public void showRole(){
        System.out.println("I am an Employee");
    }
}



class Manager5 extends Employee5{
    public void setSecretary(String name){
        System.out.println("Secretary name: "+name);
    }
}

public class L3_3_5_TypeCasting {   
    public static void main(String[] args) {
        Employee5 e5 = new Manager5();

        e5.showRole(); // *  Works, No problem - Dynamic Dispatch

        // e5.setSecretary("Ramesh"); // ! Complier error

        /*
        
        ? Why does this fail?

            Because the variable type is Employee.

            *    Compiler checks:

            *    Does Employee have setSecretary()?

            *    Answer:

            !    No

            * So Java stops compilation.
        
        */


        // ? Solution: Type Casting - We convert the reference from Employee to Manager.

        // Casting
        ((Manager5)e5).setSecretary("Ramesh");




    }
}


/*


? Output
    * I am an Employee
    * Secretary assigned: Ramesh
    

    * What happened?

        * We converted:

        * Employee → Manager  ((Manager5)e5) e5 is now referencing to Manager class

    * This tells Java:

        * Treat this object as a Manager


*/