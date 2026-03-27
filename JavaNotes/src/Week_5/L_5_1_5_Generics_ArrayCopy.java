package Week_5;

class ArrayUtils2 {
    //Generic method with constraint

            // <ChildClass extends ParentClass, ParentClass >
    public static <S extends T, T> void copy(S[] src, T[] tgt){

        int limit = Math.min(src.length, tgt.length);

        for (int i = 0; i < limit; i++){
            tgt[i] = src[i];
        }
    }
}


class Ticket{
    public String tosString(){return "Ticket";}
}



class ETicket extends Ticket{
    public String toString(){return "ETicket";}
}

public class L_5_1_5_Generics_ArrayCopy {
    public static void main(String[] args) {
        ETicket et[] = {new ETicket(), new ETicket()};
        Ticket t[] = {new Ticket(), new Ticket()};

        ArrayUtils.copy(et, t);

        for (Ticket x: t){
            System.out.println(x);
        }

    }
}


/*
    Basically again it all comes down to That for ArrayUtils.copy(et, t); to work ETickets must be a child class of Ticket or it shoudl extend
    Ticket

    <S extends T, T>  This thing is called a generic we will study more about this in the upcomming lecture but for now this checks if S (subtype)
    extends T or not if it does its ok and the code will work if it does not it will throw a compile time error

    Syntax

    <(Subtype) extends (Supertype), (Supertype)> or <(Supertype), (Subtype) extends (Supertype)> 

    <S extends T, T> or <T, S extends T> 
*/