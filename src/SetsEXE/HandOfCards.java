package SetsEXE;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String[] commandTokens = command.split(": ");
            String name = commandTokens[0];
            String[] cards = commandTokens[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            for (String card : cards) {
                card = card.trim();
                players.get(name).add(card);

            }
            command = scanner.nextLine();
        }
        for (var player : players.entrySet()) {
            String playerName = player.getKey();
            int point = calculatePoints(player.getValue());
            System.out.printf("%s: %s%n",playerName, point);
        }
    }

    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            char cardType = card.charAt(card.length() - 1);
            int cardPoints = getPower(power) * getType(cardType);
            points += cardPoints;
        }
        return points;
    }

    private static int getPower(String power) {
        switch (power) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(power);


        }
    }

    private static int getType(char type) {
        switch (type) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }
}
