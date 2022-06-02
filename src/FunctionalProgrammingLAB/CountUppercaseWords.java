package FunctionalProgrammingLAB;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startWithUppercase = w -> Character.isUpperCase(w.charAt(0));

        List<String> uppercasesWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startWithUppercase)
                .collect(Collectors.toList());
        System.out.println(uppercasesWords.size());
        System.out.println(String.join(System.lineSeparator(), uppercasesWords));
    }
}
