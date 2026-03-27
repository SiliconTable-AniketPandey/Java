package Week_5;


class ArrayUtilsGeneric{
    public static <T> void copy(T[] src, T[] target){

        int limit = Math.min(src.length, target.length);

        for (int i = 0; i < limit; i++){
            target[i] = src[i];
        }
    }
}

class GenericStudent{
    int marks;
    String name;

    public GenericStudent(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    @Override
    public String toString(){
        return name + "(" + marks + ")";
    }

    
}

public class L_5_2_2_Generic_Array_Copy_Same_Type_Only {
    public static void main(String[] args) {
        GenericStudent[] src = {
            new GenericStudent(85, "A"),
            new GenericStudent(30, "B"),
            new GenericStudent(57, "C"),
            new GenericStudent(55, "D"),

        };

        GenericStudent[] target = {
            new GenericStudent(100, "A"),
            new GenericStudent(90, "B"),
            new GenericStudent(90, "C"),
            new GenericStudent(80, "D"),

        };

        ArrayUtilsGeneric.copy(src, target);

        for (GenericStudent x : target){
            System.out.println(x);
        }
    }

}






/*

?  In this program we are trying to copy elements from one array → another array WITHOUT INHERITANCE

    ------------------------------------------------------------
    3. WHY USE GENERICS HERE?
    ------------------------------------------------------------
    1. REUSABILITY: You can use the same ArrayUtilsGeneric.copy() 
    method for String arrays, Integer arrays, or any custom 
    Object array without rewriting the logic.
    
    2. TYPE SAFETY: If you tried to copy a String[] into a 
    GenericStudent[], the compiler would give an error 
    immediately, preventing a crash at runtime.

    3. NO CASTING: Because the method knows the type 'T', you 
    don't have to manually cast (GenericStudent)target[i], 
    making the code cleaner.
    ============================================================

    Only thing is that you have to keep in mid that src and target sould be of same type if src is of Student type then target
    should also be of student type 

    eg
        copy(Student[], Student[]) ✔
        copy(Integer[], Integer[]) ✔
        
        copy(Student[], String[]) ❌ compile-time error
*/