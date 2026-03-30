package Week_5;

import java.util.LinkedList;

public class L_5_3_3_SuperWildCards {
    
    // copy method using extends + super

    public static void copy(LinkedList<? extends Integer> src, LinkedList<? super Integer> desc){
        for (Integer value: src){
            desc.add(value);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> source = new LinkedList<>();
        source.add(10);
        source.add(20);

        LinkedList<Integer> destination = new LinkedList<>();

        copy(source, destination);

        System.out.println(destination);
    }
}


/*

? What this program is about?

    * This program demonstrates:
        → Bounded wildcard with ? super
        → Copying data between lists safely

    * It combines:
        → ? extends (reading)
        → ? super (writing)


? Why are we studying this?

    * We want to safely copy elements from one list to another

    * Without breaking type safety

    * This is a very common real-world use case


? What does ? super T mean?

    * Example:

        LinkedList<? super Integer>

    * Meaning:
        → List of Integer OR its superclasses

    * Possible types:
        LinkedList<Integer>
        LinkedList<Number>
        LinkedList<Object>


? What operations are allowed?

    * Allowed:
        → Adding elements (Integer)

            dest.add(10);

    * Restricted:
        → Reading as Integer NOT safe

            Integer x = dest.get(0);  // ❌

        → Only safe as Object

            Object obj = dest.get(0); // ✅


? Why can we add?

    * Because:

        Integer fits into:
            Integer
            Number
            Object

    * So insertion is always safe


? Why can't we read as Integer?

    * Because:

        dest might be LinkedList<Object>

    * So returned value might not be Integer

    * Therefore:
        → Only Object is safe


? Copy Method Explanation

    public static void copy(
        LinkedList<? extends Integer> src,
        LinkedList<? super Integer> dest
    )

    * src:
        → Producer (we read from it)

    * dest:
        → Consumer (we write into it)


? Dry Run (Line-by-Line Execution)

    Line 1:
        LinkedList<Integer> source = new LinkedList<>();

    Line 2:
        source.add(10);

    Line 3:
        source.add(20);

        → source = [10, 20]


    Line 4:
        LinkedList<Number> destination = new LinkedList<>();

        → destination = []


    Line 5:
        copy(source, destination);

        Inside copy:

            src = source
            dest = destination

        Loop:

            value = 10 → dest.add(10)
            value = 20 → dest.add(20)

        destination becomes:
            [10, 20]


    Line 6:
        System.out.println(destination);

        → Output: [10, 20]


? Final Understanding (MOST IMPORTANT)

    * ? extends T:
        → Read only (Producer)

    * ? super T:
        → Write allowed (Consumer)

    * This follows:

        → PECS Rule

            Producer = extends
            Consumer = super


? One-line intuition

    * extends → "I will take data out"
    * super   → "I will put data in"

*/