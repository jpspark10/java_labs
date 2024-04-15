package FourthTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void wordCount() {
        System.out.println("\n---Fourth Task---\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст на английском языке:");
        String text = scanner.nextLine();

        String[] words = text.split("\\W+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

