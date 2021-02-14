package JavaFundamentals.OptionalTask1.Task;
//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class Task3 extends Scann {
    public void main() {
        System.out.println("Enter quantity numbers");
        int numbers = in.nextInt();
        int Array[] = new int[numbers];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = (int) (1 + (Math.random()) * 45);
        }
        System.out.println("Output with a new line transition");
        for (int elem : Array) {
            System.out.println(elem);
        }
        System.out.println("Output from without switching to a new line");
        for (int elem : Array) {
            System.out.print(elem + " ");
        }
        in.close();

    }

    public static void main(String[] args) {
        new Task3().main();
    }
}
