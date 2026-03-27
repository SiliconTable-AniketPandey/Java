package Week_5;

class Utils3{
    public static <T> int find(T[] arr, T target){
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}


class StudentMaker{
    int marks;
    String name;

    StudentMaker(int marks, String name){
        this.marks = marks;
        this.name = name;

    }

    @Override
    public boolean equals(Object obj){
        Student s = (Student) obj; // This obj is actually a student
        return this.marks == s.marks && this.name.equals(s.name);
    }

    public String toString(){
        return name + "(" + marks+ ")";
    }
}

public class L_5_2_1_GenericFind {
    public static void main(String[] args) {
        StudentMaker[] students = {
            new StudentMaker(85, "A"),
            new StudentMaker(85, "B"),
            new StudentMaker(85, "C"),

        };

        Student target = new Student(95, "B");
        int index = Utils3.find(students, target);
        System.out.println(index);
    }

}

/*

HOW GENERICS WORK IN THIS PROGRAM

* The method is written as: public static <T> int find(T[] arr, T target)

* <T> is a generic type placeholder

* It allows the method to work with any data type

* When calling: Utils.find(students, target)

* Java replaces T with Student automatically

* So it becomes: int find(Student[] arr, Student target)

* This ensures:

  * Type safety (only Student type allowed here)
  * Reusability (same method can work with Integer, String, etc.)

* Comparison uses: arr[i].equals(target)

* Since Student overrides equals(), custom comparison happens

* It compares marks and name, not memory reference

EXECUTION FLOW (STEP BY STEP)

    1. Program starts in main()

    2. Student array is created:
    A(85), B(95), C(65)

    3. Target object is created:
    B(95)

    4. Method call:
    Utils.find(students, target)

    5. Generic type T becomes Student

    6. Loop execution:

    i = 0
    arr[0] = A(85)
    compare with B(95) → not equal

    i = 1
    arr[1] = B(95)
    compare with B(95) → equal
    equals() returns true

    7. Method returns index = 1

    8. Output printed:
    1

KEY POINTS

* Generics allow one method to work with different types
* T is replaced at compile time
* equals() must be overridden for object comparison
* Without equals(), comparison would fail even if data is same


*/