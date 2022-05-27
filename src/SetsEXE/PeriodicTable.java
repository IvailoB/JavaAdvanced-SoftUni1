package SetsEXE;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> table = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Collections.addAll(table, input);
        }
        for (String e : table) {
            System.out.print(e + " ");
        }
    }
}
