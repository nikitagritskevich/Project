package JavaCollections.OptionalTask.Task2;

//2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push(number % 10);
            number /= 10;
        }
        stack.forEach(System.out::print);

    }
}
