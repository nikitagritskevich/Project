package JavaFundamentals.OptionalTask1;
//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        System.out.println("Enter n");
        String string[] = new String[length];

        for (int i = 0; i < string.length; i++) {
            string[i] = in.next();
        }
        String maxLengthStr = string[0];
        String minLengthStr = string[0];
        int minLength = string[0].length();
        int maxLength = string[0].length();
        for (int i = 0; i < string.length; i++) {
            if (minLength < string[i].length()) {
                minLength = string[i].length();
                minLengthStr = string[i];
            }
            if (maxLength > string[i].length()) {
                maxLength = string[i].length();
                maxLengthStr = string[i];
            }

        }
        System.out.println("maxLength number= " + maxLengthStr + ", and their length is= " + maxLength);
        System.out.println("minLength number= " + minLengthStr + ", and their length is= " + minLength);
        in.close();
    }
}