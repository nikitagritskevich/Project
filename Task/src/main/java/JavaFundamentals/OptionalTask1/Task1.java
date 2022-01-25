package JavaFundamentals.OptionalTask1;
//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n");
        int length = in.nextInt();
        
        String[] lineNumber = new String[length];

        for (int i = 0; i < lineNumber.length; i++) {
            lineNumber[i] = in.next();
        }
        String maxLengthStr = lineNumber[0];
        String minLengthStr = lineNumber[0];
        int minLength = lineNumber[0].length();
        int maxLength = lineNumber[0].length();
        for (int i = 0; i < lineNumber.length; i++) {
            if (minLength < lineNumber[i].length()) {
                minLength = lineNumber[i].length();
                minLengthStr = lineNumber[i];
            }
            if (maxLength > lineNumber[i].length()) {
                maxLength = lineNumber[i].length();
                maxLengthStr = lineNumber[i];
            }

        }
        System.out.println("maxLength number= " + maxLengthStr + ", and their length is= " + maxLength);
        System.out.println("minLength number= " + minLengthStr + ", and their length is= " + minLength);
        in.close();
    }
}