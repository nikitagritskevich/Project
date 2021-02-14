package JavaFundamentals.OptionalTask1.Task;
//2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class Task2 extends Scann {
    public void main() {
        System.out.println("Enter Argument ");
        String argument = in.next();
        String revers = new StringBuffer(argument).reverse().toString();
        System.out.println("Revers Argument: " + revers);
        in.close();
    }

    public static void main(String[] args) {
        new Task2().main();
    }
}
