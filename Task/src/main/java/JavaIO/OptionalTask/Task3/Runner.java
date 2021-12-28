package JavaIO.OptionalTask.Task3;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

  public static void main(String[] args) {
    List<String> files = reversLinesInFile();

    File file = null;
    try {
      File directory = new File("D:\\newDir");
      directory.mkdir();
      file = new File(directory + File.separator + "ReversAutoPark.txt");
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    writeFile(file, files);
  }

  private static List<String> reversLinesInFile() {
    List<String> lines = null;
    try (FileReader fileReader = new FileReader(
        "D:\\Project\\Task\\src\\main\\java\\JavaClasses\\AutoPark.java");
        BufferedReader reader = new BufferedReader(fileReader)) {
      lines = reader.lines().map(StringBuffer::new).map(StringBuffer::reverse)
          .map(StringBuffer::toString).collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  private static void writeFile(File file, List<String> files) {
    try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(
        fileWriter)) {
      for (String elem : files) {
        writer.write(elem);
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}