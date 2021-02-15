package JavaFundamentals.OptionalTask1;
//3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

public class Task3 extends Scann {
    public void main() {
        System.out.println("Enter n");
        int n = in.nextInt();
        int quantityNumber = 0;
        String string[] = new String[n];
        for (int i = 0; i < string.length; i++) {
            string[i] = in.next();
        }
        for (int i = 0; i < string.length; i++) {
            quantityNumber += string[i].length();
        }
        quantityNumber = quantityNumber / string.length;
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() > quantityNumber) {
                System.out.println(string[i] + ": the number is larger than the average length  and its length is=" + string[i].length());
            }
        }
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() < quantityNumber) {
                System.out.println(string[i] + ": the number is less than the average length and its length is=" + string[i].length());
            }
        }
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() == quantityNumber) {
                System.out.println(string[i] + ": the number is equal to the average length and its length is=" + string[i].length());
            }
        }
        in.close();

    }

    public static void main(String[] args) {
        new Task3().main();
    }
}