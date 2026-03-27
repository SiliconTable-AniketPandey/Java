package opps;


class Dog{ // This is an independent class and out of the class which contains main so it does not need static.
    int size;
    String breed;
    String color;
    
    void bark(){
        System.out.println("Huff");
    }

    void display(){
        System.out.println("Size: " +size+ "\ncolor: "+color+"\nbreed: "+breed);
    }
}


public class whatAreObjects_2 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.size = 40;
        d.color = "black";
        d.breed = "Indian pariah";
        d.bark();
        d.display();

    }

}


// In Java:

    // class
        //   variables
        //   methods

    // method
        //   statements only

    // method
        // another method?  ❌ illegal