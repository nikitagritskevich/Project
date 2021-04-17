package JavaFundamentals.OptionalTask2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие


public class Task4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length Array");
        int n = in.nextInt();
        System.out.println("enter the interval M");
        int M = in.nextInt();
        int Array[][] = new int[n][n];
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                Array[i][j] = (int) (-M + (Math.random()) * M);

            }
        }


        for (int[] array : Array) {
            for (int elem : array) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
        int maxNumber = Array[0][0];

        ArrayList<Integer> line = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                if (Array[i][j] > maxNumber) {
                    maxNumber = Array[i][j];
                }
            }
        }

        System.out.println("Max Number is : " + maxNumber);

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                if (Array[i][j] == maxNumber) {
                    line.add(i);
                    row.add(j);
                }
            }
        }


        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                if (line.contains(i) == true || row.contains(j) == true) {
                    Array[i][j] = 0;
                }
            }
        }

        System.out.println("Final Matrix : ");
        for (int[] array : Array) {
            for (int elem : array) {
                System.out.print(elem + " ");
            }
            System.out.println();

        }

    }


}





