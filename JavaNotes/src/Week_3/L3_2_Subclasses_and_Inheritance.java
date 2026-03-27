package Week_3;

/*
========================================================
PARENT CLASS : Employees
========================================================

This class represents a general employee.

It contains:
1. Private data members (Encapsulation)
2. Getter and Setter methods
3. A method to calculate bonus

All subclasses (HR and Manager) will inherit from this class.
*/

class Employees1 {

    // Private variables (data hiding / encapsulation)
    private double salary;
    private String name;

    /*
    ----------------------------------------------------
    CONSTRUCTOR
    ----------------------------------------------------
    This constructor initializes employee name and salary.

    When a subclass object is created, this constructor
    will be called using super().
    */
    public Employees1(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    // Getter method for name
    public String getName(){
        return name;
    }

    // Getter method for salary
    public double getSalary(){
        return salary;
    }

    // Setter method for name
    public void setName(String name){
        this.name = name;
    }

    // Setter method for salary
    public void setSalary(double salary){
        this.salary = salary;
    }

    /*
    ----------------------------------------------------
    BONUS CALCULATION METHOD
    ----------------------------------------------------

    percent → percentage bonus

    Example:
    salary = 80000
    percent = 5

    bonus = (5/100)*80000 = 4000
    */
    public double calculate_bonus(float percent){
        return (percent/100) * salary;
    }

}


/*
========================================================
SUBCLASS : HR
========================================================

This class inherits from Employees.

Extra properties of HR:
1. employeeID
2. address
3. bonus percent
*/

class HR1 extends Employees1{

    private int employeeID;
    private String address;
    private float percent;

    /*
    ----------------------------------------------------
    HR CONSTRUCTOR
    ----------------------------------------------------

    super(name, salary) calls the parent constructor.

    Execution order when HR object is created:

    Step 1 → HR constructor called
    Step 2 → super() calls Employees constructor
    Step 3 → Employees constructor initializes name & salary
    Step 4 → HR constructor initializes employeeID, address, percent
    */
    public HR1(String name, double salary, int employeeID, String address, float percent){

        super(name, salary);   // calling parent constructor

        this.percent = percent;
        this.employeeID = employeeID;
        this.address = address;
    }


    // Setter for percent
    public void setPercent(float percent){
        this.percent = percent;
    }

    // Getter for percent
    public float getPercent(){
        return percent;
    }


    // Getter for employeeID
    public int getEmployeeID(){
        return employeeID;
    }


    // Setter for employeeID
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }

    // Getter for address
    public String getAddress(){
        return address;
    }

    // Setter for address
    public void setAddress(String address){
        this.address = address;
    }

    /*
    ----------------------------------------------------
    DISPLAY METHOD
    ----------------------------------------------------

    Shows HR employee information.

    Notice:
    getName() and getSalary() come from parent class.
    */
    public void DisplayHRInfo(){

        System.out.println("Name: "+getName());

        System.out.println("EmployeeID: "+getEmployeeID());

        System.out.println("Address: "+getAddress());

        System.out.println("Percent: "+getPercent());

        // calling parent class method
        System.out.println("Bonus: "+calculate_bonus(percent));

    }
}


/*
========================================================
SUBCLASS : Manager
========================================================

Manager also inherits from Employees.

Extra property:
department
*/

class Manager1 extends Employees1{

    private String department;
    private float percent;

    /*
    ----------------------------------------------------
    MANAGER CONSTRUCTOR
    ----------------------------------------------------

    Execution order when Manager object is created:

    Step 1 → Manager constructor runs
    Step 2 → super(name,salary) calls Employees constructor
    Step 3 → Employees constructor initializes name and salary
    Step 4 → Manager constructor initializes department and percent
    */
    public Manager1(String name, double salary, float percent, String department){

        super(name, salary);

        this.department = department;
        this.percent = percent;
    }

    // Setter for percent
    public void setPercent(float percent){
        this.percent = percent;
    }

    // Getter for percent
    public float getPercent(){
        return percent;
    }

    // Getter for department
    public String getDepartment(){
        return department;
    }

    // Setter for department
    public void setDepartment(String department){
        this.department = department;
    }

    /*
    ----------------------------------------------------
    DISPLAY METHOD
    ----------------------------------------------------

    Shows manager information.

    Note:
    getName() and getSalary() are inherited from Employees.
    */
    public void DisplayManagerInfo(){

        System.out.println("Name: "+getName());

        System.out.println("Department: "+getDepartment());

        System.out.println("Salary: "+getSalary());

        System.out.println("Percent: "+getPercent());

        // bonus calculated using parent method
        System.out.println("Bonus: "+calculate_bonus(percent));

    }
}



/*
========================================================
MAIN CLASS
========================================================

Program execution starts here.

Steps of execution:

* Step 1 → JVM starts main()
* Step 2 → HR object created
* Step 3 → HR constructor calls Employees constructor
* Step 4 → HR information displayed

* Step 5 → Manager object created
* Step 6 → Manager constructor calls Employees constructor
* Step 7 → Manager information displayed

*/

public class L3_2_Subclasses_and_Inheritance {

    public static void main(String[] args) {

        // Creating HR object
        HR1 hr1 = new HR1("Binaca", 80000, 202, "addressHR", 5);

        // Creating Manager object
        Manager1 m1 = new Manager1("Rajesh", 110000, 8, "IT");

        // Display HR information
        hr1.DisplayHRInfo();

        System.out.println("\n");

        // Display Manager information
        m1.DisplayManagerInfo();
    }
}