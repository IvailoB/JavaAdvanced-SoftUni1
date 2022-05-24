package MultidimensionalArraysEXE;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(", ");
        int n = Integer.parseInt(arr[0]);
        String pattern = arr[1];
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            patternA(n, matrix);
        } else if (pattern.equals("B")) {
            patternB(n, matrix);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int n, int[][] matrix) {
        int number = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        }
    }

    private static void patternA(int n, int[][] matrix) {
        int number = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = number;
                number++;
            }
        }
    }
}

