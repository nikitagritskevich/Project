package JavaCollections.OptionalTask.Task1;

//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("E:\\ReadFile.txt");
        List<String> list = Files.readAllLines(path);
        list.forEach(System.out::println);
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

}
