package JavaFundamentals.OptionalTask2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length Array");
        int length = in.nextInt();
        System.out.println("enter the interval M");
        int M = in.nextInt();
        int array[][] = new int[length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (-M + (Math.random()) * M);

            }
        }
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        int count = 0;
        int sumNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (count == 1 && array[i][j] < 0) {
                    sumNumbers += array[i][j];
                }
                if (array[i][j] >= 0) {
                    count++;
                }
            }
            count = 0;
        }
        System.out.println("Sum= " + sumNumbers);
        in.close();
    }
}