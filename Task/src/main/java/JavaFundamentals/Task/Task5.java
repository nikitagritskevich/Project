package JavaFundamentals.Task;
//5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                "November", "December"};
        System.out.print("Enter the month number: ");
        int monthNumber = in.nextInt();
        if (monthNumber > 0 && monthNumber < 13) {
            System.out.println("Is :" + month[monthNumber - 1]);
        } else {
            System.out.println("There is no such month");
        }
        in.close();

    }
}
