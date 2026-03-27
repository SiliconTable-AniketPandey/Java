package Week_5;

class Utils2{
    public static <T> void reverse(T[] arr){
        int n = arr.length;

        for (int i = 0; i < n/2; i++){
            T temp = arr[i];
            arr[i] = arr[ n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}


public class L_5_2_0_GenericReverse {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4};
        String[] words = {"A", "B", "C"};


        Utils2.reverse(nums);
        Utils2.reverse(words);

        for(int x: nums) System.out.println(x + " ");
        System.out.println();

        for (String x: words) System.out.println(x + " ");
    }    
}


/*

    RULE (CRITICAL)

    <T> MUST come before return type


    public static void <T> reverse(T[] arr)   // ❌ WRONG


    ? KEY IDEA
    T is NOT a real type
    T is a placeholder
    When you call:
    Utils.reverse(nums);

    👉 Java does:

    T = Integer
    When you call:
    Utils.reverse(words);

    👉 Java does:

    T = String
    🔥 4. FULL EXECUTION FLOW (LIKE YOU ASKED)
    STEP 1 — main starts
    Integer[] nums = {1, 2, 3, 4};

    👉 Memory:

    nums → [1, 2, 3, 4]
    STEP 2 — CALL
    Utils.reverse(nums);
    🧠 What Java does

    It sees:

    <T> void reverse(T[] arr)

    and:

    nums is Integer[]
    🔥 So Java sets:
    T = Integer
    So method becomes:
    void reverse(Integer[] arr)

    👉 (internally, conceptually)

    🔥 STEP 3 — ENTER METHOD
    T temp = arr[i];

    Now becomes:

    Integer temp = arr[i];
    🔁 STEP 4 — LOOP EXECUTION

    Initial:

    [1, 2, 3, 4]
    i = 0
    temp = 1
    arr[0] = 4
    arr[3] = 1

    👉 Array:

    [4, 2, 3, 1]
    i = 1
    temp = 2
    arr[1] = 3
    arr[2] = 2

    👉 Final:

    [4, 3, 2, 1]

*/