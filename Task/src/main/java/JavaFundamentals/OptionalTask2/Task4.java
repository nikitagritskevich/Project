package JavaFundamentals.OptionalTask2;

import java.util.*;

//4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие


public class Task4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length Array");
        int length = in.nextInt();
        System.out.println("enter the interval M");
        int M = in.nextInt();
        int array[][] = new int[length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (-M + (Math.random()) * M);

            }
        }


        for (int[] rowArray : array) {
            for (int elem : rowArray) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
        int maxNumber = array[0][0];

        Set<Integer> line = new HashSet<Integer>() ;
        Set<Integer> row = new HashSet<Integer>() ;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxNumber) {
                    maxNumber = array[i][j];
                }
            }
        }

        System.out.println("Max Number is : " + maxNumber);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == maxNumber) {
                    line.add(i);
                    row.add(j);
                }
            }
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (line.contains(i) || row.contains(j)) {
                    array[i][j] = 0;
                }
            }
        }

        System.out.println("Final Matrix : ");
        for (int[] arrayRow : array) {
            for (int elem : arrayRow) {
                System.out.print(elem + " ");
            }
            System.out.println();

        }

    }


}





