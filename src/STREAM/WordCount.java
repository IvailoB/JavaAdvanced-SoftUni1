package STREAM;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new FileReader("Resources - STREAMEXE/words.txt"));
             Scanner textScan = new Scanner(new FileReader("Resources - STREAMEXE/text.txt"));
             PrintWriter pw = new PrintWriter("Resources - STREAMEXE/results.txt")) {
            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split(" ")).forEach(word -> wordMap.put(word, 0));
            while (textScan.hasNext()) {
                String textInput = textScan.next();
                if (wordMap.containsKey(textInput)) {
                    int occurrences = wordMap.get(textInput);
                    occurrences++;
                    wordMap.put(textInput, occurrences);

                }
            }
            wordMap.entrySet().forEach(entry -> pw.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
