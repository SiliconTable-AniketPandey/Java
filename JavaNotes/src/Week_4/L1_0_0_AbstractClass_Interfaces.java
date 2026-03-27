package Week_4;


abstract class Shape{ // Below is an abstract method that is why the class is also required to be abstract it is a rule 
    String name;

    public Shape(String name){
        this.name = name;
    }

    public void showName(){
        System.out.println("Shape: "+name);
    }

    public abstract double perimeter(); // An incomplete method the child calss MUST complete this method for the program to compile it is RULE
}


interface Measurable{
    int cmp(Measurable other); 
}


class Circle extends Shape implements Measurable {
    private double radius;

    public Circle(double radius){
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public int cmp(Measurable other){
        if (other instanceof Circle){
            Circle c = (Circle) other; // cast required
            if(this.radius < c.radius) return -1;
            if(this.radius > c.radius) return 1;
            return 0;
        }
        return 0;
    }

    public double getRadius(){
        return radius;
    }
}

class Square extends Shape implements Measurable{
    private double side;

    public Square(double side){
        super("Square");
        this.side = side;
    }

    @Override
    public double perimeter(){
        return 4*side;
    }

    @Override
    public int cmp(Measurable other){
        if(other instanceof Square){
            Square s = (Square) other; // cast required
            if(this.side < s.side) return -1;
            if(this.side > s.side) return 1;
            return 0;
        }
        return 0;
    }

    public double getSide(){
        return side;
    }
}


class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double perimeter(){
        return 2*(length + width);
    }
}

public class L1_0_0_AbstractClass_Interfaces {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle(2);
        arr[1] = new Square(4);
        arr[2] = new Rectangle(3,5);


        for(Shape s : arr){
            s.showName();
            System.out.println("Perimeter = "+ s.perimeter());
            System.out.println();
        }

        Circle c1 = new  Circle(3);
        Circle c2 = new  Circle(5);

        System.out.println("c1 compared to c2 = "+c1.cmp(c2));
        System.out.println("c2 compared to c1 = "+c2.cmp(c1));
        System.out.println("c2 compared to new Circle(3) = "+c1.cmp(new Circle(3)));



    }
}
















/*


RULES FOR ABSTRACT CLASS AND INTERFACE IN JAVA

====================================
1) RULES FOR ABSTRACT CLASS
====================================

    Rule 1: An abstract class must be declared using the keyword abstract.

    Legal:
    abstract class Shape {
    }

    Illegal:
    class Shape {
        abstract void draw();
    }

    Reason:
    If a class contains an abstract method, the class itself must be abstract.

? -------------------------------------------------------------------------------------

Rule 2: An abstract class can contain both abstract methods and concrete methods.

Legal:
abstract class Shape {
    abstract double area();

    void info() {
        System.out.println("This is a shape");
    }
}

? ------------------------------------------------------------------------------------------

Rule 3: An abstract method has no body.

Legal:
abstract class Shape {
    abstract double area();
}

Illegal:
abstract class Shape {
    abstract double area() {
        return 0;
    }
}

? ------------------------------------------------------------------------------------------
Reason:
Abstract methods only have declaration, not implementation.


Rule 4: You cannot create an object of an abstract class.

Illegal:
abstract class Shape {
    abstract double area();
}

Shape s = new Shape();

Legal:
Shape s;

Legal:
class Circle extends Shape {
    double area() {
        return 3.14;
    }
}

Shape s = new Circle();

? ------------------------------------------------------------------------------------------


Rule 5: A subclass of an abstract class must implement all abstract methods, otherwise the subclass must also be abstract.

Legal:
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double area() {
        return 3.14;
    }
}

Legal:
abstract class Shape {
    abstract double area();
}

abstract class Circle extends Shape {
}

Illegal:
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
}

Reason:
A concrete class cannot leave inherited abstract methods unimplemented.


? ------------------------------------------------------------------------------------------

Rule 6: An abstract class can have constructors.

Legal:
abstract class Shape {
    Shape() {
        System.out.println("Shape constructor");
    }
}


Rule 7: An abstract class can have variables.

Legal:
abstract class Shape {
    String color;
}


Rule 8: An abstract class can extend another class and can implement interfaces.

Legal:
class A {
}

interface Printable {
    void print();
}

abstract class B extends A implements Printable {
}


Rule 9: A class can extend only one class.

Legal:
class A {
}

class B extends A {
}

Illegal:
class A {
}

class B {
}

class C extends A, B {
}

Reason:
Java does not support multiple inheritance of classes.


====================================
2) RULES FOR INTERFACE
====================================

Rule 1: An interface is declared using the keyword interface.

Legal:
interface Printable {
    void print();
}


Rule 2: A class uses implements to use an interface.

Legal:
interface Printable {
    void print();
}

class Report implements Printable {
    public void print() {
        System.out.println("Printing report");
    }
}

Illegal:
interface Printable {
    void print();
}

class Report extends Printable {
}

Reason:
A class implements an interface, not extends it.


Rule 3: You cannot create an object of an interface.

Illegal:
interface Printable {
    void print();
}

Printable p = new Printable();

Legal:
Printable p;

Legal:
class Report implements Printable {
    public void print() {
        System.out.println("Printing");
    }
}

Printable p = new Report();


Rule 4: A class implementing an interface must implement all its methods, otherwise the class must be abstract.

Legal:
interface Printable {
    void print();
}

class Report implements Printable {
    public void print() {
        System.out.println("Printing");
    }
}

Legal:
interface Printable {
    void print();
}

abstract class Report implements Printable {
}

Illegal:
interface Printable {
    void print();
}

class Report implements Printable {
}

Reason:
A concrete class must implement all interface methods.


Rule 5: A class can implement multiple interfaces.

Legal:
interface A {
    void f();
}

interface B {
    void g();
}

class C implements A, B {
    public void f() {
        System.out.println("f");
    }

    public void g() {
        System.out.println("g");
    }
}


Rule 6: An interface can extend multiple interfaces.

Legal:
interface A {
    void f();
}

interface B {
    void g();
}

interface C extends A, B {
    void h();
}


Rule 7: A class can extend one class and implement multiple interfaces.

Legal:
class Shape {
}

interface Printable {
    void print();
}

interface Showable {
    void show();
}

class Circle extends Shape implements Printable, Showable {
    public void print() {
        System.out.println("print");
    }

    public void show() {
        System.out.println("show");
    }
}


====================================
3) RULES COMPARING ABSTRACT CLASS AND INTERFACE
====================================

Rule 1: Use extends for class-to-class inheritance.

Legal:
abstract class Shape {
}

class Circle extends Shape {
}


Rule 2: Use implements for class-to-interface relation.

Legal:
interface Printable {
    void print();
}

class Report implements Printable {
    public void print() {
        System.out.println("print");
    }
}


Rule 3: A class cannot extend an interface.

Illegal:
interface A {
}

class B extends A {
}


Rule 4: An interface cannot implement a class.

Illegal:
class A {
}

interface B implements A {
}


Rule 5: A class can extend only one class but can implement many interfaces.

Legal:
class A {
}

interface X {
    void f();
}

interface Y {
    void g();
}

class B extends A implements X, Y {
    public void f() {
    }

    public void g() {
    }
}

Illegal:
class A {
}

class B {
}

class C extends A, B {
}


====================================
4) COMMON LEGAL AND ILLEGAL EXAMPLES
====================================

Example 1: Legal
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}


Example 2: Illegal
abstract class Animal {
    abstract void sound();
}

Animal a = new Animal();


Example 3: Legal
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Flying");
    }
}


Example 4: Illegal
interface Flyable {
    void fly();
}

class Bird extends Flyable {
}


Example 5: Legal
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

Animal a = new Dog();


Example 6: Illegal
interface X {
    void f();
}

class A implements X {
}

Reason:
Method f() was not implemented.


====================================
5) VERY SHORT EXAM RULES
====================================

1. An abstract class cannot be instantiated.
2. An interface cannot be instantiated.
3. If a class has an abstract method, the class must be abstract.
4. An abstract method cannot have a body.
5. A concrete subclass must implement all inherited abstract methods.
6. A concrete class implementing an interface must implement all interface methods.
7. A class extends one class only.
8. A class can implement multiple interfaces.
9. An interface can extend multiple interfaces.
10. Use extends for classes.
11. Use implements for interfaces.

*/