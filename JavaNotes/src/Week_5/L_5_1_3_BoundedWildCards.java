package Week_5;


import java.util.LinkedList;
class Shape{
    void draw(){
        System.out.println("Drawing Shape");
    }
}

class Cricle extends Shape{} // Circle has draw()
class Rectangle extends Shape{} // Rectangle has draw()

public class L_5_1_3_BoundedWildCards {
    
    public static void printshape(LinkedList<? extends Shape> list ){
        for (Shape s : list){
            s.draw();
        }

        // list.add(new Shape());  ❌ Not allowed
        // list.add(new Circle()); ❌ Not allowed

    }
    
    public static void main(String[] args) {
        
        LinkedList<Cricle> circlelist = new LinkedList<>();
        circlelist.add(new Cricle());
        

        LinkedList<Rectangle> rectlist = new LinkedList<>();
        rectlist.add(new Rectangle());

        printshape(circlelist);
        printshape(rectlist);

    }
}

/*

    ? So we know that Wild Cards can take anything and the compiler does not know the type at calltime...
    ? But lets say that its ok we don't really want the compiler to know what the type is but we still want to make it 
    ? predictable..

    * What I mean to say is i want the type to be unknown but between Circle or rectangle, so basically 
    * I want to bound the wild card
    

    ? What this program is about?

        * This program demonstrates **Bounded Wildcards using ? extends**

        * Syntax:
            LinkedList<? extends Shape>

        * Meaning:
            → A list of Shape OR any subclass of Shape


    ? Why are we studying this?

        * Sometimes we want flexibility BUT with restrictions

        * We want:
            → Accept Circle, Rectangle, etc.
            → But reject unrelated types like Integer

        * This is achieved using bounded wildcards


    ? Key Concept

        * ? extends Shape means:
            → Unknown type
            → But must be a subclass of Shape

        * Possible types:
            LinkedList<Shape>
            LinkedList<Circle>
            LinkedList<Rectangle>


    ? What operations are allowed?

        * Allowed:
            → Reading elements as Shape

                Shape s = list.get(0);

        * Not allowed:
            → Adding elements


    ? Why can't we add?

        * Suppose:

            list = LinkedList<Circle>

        * If we allow:

            list.add(new Rectangle());

        * Then:
            → Rectangle goes into Circle list ❌

        * This breaks type safety

        * Therefore:
            → Java blocks all add operations


    ? What is the benefit?

        * We can write flexible methods:

            printShapes(circleList);
            printShapes(rectList);

        * Without needing separate methods


    ? Dry Run (Line-by-Line Execution)

        Line 1:
            LinkedList<Circle> circleList = new LinkedList<>();

        Line 2:
            circleList.add(new Circle());

            → circleList = [Circle]


        Line 3:
            LinkedList<Rectangle> rectList = new LinkedList<>();

        Line 4:
            rectList.add(new Rectangle());

            → rectList = [Rectangle]


        Line 5:
            printShapes(circleList);

            → list becomes ? extends Shape
            → Actual type = Circle

            Loop:
                Circle object treated as Shape
                draw() is called


        Line 6:
            printShapes(rectList);

            → list becomes ? extends Shape
            → Actual type = Rectangle

            Loop:
                Rectangle object treated as Shape
                draw() is called


    ? Final Understanding

        * ? extends T:
            → Accepts T and all subclasses

        * You can:
            → Read safely

        * You cannot:
            → Add elements

        * This is called:
            → Producer (read-only)


    ? One-line intuition

        * ? extends T → "I will only read T-type data"



*/