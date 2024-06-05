import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Transliteration {
    private static final Map<Character, String> translitMap = new HashMap<>();
    static {
        translitMap.put('й', "j"); translitMap.put('ц', "c"); translitMap.put('у', "u");
        translitMap.put('к', "k"); translitMap.put('е', "e"); translitMap.put('н', "n");
        translitMap.put('г', "g"); translitMap.put('ш', "sh"); translitMap.put('щ', "shh");
        translitMap.put('з', "z"); translitMap.put('х', "h"); translitMap.put('ъ', "#");
        translitMap.put('ф', "f"); translitMap.put('ы', "y"); translitMap.put('в', "v");
        translitMap.put('а', "a"); translitMap.put('п', "p"); translitMap.put('р', "r");
        translitMap.put('о', "o"); translitMap.put('л', "l"); translitMap.put('д', "d");
        translitMap.put('ж', "zh"); translitMap.put('э', "je"); translitMap.put('я', "ya");
        translitMap.put('ч', "ch"); translitMap.put('с', "s"); translitMap.put('м', "m");
        translitMap.put('и', "i"); translitMap.put('т', "t"); translitMap.put('ь', "'");
        translitMap.put('б', "b"); translitMap.put('ю', "ju"); translitMap.put('ё', "jo");
    }

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("resources/cyrillic.txt")));
        StringBuilder result = new StringBuilder();

        for (char ch : content.toCharArray()) {
            if (translitMap.containsKey(Character.toLowerCase(ch))) {
                String replacement = translitMap.get(Character.toLowerCase(ch));
                if (Character.isUpperCase(ch)) {
                    replacement = Character.toUpperCase(replacement.charAt(0)) + replacement.substring(1);
                }
                result.append(replacement);
            } else {
                result.append(ch);
            }
        }

        Files.write(Paths.get("resources/transliteration.txt"), result.toString().getBytes());
    }
}

