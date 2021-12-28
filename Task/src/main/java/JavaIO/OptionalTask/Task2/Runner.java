package JavaIO.OptionalTask.Task2;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

  private final static String PUBLIC_MODIFIER_WORD = "public";

  public static void main(String[] args) {
    List<String> files = replaceAllPublicWordsInFile();

    File file = null;
    try {
      File directory = new File("D:\\newDir");
      directory.mkdir();
      file = new File(directory + File.separator + "AutoPark.txt");
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    writeFile(file, files);
  }

  private static List<String> replaceAllPublicWordsInFile() {
    List<String> lines = null;

    try (FileReader fileReader = new FileReader(
        "D:\\Project\\Task\\src\\main\\java\\JavaClasses\\AutoPark.java");
        BufferedReader reader = new BufferedReader(fileReader)) {
      lines = reader.lines().collect(Collectors.toList());
      for (int i = 0; i < lines.size(); i++) {
        String s = lines.get(i).trim();

        if (s.startsWith(PUBLIC_MODIFIER_WORD)) {
          lines.set(i, lines.get(i).replace(PUBLIC_MODIFIER_WORD, "private"));
        }
      }

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
