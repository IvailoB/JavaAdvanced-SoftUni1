package STREAM;

import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Resources - STREAMEXE/input.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter ("Resources - STREAMEXE/output.txt"))) {

            br.lines().forEach(line -> pw.println(line.toUpperCase()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}