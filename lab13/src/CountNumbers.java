import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountNumbers {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("resources/input.txt")));
        List<String> tokens = Arrays.asList(content.split("\\s+"));

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                if (number > 0) {
                    positiveCount++;
                } else if (number < 0) {
                    negativeCount++;
                } else {
                    zeroCount++;
                }
            }
        }

        int totalCount = positiveCount + negativeCount + zeroCount;
        StringBuilder output = new StringBuilder();
        output.append(totalCount).append("\n");

        if (positiveCount > 0) {
            output.append("1 ").append(positiveCount).append(" ");
        }
        if (negativeCount > 0) {
            output.append("-1 ").append(negativeCount).append(" ");
        }
        if (zeroCount > 0) {
            output.append("0 ").append(zeroCount).append(" ");
        }

        Files.write(Paths.get("resources/output.txt"), output.toString().trim().getBytes());
    }
}
