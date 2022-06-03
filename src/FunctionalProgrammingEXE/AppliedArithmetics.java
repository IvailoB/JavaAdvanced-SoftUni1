package FunctionalProgrammingEXE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunc = numberList -> numberList.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numberList -> numberList.stream().map(el -> el - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numberList -> numberList.stream().map(el -> el * 2).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = addFunc.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(number -> System.out.printf("%d ", number));
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();

        }


    }
}
