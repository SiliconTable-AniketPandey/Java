package Week_5;

class Finder{
    public static int find(Object[] arr, Object target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}


class Person{
    String name;

    Person(String name) {
        this.name = name;
    }

    // Overirde equals
    @Override
    public boolean equals(Object obj){
        Person p = (Person) obj;
        return this.name.equals(p.name);
    }
}

public class L_5_1_2_Find_using_Object_Equality_overriding {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice"),
            new Person("Bob")
        };

        System.out.println(Finder.find(people, new Person("Bob")));
    }
}



/*

Concept

👉 Unlike reverse, find needs:

✔ Ability to compare objects

⚠️ SUPER IMPORTANT
❌ If you used ==:
arr[i] == target

👉 compares memory addresses
👉 always fails for new objects

✅ Using .equals()

👉 compares actual content

🔁 Dry Run
Searching: new Person("Bob")

Compare:
"Bob" vs "Alice" → false
"Bob" vs "Bob" → true

Return index = 1

*/