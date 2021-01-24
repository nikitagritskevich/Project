package Task;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("End of the program the word <end>");
        int sum=0;
        int product=1;
        while(in.hasNextInt()){
            int number=in.nextInt();
            sum+=number;
            product*=number;
            System.out.println("sum= "+sum);
            System.out.println("product= "+product);
        }
    }
}
