import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;

public class FileSystemOperations {

    public static void main(String[] args) {
        Path surnameDir = Paths.get("Artyukh");
        Path nameFile = surnameDir.resolve("Vladimir");
        Path dir1 = surnameDir.resolve("dir1");
        Path dir2 = dir1.resolve("dir2");
        Path dir3 = dir2.resolve("dir3");
        Path file1 = dir1.resolve("file1");
        Path file2 = dir2.resolve("file2");

        try {
            // a.
            Files.createDirectory(surnameDir);

            // b.
            Files.createFile(nameFile);

            // c.
            Files.createDirectories(dir3);
            Files.copy(nameFile, dir3.resolve("Name"), StandardCopyOption.REPLACE_EXISTING);

            // d.
            Files.createFile(file1);

            // e.
            Files.createFile(file2);

            // f.
            Files.walk(surnameDir)
                    .forEach(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.println("D: " + path.toString());
                        } else {
                            System.out.println("F: " + path.toString());
                        }
                    });

            // g.
            Files.walk(dir1)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
