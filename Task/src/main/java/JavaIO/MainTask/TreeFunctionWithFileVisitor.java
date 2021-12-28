package JavaIO.MainTask;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.FileVisitResult.CONTINUE;


public class TreeFunctionWithFileVisitor extends SimpleFileVisitor<Path> {
  private static int countSpace = 0;
  private final String filePath;

  public TreeFunctionWithFileVisitor(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    try (FileWriter stream = new FileWriter(filePath,
        true); BufferedWriter writer = new BufferedWriter(stream)) {
      writer.write(" ".repeat(countSpace) + "-<DIR>-> " + dir.getFileName());
      countSpace++;
      writer.newLine();
      List<File> files = Files.walk(dir, 1, FileVisitOption.FOLLOW_LINKS).map(Path::toFile)
          .filter(s -> s.isFile()).collect(Collectors.toList());
      for (File file : files) {
        writer.write(" ".repeat(countSpace) +  "|" + file.getName());
        writer.newLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return CONTINUE;

  }


}
