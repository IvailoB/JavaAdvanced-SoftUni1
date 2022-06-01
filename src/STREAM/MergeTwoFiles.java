package STREAM;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("Resources - STREAMEXE/inputOne.txt");
        Path path2 = Paths.get("Resources - STREAMEXE/inputTwo.txt");
        Path output = Paths.get("Resources - STREAMEXE/output.txt");

        try {
            List<String> firstInput = Files.readAllLines(path1);
            List<String> secondInput = Files.readAllLines(path2);
            Files.write(output, firstInput, StandardOpenOption.APPEND);
            Files.write(output, secondInput, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
