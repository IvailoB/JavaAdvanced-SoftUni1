package STREAM;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacters {
    public static void main(String[] args) {
        int vowels = 0;
        int consonants = 0;
        int punctuations = 0;

        try (FileReader fr = new FileReader("Resources - STREAMEXE/input.txt");
             PrintWriter pw = new PrintWriter("Resources - STREAMEXE/output.txt")) {
            int oneSymbol = (char) fr.read();
            while (oneSymbol >= 0) {
                char symbolAsChar = (char) oneSymbol;

                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuations++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    consonants++;
                }
                oneSymbol = fr.read();
            }
           pw.println("Vowels: " + vowels);
           pw.println("Consonants: " + consonants);
           pw.println("Punctuation: " + punctuations);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean isVowel(char characters) {
        return characters == 'a' || characters == 'o' || characters == 'u' || characters == 'e' || characters == 'i';
    }

    public static boolean isPunctuation(char characters) {
        return characters == '?' || characters == '!' || characters == '.' || characters == ',';
    }
}
