package Task;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String month[]={"January","February","March","April","May","June","July","August","September","October",
                "November","December"};
        System.out.print("Enter the month number: ");
        int monthNumbers=in.nextInt();
        if(monthNumbers>0 && monthNumbers<13){
            System.out.println("Is :"+month[monthNumbers-1]);
        }else{
            System.out.println("There is no such month");
        }
    }
}
