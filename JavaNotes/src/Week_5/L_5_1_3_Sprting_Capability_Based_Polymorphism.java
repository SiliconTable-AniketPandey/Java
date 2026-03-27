package Week_5;

interface MyComparable {
    int compareTo(Object other);
}


class Student implements MyComparable {
    int marks; 
    String name;

    Student(int marks, String name) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Object other){
        Student s = (Student) other;

        if (this.marks > s.marks) return 1;
        if (this.marks < s.marks) return -1;
        return 0;
    }
    
    @Override
    public String toString(){
        return name + "("+marks+")";

    }
    
}


class Sorter{
    public static void simpleSort(MyComparable[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                if(arr[i].compareTo(arr[j])>0){
                    MyComparable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

public class L_5_1_3_Sprting_Capability_Based_Polymorphism {
    public static void main(String[] args) {
        Student[] students = {
            new Student(85, "A"),
            new Student(95, "B"),
            new Student(65, "C"),
            new Student(45, "D")

        };

        Sorter.simpleSort(students);

        for(Student s: students){
            System.out.println(s);
        }
    }
}
