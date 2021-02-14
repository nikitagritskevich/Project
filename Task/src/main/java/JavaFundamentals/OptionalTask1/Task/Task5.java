package JavaFundamentals.OptionalTask1.Task;
//5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

public class Task5 extends Scann {
    public void main(){
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                "November", "December"};
        System.out.print("Enter the month number: ");
        int monthNumbers = in.nextInt();
        if (monthNumbers > 0 && monthNumbers < 13) {
            System.out.println("Is :" + month[monthNumbers - 1]);
        } else {
            System.out.println("There is no such month");
        }
        in.close();

    }
    public static void main(String[] args) {
        new Task5().main();
        }
}
