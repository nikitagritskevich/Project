package JavaFundamentals.OptionalTask1.Task;
//4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

public class Task4 extends Scann {
    public void main() {
        System.out.println("End of the program the word <end>");
        int sum = 0;
        int product = 1;
        while (in.hasNextInt()) {
            int number = in.nextInt();
            sum += number;
            product *= number;
            System.out.println("sum= " + sum);
            System.out.println("product= " + product);
        }
        in.close();
    }

    public static void main(String[] args) {
        new Task4().main();
    }
}
