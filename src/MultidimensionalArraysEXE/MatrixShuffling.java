package MultidimensionalArraysEXE;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col];
            }
        }

        while (true) {
            String[] commands = scanner.nextLine().split(" ");
            String start = commands[0];
            if (start.equals("END")) {
                break;
            }
            if (!start.equals("swap") || commands.length != 5) {
                System.out.println("Invalid input! ");
                continue;
            } else {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                if (row1 < 0 || row1 > matrix.length || col1 <0 || col1 > matrix.length
                || row2 < 0 || row2 > matrix.length || col2 <0 || col2 > matrix.length){
                    System.out.println("Invalid input!");
                    continue;
                }
                String temp = "";
                temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }

        }
    }
}
