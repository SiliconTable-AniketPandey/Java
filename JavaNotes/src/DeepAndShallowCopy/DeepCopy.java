package DeepAndShallowCopy;

class Engine{
    int power;

    Engine(int power){
        this.power = power;
    }
}

class Car{
    String name;
    Engine engine;

    Car(String name, Engine engine){
        this.name = name;
        this.engine = engine;
    }


    // Deep copy
    Car(Car other){
        this.name = other.name; // String is immutable so it is safe as it cannot be changed 
        this.engine = new Engine(other.engine.power); // int is mutable so we need to do this
    }
}


public class DeepCopy {
    public static void main(String[] args) {
        Engine e1 = new Engine(500);
        Car c1 = new Car("BMW", e1);
        Car c2 = new Car(c1);

        System.out.println("e1.power:"+e1.power);
        System.out.println("c1.power:"+c1.engine.power);
        System.out.println("c1.name:"+c1.name);
        System.out.println("c2.name:"+c2.name);
        System.out.println("c2.power:"+c2.engine.power);
        System.out.println("\nChaning value of c2; c2.engine.power = 1000\n");
        c2.engine.power = 1000;
        System.out.println("c2.power:"+c2.engine.power);
        System.out.println("c1.power:"+c1.engine.power);

    }
}
