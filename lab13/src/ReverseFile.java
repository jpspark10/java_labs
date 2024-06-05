import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseFile {
    public static void reverse() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("resources/input.dat"));
        byte[] reversedData = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            reversedData[i] = data[data.length - 1 - i];
        }

        Files.write(Paths.get("resources/output.dat"), reversedData);
    }

    public static void main(String[] args) throws IOException {
        reverse();
    }
}
