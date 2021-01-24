package Task;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter Argument ");
        String argument=in.next();
        String revers=new StringBuffer(argument).reverse().toString();
        System.out.println("Revers Argument: "+revers);
    }
}
