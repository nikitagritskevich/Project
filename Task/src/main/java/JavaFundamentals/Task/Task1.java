package JavaFundamentals.Task;
//1.     Приветствовать любого пользователя при вводе его имени через командную строку.

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        if (in.hasNextInt() || in.hasNextDouble()) {
            System.out.println("Is not name");
        } else {
            name = in.next();
            System.out.println("Hello, " + name);
        }
        in.close();

    }
}
