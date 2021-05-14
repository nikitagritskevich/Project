package JavaCollections.OptionalTask.Task3;

// Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("E:\\File.txt");
        ArrayList<String> list = new ArrayList<>();
        list = (ArrayList<String>) Files.readAllLines(file);
        list.forEach(System.out::println);
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
