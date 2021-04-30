package JavaFundamentals.OptionalTask1;
//5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        int evenNumber = 0;
        int oddNumber = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            int lengthNewArray;
            int temp = array[i];
            lengthNewArray = (int) Math.log10(temp) + 1;
            int Numbers[] = new int[lengthNewArray];
            int current = array[i];
            for (int j = 0; j < Numbers.length; j++) {
                Numbers[j] = current % 10;
                current /= 10;


            }

            for (int j = 0; j < Numbers.length; j++) {

                if ((Numbers[j] % 2) == 0) {
                    evenNumber++;
                } else {
                    oddNumber++;
                }
            }
            if (Numbers.length == evenNumber) {
                evenNumbers.add(array[i]);
            }
            if (Numbers.length == oddNumber) {
                oddNumbers.add(array[i]);
            }
            oddNumber = 0;
            evenNumber = 0;
        }
        System.out.println("Even numbers Array: ");
        for (int elem : evenNumbers) {
            System.out.print(elem + " ");
        }
        System.out.println();
        System.out.println("Odd numbers Array: ");
        for (int elem : oddNumbers) {
            System.out.print(elem + " ");
        }
    }
}

