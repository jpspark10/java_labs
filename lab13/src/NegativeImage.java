import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NegativeImage {
    public static void createNegative(String inputFilePath, String outputFilePath) throws IOException {
        byte[] imageData = Files.readAllBytes(Paths.get(inputFilePath));


        for (int i = 54; i < imageData.length; i++) {
            imageData[i] = (byte) (255 - (imageData[i] & 0xFF));
        }


        Files.write(Paths.get(outputFilePath), imageData);
    }

    public static void main(String[] args) throws IOException {
        createNegative("resources/input.bmp", "resources/output.bmp");
    }
}
