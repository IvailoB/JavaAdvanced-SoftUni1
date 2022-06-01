package STREAM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Resources - STREAMEXE/input.txt"))) {

            String line = bufferedReader.readLine();
            long sum = 0;
            while (line != null) {
                char[] charactersFromLines = line.toCharArray();
                for (char singleChar : charactersFromLines) {
                    sum += singleChar;
                }

                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
