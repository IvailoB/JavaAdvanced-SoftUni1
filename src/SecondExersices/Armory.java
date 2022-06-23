package SecondExersices;

import java.util.Scanner;

public class Armory {
    private static int row = 0;
    private static int col = 0;
    private  static int mirrorRow = 0;
    private  static int mirrorCol = 0;
    private static int sum = 0;
    private static boolean mouseIsInField = true;
    private  static boolean isMirrorHit = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            armory[i] = line.toCharArray();

            if (line.contains("A")) {
                row = i;
                col = line.indexOf("A");
            }
            if (line.contains("M")) {
                mirrorRow = i;
                mirrorCol = line.indexOf("M");
            }
        }


        while (true) {
            String command = scanner.nextLine();


            if (command.equals("up")) {
                move(armory, -1, 0);
            } else if (command.equals("down")) {
                move(armory, 1, 0);
            } else if (command.equals("left")) {
                move(armory, 0, -1);
            } else if (command.equals("right")) {
                move(armory, 0, 1);
            }

            if (!mouseIsInField) {
                break;
            }
            if (sum >= 65){
                break;
            }

        }

        if (!mouseIsInField) {
            System.out.println("I do not need more swords!");
        }

        if (sum >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
            System.out.println("The king paid "+sum+" gold coins. ");


        print2dArray(armory);
    }

    private static void move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;



        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if (Character.isDigit(field[nextRow][nextCol])) {
            int sword = Integer.parseInt(String.valueOf(field[nextRow][nextCol]));
            sum+=sword;
        } else if (field[nextRow][nextCol] == 'M') {
            isMirrorHit = true;
            field[row][col] = '-';
            field[nextRow][nextCol] = '-';
            field[mirrorRow][mirrorCol] = 'A';
            row = mirrorRow;
            col = mirrorCol;
            return;
        }

        field[row][col] = '-';
        field[nextRow][nextCol] = 'A';
        row = nextRow;
        col = nextCol;


    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
