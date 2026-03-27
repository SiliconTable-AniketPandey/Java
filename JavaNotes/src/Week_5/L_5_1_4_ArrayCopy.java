package Week_5;

class ArrayUtils{
    public static void copy(Object[] src, Object[] tgt){
        int limit = Math.min(src.length, tgt.length); // Get the min length of one of the array

        for(int i = 0; i < limit; i++){
            tgt[i] = src[i]; // Copy src's elements to tgt
        }
    }
}


class A {
    public String toString(){return "A";}
}


class B {
    public String toString(){return "B";}
}


public class L_5_1_4_ArrayCopy {
    public static void main(String[] args) {
        A[] arrA = {new A(), new A(), new A()};
        B[] arrB = {new B(), new B(), new B()};

        ArrayUtils.copy(arrA, arrB); //  This is wrong and will produce RuntimeException Error

        for (Object x: arrB){
            System.out.println(x);
        }

    }
}


/* 
? Basically we are trying to copy one array into another 

    But why does it give a Runtime Exception Error and wbjhy not compile time?
    
    * let's do a dry run of the code

        1. A[] arrA = {new A(), new A(), new A()};
        Creates: arrA → [A@1, A@2, A@3]

        We basically create an array of class A's objects (A[]) so we can put objects in there but it should only belong to class A because of A[] no other class's objects are allowed

        
        2. B[] arrB = {new B(), new B(), new B()};
        arrB → [B@1, B@2, B@3]
        Same here aswell we are creating an Array of B class (B[]) and it will store object of class B only

        
        
        3. ArrayUtils.copy(arrA, arrB); 
        Now this will call the copy method of ArrayUtils class (we do not need to create object of ArrayUtils; copy is static) and 
        the copy method expects to recieve two object type arrays 
        A[] → Object[] ✔
        B[] → Object[] ✔   Fine no issues here 
        limit = 3


        4. for(int i = 0; i < limit; i++){
        Loop starts 

            tgt[i] = src[i]; What is happening here?
            src[0] = A@1
            tgt[0] = B@1

            ! Java tries to  Put A object into B array
            ! But remember B[] will only have objects which are of A class not A
            ! And here we get RuntimeException Error

            Why does this happen at Runtime and not Compile time?

            Compiler does not check the logic of your code.
            Compiler just sees Object[] ← Object[] ✔ allowed

            But runtime reality is different:
            B[] ← A ❌ crash

            Why did this happen I mean we know the real cause but the bigger picture is because we used Object[]

            * Object[] hides real type

            If Class B would have inhereted from class A like class B extends A {...}
            Then it would have worked but this is not the case here

            ❌ Wrong: copy(A[], B[])
            ✔ Right: copy(SUBTYPE[], SUPERTYPE[])
            * Allowed: copy(B[], A[]) IF B would have inherited from A then only like class B extends A {...}
            * So we need compile time saftey check next program to find how how to handle it using Generics L5_1_5


*/