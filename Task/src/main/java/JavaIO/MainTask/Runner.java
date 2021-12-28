package JavaIO.MainTask;

import java.io.*;
import java.nio.file.Files;

//D:\Project\Task\src\main\java
public class Runner {

  public static void main(String[] args) {
    File file = new File(".\\file.txt");//.\\file.txt D:\Project\Task\src\main\java

    if (file.exists()) {
      if (file.isDirectory()) {
        File fileOutput = null;
        try {
          fileOutput = new File(".\\file.txt");
          fileOutput.createNewFile();
        } catch (IOException e) {
          e.printStackTrace();
        }
        writeFileTreeFunction(file, fileOutput.toString());
      } else {
        int countPath = countPath(file);
        int countFile = countFile(file);
        System.out.println(String.format("count path in file := %d", countPath));
        System.out.println(String.format("count file in all path := %d", countFile));
        if (countPath != 0) {
          System.out.println(
              String.format("average count file in path := %d", countFile / countPath));
        }
        System.out.println(
            String.format("The average file name length := %d", averageFileNameLength(file)));
      }

    }

  }

  private static void writeFileTreeFunction(File file, String fileOutput) {
    try {
      TreeFunctionWithFileVisitor treeFunctionWithFileVisitor = new TreeFunctionWithFileVisitor(
          fileOutput);
      Files.walkFileTree(file.toPath(), treeFunctionWithFileVisitor);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int countPath(File file) {
    int countPath = 0;
    try (FileReader reader = new FileReader(file); BufferedReader output = new BufferedReader(
        reader)) {
      countPath = (int) output.lines().filter(s -> s.contains("<DIR>")).count();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return countPath;
  }

  private static int countFile(File file) {
    int countFile = 0;
    try (FileReader reader = new FileReader(file); BufferedReader output = new BufferedReader(
        reader)) {
      countFile = (int) output.lines().filter(s -> s.contains("|")).count();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return countFile;
  }

  private static int averageFileNameLength(File file) {
    int averageLengthFileName = 0;
    try (FileReader reader = new FileReader(file); BufferedReader output = new BufferedReader(
        reader)) {
      averageLengthFileName = (int) output.lines().map(s -> s.length()).mapToInt(i -> i).average()
          .getAsDouble();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return averageLengthFileName;
  }
}
