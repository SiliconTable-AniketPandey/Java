package Week_5;


class Utils{
    public static void reverse(Object[] arr){
        int n = arr.length;

        for(int i = 0; i < n/2; i++){
            Object temp = arr[i];
            arr[i]  = arr[ n - i - 1];
            arr[n -1 -i] = temp;
        }
    }
}


public class L_5_1_1_Reverse_using_ObjecttSructuralPolymorphism {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String[] letters = {"A", "B", "C", "D"};

        Utils.reverse(nums);
        Utils.reverse(letters);

        for(Object x : nums) System.out.println(x+ "");
        System.out.println();
        for(Object x : letters) System.out.println(x+ "");

    }
}


/*

? This is structural polymorphism

    We don’t care about:

        Integer

        String

        Any object

    We ONLY care about:

        Positions in array


?  Reverse does NOT need:

    equality

    comparison

    type info

Just swapping.


? Deep Understanding

    “Boxes analogy”

    You’re told:

    “Reverse boxes”

    You don’t open them. You don’t care what’s inside.

*/
