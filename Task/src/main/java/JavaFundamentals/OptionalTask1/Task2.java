package JavaFundamentals.OptionalTask1;
//2.Вывести числа в порядке возрастания (убывания) значений их длины.


import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length");
        int length = in.nextInt();
        String[] array = new String[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the numbers :");
            array[i] = in.next();
        }
        for (int i = 0; i < array.length  - 1; i++) {
            for (int j = (array.length - 1); j > i; j--) {
                if (array[j - 1].length() > array[j].length()) {
                    String temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (String elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = (array.length - 1); j > i; j--) {
                if (array[j - 1].length() < array[j].length()) {
                    String temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (String elem : array) {
            System.out.print(elem + " ");
        }
    }
}