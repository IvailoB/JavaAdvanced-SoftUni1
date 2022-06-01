package STREAM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Resources - STREAMEXE/input.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null){
                long sum = 0;
                char[] charactersFromLines = line.toCharArray();
                for (char singleChar : charactersFromLines) {
                    sum += singleChar;
                }
                System.out.println(sum);

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
