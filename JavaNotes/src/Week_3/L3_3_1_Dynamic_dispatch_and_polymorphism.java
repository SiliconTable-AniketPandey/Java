package Week_3;

class Employee2{
    private String name;
    private double salary;


    public Employee2(String name, double salary){
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


class Manager2 extends Employee2{

    private String secretery;

    public Manager2(String name, double salary, String secretery){
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



public class L3_3_1_Dynamic_dispatch_and_polymorphism {
    public static void main(String[] args) {
        Employee2 e2 = new Employee2("Rajat", 1000000.0);
        Manager2 m2 = new Manager2("Dr. Rathore", 1500000.0, "Jabra");

        System.out.println("Employee bonus: "+e2.calculate_bonus(5)+"\n"); 
        System.out.println("Manager bonus: "+m2.calculate_bonus(5));
    }
}

