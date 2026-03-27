package Week_5;

class Animal{
    void speak(){
        System.out.println("Animal Speaks"); // original method
    }
    void eat(){
        System.out.println("Animal eats");
    }
}


class Dog extends Animal{

    @Override
    void speak(){
        System.out.println("Dog speaks"); // Method overriding
    }
    void run(){
        System.out.println("Dog runs");
    }
}

public class L_5_1_0_Polymorphism_Revisited {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        a1.speak(); // speak() from dog class called
        a1.eat(); // eat() method from Animal class called since compiler did't find it in Dog

        Dog d1 = (Dog) a1;

        d1.run();
    }
}


/*

    ? How this actually works?

    1. The way to understand this is look at the object creation line
        todo:  - Animal a1 = new Dog()
            a1 is the reference var and Dog is the object being refered to

    2. The JVM will want to run methods from the object i.e. the Dog object
        todo: a1.speak()
            The JVM looks for speak method from the Object class i.e. Dog class
            
            If the JVM finds the speak() method in the child class or the object class i.e
            the Dog class it will call the function and hence we get Dog speaks
    
    3. If the JVM does not find the speak method in the child or the object class, 
        if the JVM finds the speak() method in the parent class then it will call it

        An example with eat() method has been shown above, the JVM first looked for eat()
        in Dog class but did'nt find it so it went in the Animal class and found it and then
        it called that method and we get Animal eats
        
    !4. Important thing

        We cannot do a1.run() - Why?
        - Because for dynamic dipatch to work you need to have same method with same method signature in 
        the parent and the child class or the class which gives the reference var should also have same 
        method 

        So we do have a work arround to that....
        * We have to some how tell the compiler that the reference var which was earlier refereing to Dog Obj 
        * is now a dog 
        
        * so Dog d1 = (Dog) a1 is we basically telling the compiler "Hey trust me this animal is actually a Dog"
        * And that is actually the TRUTH because earlier Animal a1 = new Dog() so a1 was refering to Dog
        
        
        *  Animal a1 = new Animal()
        *  Dog d1 = (Dog) a1 is wrong because object is NOT Dog it should have been Animal a1 = new Dog()
        

*/    