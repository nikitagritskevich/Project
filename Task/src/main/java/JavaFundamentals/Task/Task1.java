package JavaFundamentals.Task;
//1.     Приветствовать любого пользователя при вводе его имени через командную строку.

public class Task1 extends Scann {
    public void main() {
        String name;
        if (in.hasNextInt() || in.hasNextDouble()) {
            System.out.println("Is not name");
            in.hasNext();
        } else {
            name = in.next();
            System.out.println("Hello, " + name);
        }
        in.close();

    }

    public static void main(String[] args) {
        new Task1().main();
    }
}
