package SetsAndMapsLAB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();

        String reservationSymbol = scanner.nextLine();

        while (!reservationSymbol.equals("PARTY")){

           guest.add(reservationSymbol);


            reservationSymbol = scanner.nextLine();
        }

        reservationSymbol = scanner.nextLine();
        while (!reservationSymbol.equals("END")){
            guest.remove(reservationSymbol);
            reservationSymbol = scanner.nextLine();

        }
        System.out.println(guest.size());
        System.out.println(String.join(System.lineSeparator(),guest));

    }
}
