import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class RandomLine {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/lines.txt"));
        if (!lines.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(lines.size());
            System.out.println(lines.get(randomIndex));
        }
    }
}

