package Week_3;

/*

! Method overriding Neans

    * same method name
    * same parameters
    * different implementation
    ! Descision time : runtime

    ? Also known as runtime Polymorphism if Dyamic dispach and overriding is used together

*/


class Employee4{
    public double calculate_bonus(float percent){
        return percent * 100;
    }
}

class Manager4 extends Employee4{

    @Override 
    public double calculate_bonus(float percent){
        return 1.5 * super.calculate_bonus(percent);  //     * different implementation
    }
}


public class L3_3_4_Method_Overriding {
    public static void main(String[] args) {
        Employee4 e4 = new Employee4();
        System.out.println("Employee Bonus: "+e4.calculate_bonus(10));

        Manager4 m4 = new Manager4();
        System.out.println("Employee Bonus: "+m4.calculate_bonus(10));


        Employee4 e5 = new Manager4();
        System.out.println("New employee Bonus: "+e5.calculate_bonus(10)); // * Dynamic Dispatch

    }
}




/*

? Difference between Overloading and Overiding

| Feature       | Overloading  | Overriding     |
| ------------- | ------------ | -------------- |
| Method name   | same         | same           |
| Parameters    | different    | same           |
| Class         | same class   | parent + child |
| Decision time | compile time | runtime        |




*/