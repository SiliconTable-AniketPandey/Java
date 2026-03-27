package Week_3;

class Employee3{
    private String name;
    private double salary;


    public Employee3(String name, double salary){
        this.name = name;
        this.salary = salary;

    }

    public double calculate_bonus(float percent){
        return (percent/100) * salary;
    }

    // get salary
    public double getSalary(){
        return salary;
    }

    
    // get name
    public String getName(){
        return name;
    }

    


    // set name
    public void setName(String name){
        this.name  = name;
    }


    // set saalry
    public void setSalary(double salary){
        this.salary  = salary;
    }



}


class Manager3 extends Employee3{

    private String secretery;

    public Manager3(String name, double salary, String secretery){
        super(name, salary);
        this.secretery = secretery;
    }


    // set secretary
    public void setSecretary(String secretary){
        this.secretery = secretary;
    }

    // get secretary
    public String getSecretary(){
        return secretery;
    }

    @Override
    public double calculate_bonus(float percent){ // Overriding the calculate_bonus method of Employee class
        return 1.5 * super.calculate_bonus(percent);
    }
}





public class L3_3_2_Dynamic_dispatch_and_polymorphism {
    public static void main(String[] args) {
        Employee3 e3 = new Employee3("Pagal", 500000); // Object type = Employee
        Employee3 e4 = new Manager3("Gadha", 1500000, "Jabra"); // Object type = Manager

        System.out.println(e3.calculate_bonus(10)); // Employee calculate_bonous
        System.out.println(e4.calculate_bonus(10)); // Manager calculate_bonous

    }
}


/*

Reference e2
*     |
*     v
-------------------------
|   Employee part       |
| name                  |
| salary                |
| calculate_bonus()     |
-------------------------
|   Manager part        |
| secretary             |
| calculate_bonus()     |
-------------------------


Execution

    First call

            e1.calculate_bonus(5)

        object type = Employee

        Employee.calculate_bonus()




    Second call

            e2.calculate_bonus(5)

        object type = Manager

        Manager.calculate_bonus()



This happens automatically.

No if statements needed.



Reference e1
    |
    v
-------------------------
|   Employee object     |
-------------------------
| name = Rajat          |
| salary = 1000000      |
| calculate_bonus()     |
-------------------------


!   Start
    |
    |  Method call happens
    |  Example: e.calculate_bonus(5)
    |
    v
Check REFERENCE TYPE (compile-time check)
(e is declared as Employee)
    |
    |
!    |----  Does Employee class contain calculate_bonus() ?
    |         |
    |         |---- NO
    |         |        |
    |         |        v
    |         |   COMPILATION ERROR
    |         |   Method not allowed
    |         |
    |         |
    |         |---- YES
    |                  |
    |                  v
    |           Program compiles
    |
    v
    Runtime Execution Begins
    |
    |
    v
!Check ACTUAL OBJECT TYPE
(e may point to Employee or Manager)
    |
    |
    if---- Object is Employee
    |         |
    |         v
    |   Run Employee.calculate_bonus()
    |
    |
    if---- Object is Manager
            |
            v
    Does Manager override calculate_bonus() ?
            |
            |
            if---- YES
            |        |
            |        v
            |   Run Manager.calculate_bonus()
            |
            |
            if---- NO
*                     |
*                     v
*             Run Employee.calculate_bonus()




*/ 