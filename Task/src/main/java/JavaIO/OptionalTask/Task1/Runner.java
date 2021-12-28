package JavaIO.OptionalTask.Task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {

  public static void main(String[] args) {

    try {
      File directory = new File("D:\\newDir");
      directory.mkdir();
      File file = new File(directory + File.separator + "randomNumber.txt");
      file.createNewFile();

      generateRandomIntegerValueInFile(file);
      List<Integer> numbers = sortFile(file);

      file = new File(directory + File.separator + " result.txt");
      file.createNewFile();
      writeFile(file, numbers);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void generateRandomIntegerValueInFile(File file) {
    try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(
        fileWriter)) {
      Random random = new Random();
      for (int i = 0; i < 20; i++) {
        writer.write(random.nextInt(20) + " ");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static List<Integer> sortFile(File file) {
    List<Integer> numbers = null;
    try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(
        fileReader)) {

      numbers = reader.lines().map(s -> s.split(" ")).flatMap(Arrays::stream).map(Integer::parseInt)
          .sorted().collect(Collectors.toList());

    } catch (IOException e) {
      e.printStackTrace();
    }
    return numbers;
  }

  private static void writeFile(File file, List<Integer> numbers) {
    try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(
        fileWriter)) {
      for (Integer value : numbers) {
        writer.write(value + " ");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
