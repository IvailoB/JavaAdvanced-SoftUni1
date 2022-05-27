package SetsEXE;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> users = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            users.add(name);

        }

        users.forEach(System.out::println);


    }
}
