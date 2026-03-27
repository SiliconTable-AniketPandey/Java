package Week_3;

/*

? What is overloading?

    * Same method name but different parameters. 

    * Overloading = compile-time decision

    * diffrent signature is necessary 

    ! Descision time : Compiletime

    ? Also called complietime Polymorphism

*/ 


class Calculator{
    //method1 

    int add(int a, int b){                  // Signature add(int, int)
        System.out.println("Add(int, int) called");
        return a + b;
    }

    
    long add(long a, long b){               // Signature add(long, long)
        System.out.println("Add(long, long) called");
        return a + b;
    }

    
    float add(float a, float b){            // Signature add(float, float)
        System.out.println("Add(float, float) called");
        return a + b;
    }

    
    double add(double a, double b, double c){   // Signature add(double, double, double)
        System.out.println("Add(double, double, double) called");
        return a + b + c;
    }
}





public class L3_3_3_Method_Overloading {
    public static void main(String[] args) {
        
        Calculator c = new Calculator();

        System.out.println(c.add(2, 3));
        System.out.println(c.add(2.3f,4.4f));
        System.out.println(c.add(1d, 2d, 3d));
        System.out.println(c.add(1l, 2l));

    }    
}
