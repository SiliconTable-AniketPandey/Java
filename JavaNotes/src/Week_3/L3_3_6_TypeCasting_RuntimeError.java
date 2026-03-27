package Week_3;

class Employee6{
        public void showRole(){
        System.out.println("I am an Employee");
    }
}


class Manager6 extends Employee6{
    void show(){
        System.out.println("Manager method");
    }
}

public class L3_3_6_TypeCasting_RuntimeError {    
    public static void main(String[] args) {
        Employee6 e6 = new Employee6(); // ? Employee variable e6 as employee Object , OK
    
    
        //Employee6 e6 = new Manager6(); // * This is commented out, because of that employee variable is NOT set to Manager
    
        Manager6 m6 = (Manager6) e6; // ! ❌ runtime error Trying to Type Cast employee object as Manager

        m6.show();

    }
}

// ? Check L3_3_7 for solution