
package ArraysAndLoops;
import java.util.Scanner;

class ForEachLoop{
        public int sumation(int[] a){
        int sum = 0;
        for(int i : a){  // this acts like for each element in a if a = {1,2,3} 
            // sum = 0+1 = 1 when i = 1
            // sum = 1+2 = 3 when i = 2
            // sum = 3+3 = 6 when i = 3
            // finnaly sum = 6 loop ends
            sum += i; 
        } 

        return sum;
    }
}

public class ForEach {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int[] b = new int[size]; // e.g. 3
        System.out.println("Enter "+size+" numbers");
        for(int i = 0; i<b.length; i++){
            b[i] = sc.nextInt(); // 1, 2, 3
        }
        sc.close();

        ForEachLoop foreach = new ForEachLoop();

        int result = foreach.sumation(b);

        System.out.println("Sum = "+result);
    }

}

