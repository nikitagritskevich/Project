package JavaFundamentals.OptionalTask1;
//5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

import java.util.ArrayList;

public class Task5 extends Scann {
    public void main() {
        int n = in.nextInt();
        int Array[] = new int[n];
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        int evenNumber = 0;
        int oddNumber = 0;
        for (int i = 0; i < Array.length; i++) {
            Array[i] = in.nextInt();
        }

        for (int i = 0; i < Array.length; i++) {
            int length;
            int temp = Array[i];
            length = (int) Math.log10(temp) + 1;
            int Numbers[] = new int[length];
            int current = Array[i];
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
                evenNumbers.add(Array[i]);
            }
            if (Numbers.length == oddNumber) {
                oddNumbers.add(Array[i]);
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


    public static void main(String[] args) {
        new Task5().main();
    }
}

