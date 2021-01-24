package OptionalTask1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter n");
        int n= in.nextInt();
        int quantityNumber=0;
        String string[] =new String[n];
        for (int i = 0; i < string.length ; i++) {
         string[i]=in.next();
        }
        for (int i = 0; i < string.length ; i++) {
            quantityNumber+=string[i].length();
        }
        quantityNumber=quantityNumber/string.length;
        for (int i = 0; i < string.length ; i++) {
        if(string[i].length()>quantityNumber){
            System.out.println(string[i]+": the number is larger than the average length  and its length is="+string[i].length());
        }
        }
        for (int i = 0; i < string.length ; i++) {
            if(string[i].length()<quantityNumber){
                System.out.println(string[i]+": the number is less than the average length and its length is="+string[i].length());
            }
        }
        for (int i = 0; i < string.length ; i++) {
            if(string[i].length() == quantityNumber){
                System.out.println(string[i]+": the number is equal to the average length and its length is="+string[i].length());
            }
        }
    }
}
