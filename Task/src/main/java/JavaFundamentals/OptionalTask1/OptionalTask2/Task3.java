package JavaFundamentals.OptionalTask1.OptionalTask2;

public class Task3 extends Scann {
    public void main() {
        System.out.println("Enter length Array");
        int n = in.nextInt();
        System.out.println("enter the interval M");
        int M = in.nextInt();
        int Array[][] = new int[n][n];
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                Array[i][j] = (int) (-M + (Math.random()) * M);

            }
        }
        for (int[] array : Array) {
            for (int elem : array) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                if (count == 1 && Array[i][j] < 0) {
                    sum += Array[i][j];
                }
                if (Array[i][j] >= 0) {
                    count++;
                }

            }

            count = 0;
        }
        System.out.println("Sum= " + sum);
        in.close();
    }


    public static void main(String[] args) {
        new Task3().main();
    }
}