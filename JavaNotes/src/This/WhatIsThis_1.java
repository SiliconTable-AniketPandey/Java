package This;

class Dog{
    int size;
    String name;
    char color;

// This means: “THIS current object. The one I am inside right now.”

    void  DogProperties(int size, String name, char color){
        this.size = size; // This is pointing to the Dog class object's instance variables 
        this.name = name; // This is pointing to the Dog class object's instance variables 
        this.color = color; // This is pointing to the Dog class object's instance variables 
        System.out.println("Size: "+size+" name: "+name+" color: "+color);
    }
}



class WhatIsThis_1{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.DogProperties(52,"Dobby",'R');
    }
}
