package FirstExersices;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;
        while (!females.isEmpty() && !males.isEmpty()) {
            Integer male = males.peek();
            Integer female = females.pop();

            if (male <= 0) {
                males.pop();
                females.push(female);
                continue;
            }
            if (female <= 0) {
                female = females.pop();
                continue;
            }
            if (male % 25 == 0) {
                males.pop();
                male = males.pop();
            }
            if (female % 25 == 0) {
                female = females.pop();
            }
            if (male.equals(female)) {
                males.pop();
                matches++;
            } else {
                male = males.peek() - 2;
                males.pop();
                males.push(male);
            }

        }
        System.out.println("Matches: " + matches);

        String leftMales = males.isEmpty() ? "none" : males.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Males left: " + leftMales);

        String leftFemales = females.isEmpty() ? "none" : females.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Females left: " + leftFemales);

    }
}
