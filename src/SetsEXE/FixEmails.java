package SetsEXE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        LinkedHashMap<String, String> mails = new LinkedHashMap();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains("uk") && !email.contains(".com")) {
                mails.put(name, email);
            }
            name = scanner.nextLine();
        }
        for (var e : mails.entrySet()) {
            System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
        }
    }
}
