package FirstExersices;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<String> consonants = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .forEach(consonants::push);

        Map<String, String> map = new LinkedHashMap<>();

        map.put("pear", "");
        map.put("flour", "");
        map.put("pork", "");
        map.put("olive", "");


        while (!consonants.isEmpty()) {
            String vowelAsChar = vowels.pop();
            String consonantAsChar = consonants.pop();

            for (var e : map.entrySet()) {
                if (e.getKey().contains(vowelAsChar)) {
                    if (!vowels.contains(vowelAsChar)) {
                        vowels.add(vowelAsChar);
                    }
                    if (!e.getValue().contains(vowelAsChar)) {
                        map.put(e.getKey(), e.getValue() + vowelAsChar);
                    }
                }
                if (e.getKey().contains(consonantAsChar)) {
                    if (!e.getValue().contains(consonantAsChar)) {
                        map.put(e.getKey(), e.getValue() + consonantAsChar);
                    }
                }
            }
        }

        int counter = 0;
        List<String> completedWords = new ArrayList<>();

        for (var entry : map.entrySet()) {
            if (entry.getKey().length() == entry.getValue().length()) {
                counter++;
                completedWords.add(entry.getKey());
            }
        }

        System.out.println("Words found: " + counter);
        for (String word : completedWords) {
            System.out.println(word);
        }
    }
}
