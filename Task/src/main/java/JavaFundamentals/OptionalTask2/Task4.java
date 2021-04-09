package JavaFundamentals.OptionalTask2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие


public class Task4 extends Scann {

    public void main(){

        System.out.println("Enter length Array");
        int n = in.nextInt();
        System.out.println("enter the interval M");
        int M = in.nextInt();
        double Array[][] = new double[n][n];
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                Array[i][j] = (int) (0 + (Math.random()) * 10);

            }
        }


        for (double[] array : Array) {
            for (double elem : array) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
        double maxNumber = Double.NEGATIVE_INFINITY;

        int line = 0;
        int row = 0;
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                if (Array[i][j] > maxNumber) {
                    maxNumber = Array[i][j];
                    line = i;
                    row = j;

                }
            }
        }
        for (int i = line; i < Array.length - 1; i++) {
            for (int j = 0; j < Array.length; j++) {
                Array[i][j] = Array[i + 1][j];
            }
        }
        for (int i = 0; i < Array.length; i++) {
            for (int j = row; j < Array.length - 1; j++) {
                Array[i][j] = Array[i][j + 1];
            }
        }

        double[][] finalArray = new double[n - 1][n - 1];
        for (int i = 0; i < finalArray.length; i++) {
            for (int j = 0; j < finalArray.length; j++) {
                finalArray[i][j] = Array[i][j];
            }
        }
        for (double[] array : finalArray) {
            for (double elem : array) {
                System.out.print(elem + " ");
            }
            System.out.println();

        }

    }


    public static void main(String[] args) {
        new Task4().main();
    }


}





