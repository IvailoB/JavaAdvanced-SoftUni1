package STREAM;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Resources - STREAMEXE/output.txt"))){
            Path path = Paths.get("Resources - STREAMEXE/inputLineNumbers.txt");
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                pw.println((i+1) + ". " + lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
