package JavaFundamentals.Task;
//4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

import java.util.Scanner;

public class Task4 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("End of the program the word <end>");
        int sumNumbers = 0;
        int productNumbers = 1;
        while (in.hasNextInt()) {
            int number = in.nextInt();
            sumNumbers += number;
            productNumbers *= number;
            System.out.println("sum= " + sumNumbers);
            System.out.println("product= " + productNumbers);
        }
        in.close();
    }
}
