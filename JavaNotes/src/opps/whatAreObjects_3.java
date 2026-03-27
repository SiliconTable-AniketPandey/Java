package opps;

public class whatAreObjects_3 {
    class innerClass{
        int x;
        void printx(){
            System.out.println("x : "+x);
        }
    }

    public static void main(String[] args) {
        // Outer object must be created first for outer class
        whatAreObjects_3 wro_3 = new whatAreObjects_3();

        // Then only the inner object can be cerated 
        innerClass ic = wro_3.new innerClass();
        ic.x = 20;
        ic.printx();
    }
}



// Why this works (simple mental model)

//      Non-static inner class lives inside outer object.

//      So JVM needs:
//      Outer object → then Inner object

//  Flow in memory:

//  Heap:
//       whatAreObjects_3 object
//          └── innerClass object (x = 20)


//  Alternative: if you make innerClass static
//      static class innerClass

//      Then you can simply do:
//      innerClass ic = new innerClass();

//  No outer object needed.