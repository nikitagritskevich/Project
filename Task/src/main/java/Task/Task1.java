package Task;

import java.util.Scanner;

public class Task1
{
    public static void main( String[] args )
    {
        Scanner in =new Scanner(System.in);
        String name;
        if (in.hasNextInt() || in.hasNextDouble()){
            System.out.println("Is not name");
            in.hasNext();
        }else {
            name = in.next();
            System.out.println("Hello, " + name);
        }


    }
}
