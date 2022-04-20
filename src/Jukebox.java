import java.util.*;
import java.lang.*;

public class Jukebox{
     
    public static void main(String[]args)
    {
        try{
            Subscriber Subs=new Subscriber();
            Scanner scan=new Scanner(System.in);
            while(true) {
                System.out.println("--------Welcome to JUKEBOX--------");
                System.out.println(" PRESS (1) To LOG IN / PRESS (2) To REGISTER /Press (0) To EXIT");
                int in=scan.nextInt();
                switch(in){
                    case 1:
                    Subs.LogIn();break;
                    case 2:
                    Subs.CreateJBacc();break;
                    case 0: System.exit(0);break;
                    default: System.out.println("Invalid choice please enter valid choice");
                }
            }
        }catch(Exception e){System.out.println(e);}
    }
}