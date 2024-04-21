package SecondTask;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class Directory {

    public static void main(String[] args) throws IOException {
        String userName = System.getProperty("user.name");
        Path userDir = Paths.get(userName);

        createDirectory(userDir);
        createFile(userDir);
        createNestedDirectories(userDir, new String[]{"dir1", "dir1/dir2", "dir1/dir2/dir3"});
        copyFile(userDir, userDir.resolve("dir1/dir2/dir3/artyukh_vladimir.txt"));
        createFiles(userDir, new String[]{"dir1/file1", "dir2/file2"});
        printFilesAndDirs(userDir);
        deleteDirectory(userDir.resolve("dir1"));
    }

    private static void createDirectory(Path dir) throws IOException {
        Files.createDirectories(dir);
    }

    private static void createFile(Path dir) throws IOException {
        Path filePath = dir.resolve("artyukh_vladimir.txt");
        Files.createFile(filePath);
    }

    private static void createNestedDirectories(Path dir, String[] dirs) throws IOException {
        for (String dirPath : dirs) {
            createDirectory(dir.resolve(dirPath));
        }
    }

    private static void copyFile(Path dir, Path dest) throws IOException {
        Files.copy(dir.resolve("artyukh_vladimir.txt"), dest);
    }

    private static void createFiles(Path dir, String[] filePaths) throws IOException {
        for (String filePath : filePaths) {
            Path fullPath = dir.resolve(filePath);
            // Check if parent directory exists before creating the file
            if (Files.notExists(fullPath.getParent())) {
                Files.createDirectories(fullPath.getParent());
            }
            Files.createFile(fullPath);
        }
    }

    private static void printFilesAndDirs(Path dir) throws IOException {
        Files.list(dir)
                .forEach(entry -> {
                    if (Files.isDirectory(entry)) {
                        System.out.println("D: " + entry.getFileName());
                        try {
                            printFilesAndDirs(entry); // recursive call for directories
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("F: " + entry.getFileName());
                    }
                });
    }


    private static void deleteDirectory(Path dir) throws IOException {
        try (Stream<Path> walkStream = Files.walk(dir)) {
            walkStream.sorted(Comparator.reverseOrder()) // Delete subdirectories first
                    .filter(file -> !file.equals(dir))
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            // Handle individual deletion failures (e.g., permission issues)
                            System.err.println("Error deleting file: " + file + " - " + e.getMessage());
                        }
                    });
            Files.delete(dir);
        }
    }


}
