package Week_3;

class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /*
     * OVERLOADED version of equals()
     * --------------------------------
     * Same method name: equals
     * Different parameter type: MyDate
     *
     * This does NOT replace equals(Object o).
     * This is a separate method.
     *
     * This method will be chosen when the argument is directly of type MyDate.
     */



    public boolean equals(MyDate d) {
        System.out.println("equals(MyDate d) called");

        return this.day == d.day &&
            this.month == d.month &&
            this.year == d.year;
    }

    /*
     * OVERRIDDEN version of equals()
     * ------------------------------
     * Same method name: equals
     * Same parameter type as in Object class: Object
     *
     * Because the signature matches equals(Object o),
     * this method OVERRIDES the original equals(Object o).
     *
     * This method will be chosen when the argument is of type Object.
     */


    @Override
    public boolean equals(Object o) {
        System.out.println("equals(Object o) called");

        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;

            return this.day == d.day &&
                this.month == d.month &&
                this.year == d.year;
        }

        return false;
    }
}

class L3_3_9_OverloadingVsOverridingExample {
    public static void main(String[] args) {

        // d1 and d2 are both of type MyDate
        MyDate d1 = new MyDate(1, 1, 1988);
        MyDate d2 = new MyDate(1, 1, 1988);

        // o2 refers to d2, but its declared type is Object
        Object o2 = d2;

        /*
         * Here argument type is MyDate
         * So Java chooses equals(MyDate d)
         * because it is the exact match
         */
        System.out.println(d1.equals(d2));

        /*
         * Here argument type is Object
         * So Java chooses equals(Object o)
         * because the variable o2 is declared as Object
         */
        System.out.println(d1.equals(o2));
    }
}