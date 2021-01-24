package OptionalTask1;

import java.util.Scanner;

public class Scann {


    public abstract static class ScannerIn {
        private static Scanner scanner = new Scanner (System.in);

        public static Scanner getScanner() {
            return scanner;
        }
    }



}
