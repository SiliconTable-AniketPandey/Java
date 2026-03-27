package notes;


public class StaticVSStrong {
    public static void main(String[] args) {
        System.out.println("What the Difference between static typing and Strong typing?");
        int x = 100;
        

        // Static Typing: 
            // In Java:
                // x = "Hello"; Compile time error 
                
                // The compiler immediatelty says incompitable types: String cannot be converted to integer
                // Staticily typed = Checked at compile time

            // In Python:
                // x = 10 
                // x = "hello"  # Allowed 
                // Python allows this because types are checked at runtime
        

        // Strongly typed = Strict type rules, no unsafe automatic conversions

            // A language is strongly typed if it does NOT silently convert unrealated types
            
            // Java
                int y = 100;
                String S = "Hello";


                // Java refuses unsafe conversions 
                // x = s; // Error 

            // JavaScript: --> Weekly typed language

                // x = "5" + 2;
                // console.log(x); --> 52
                // JS automatically converts types 

        
        // Static typing --> When checking happens
        // Strong typing --> How strict the checking is  


    }
}
