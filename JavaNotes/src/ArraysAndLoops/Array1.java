package ArraysAndLoops;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        int[] a;
        a = new int[10];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        a[5] = 6;
        a[6] = 7;
        a[7] = 8;
        a[8] = 9;
        a[9] = 10;

        // a = {0,1,2,3,4,5,6,7,8,9}; not allowed

        for(int i = 0; i < 10; i++){
            System.out.println("a"+i+": "+a[i]);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of new array: ");
        int size = sc.nextInt();

        int[] b = new int[size];
        System.out.println("Enter "+size+" values now");

        for(int i = 0; i < b.length; i++){
            b[i] = sc.nextInt();
        }


        for(int i = 0; i < b.length; i++){
            System.out.println("b"+i+": "+b[i]);
        }

        System.out.println("Length of array : "+b.length);
        System.out.println("First element of array: "+b[0]);
        System.out.println("Last element of array: "+b[b.length-1]);
    }
}
