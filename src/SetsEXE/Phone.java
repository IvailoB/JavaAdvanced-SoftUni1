package SetsEXE;

import java.util.HashMap;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] inputTokens = input.split("-");
            String name = inputTokens[0];
            String phoneNumber = inputTokens[1];
            phonebook.put(name, phoneNumber);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }

            input = scanner.nextLine();
        }


    }
}
