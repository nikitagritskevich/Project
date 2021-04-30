package JavaFundamentals.OptionalTask1;
//3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n");
        int length = in.nextInt();
        int quantityNumber = 0;
        String string[] = new String[length];
        for (int i = 0; i < string.length; i++) {
            string[i] = in.next();
        }
        for (int i = 0; i < string.length; i++) {
            quantityNumber += string[i].length();
        }
        quantityNumber = quantityNumber / string.length;
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() > quantityNumber) {
                System.out.println(string[i] + ": the number is larger than the average length  and its length is=" + string[i].length());
            }
        }
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() < quantityNumber) {
                System.out.println(string[i] + ": the number is less than the average length and its length is=" + string[i].length());
            }
        }
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() == quantityNumber) {
                System.out.println(string[i] + ": the number is equal to the average length and its length is=" + string[i].length());
            }
        }
        in.close();

    }
}