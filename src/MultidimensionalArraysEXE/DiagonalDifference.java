package MultidimensionalArraysEXE;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(rowInput[col]);
            }
        }

        int mainDigSum = 0;
        for (int i = 0; i < n; i++) {
            mainDigSum += matrix[i][i];
        }
        int secondDigSum = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            secondDigSum += matrix[i][j];
        }

        int diff = Math.abs(mainDigSum-secondDigSum);
        System.out.println(diff);
    }
}
