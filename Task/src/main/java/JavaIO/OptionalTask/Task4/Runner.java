package JavaIO.OptionalTask.Task4;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Runner {

  public static void main(String[] args) {
    List<String> files = readFile();
    replaceLinesWithLengthAboveTwo(files);
    File file = null;
    try {
      File directory = new File("D:\\newDir");
      directory.mkdir();
      file = new File(directory + File.separator + "resultFile.txt");
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    writeFile(file, files);
  }

  private static List<String> readFile() {
    List<String> lines = null;
    try (FileReader fileReader = new FileReader(".\\file.txt");
        BufferedReader reader = new BufferedReader(fileReader)) {
      lines = reader.lines().map(s -> s.split(" ")).flatMap(Arrays::stream)
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  private static void replaceLinesWithLengthAboveTwo(List<String> files) {
    for (int i = 0; i < files.size(); i++) {
      if (files.get(i).length() > 2) {
        files.set(i, files.get(i).toUpperCase(Locale.ROOT));
      }
    }
  }

  private static void writeFile(File file, List<String> files) {
    try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(
        fileWriter)) {
      for (String element : files) {
        writer.write(element + " ");
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
