package MultidimensionalArraysEXE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotateAsString = scanner.nextLine().split("[()]")[1];

        List<String> wordsList = new ArrayList<>();
        String word = scanner.nextLine();
        int maxColumnLength = Integer.MIN_VALUE;

        while (!word.equals("END")) {
            int currentLength = word.length();

            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }
            wordsList.add(word);
            word = scanner.nextLine();
        }

        char[][] matrix = new char[wordsList.size()][maxColumnLength];
        int rows = wordsList.size();
        int cols = maxColumnLength;
        for (int row = 0; row < wordsList.size(); row++) {
            for (int col = 0; col < maxColumnLength; col++) {
                String currentWord = wordsList.get(row);
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        int angle = Integer.parseInt(rotateAsString);
        int angleOfRotation = angle % 360;

        printMatrix(matrix, rows, cols, angleOfRotation);


        System.out.println();
    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angleOfRotation) {
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows-1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >=0; row--) {
                    for (int col = cols - 1; col >=0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:

                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

        }
    }
}
