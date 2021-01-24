package Task;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter quantity numbers");
        int numbers=in.nextInt();
        int Array[] =new int [numbers];
        for (int i=0;i<Array.length;i++){
            Array[i]=(int)(1+(Math.random())*45);
        }
        System.out.println("Output with a new line transition");
        for (int elem:Array) {
            System.out.println(elem);
        }
        System.out.println("Output from without switching to a new line");
        for (int elem:Array) {
            System.out.print(elem+" ");
        }
    }
}
