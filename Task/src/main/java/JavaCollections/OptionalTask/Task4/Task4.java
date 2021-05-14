package JavaCollections.OptionalTask.Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
public class Task4 {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("E:\\File.txt");
        List<String> list = Files.readAllLines(file);
        Collections.sort(list, ((o1, o2) -> o1.length() - o2.length()));
        list.forEach(System.out::println);
    }
}

