package Week_3;


class Employee7{
        public void showRole(){
        System.out.println("I am an Employee");
    }
}


class Manager7 extends Employee7{
    void show(){
        System.out.println("Manager method");
    }
}


public class L3_3_7_TypeCasting_Using_instanceof {
    public static void main(String[] args) {


        Employee7 e7 = new Manager7(); // todo This is very importnat for the try block to work 

        try {
            if(e7 instanceof Manager7){
                Manager7 m7 = (Manager7) e7;

                m7.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


/*

? What instanceof Does?

    * instanceof checks the runtime object type.

    * Example:

    * if(e7 instanceof Manager7)

        * means:

        * Is this object actually a Manager?

        * If true → safe to cast.


*/