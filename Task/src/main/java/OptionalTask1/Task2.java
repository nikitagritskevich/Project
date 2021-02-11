package OptionalTask1;
//2.Вывести числа в порядке возрастания (убывания) значений их длины.

import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n");
        int n = in.nextInt();
        String[] Array = new String[n];
        for (int i = 0; i < Array.length; i++) {
            System.out.println("Enter the numbers :");
            Array[i] = in.next();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = (n - 1); j > i; j--) {
                if (Array[j - 1].length() > Array[j].length()) {
                    String temp = Array[j - 1];
                    Array[j - 1] = Array[j];
                    Array[j] = temp;
                }
            }
        }
        for (String elem : Array) {
            System.out.print(elem + " ");
        }
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            for (int j = (n - 1); j > i; j--) {
                if (Array[j - 1].length() < Array[j].length()) {
                    String temp = Array[j - 1];
                    Array[j - 1] = Array[j];
                    Array[j] = temp;
                }
            }
        }
        for (String elem : Array) {
            System.out.print(elem + " ");
        }
    }
}
