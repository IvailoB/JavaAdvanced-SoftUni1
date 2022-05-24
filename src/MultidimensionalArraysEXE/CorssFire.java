package MultidimensionalArraysEXE;

import java.util.Arrays;
import java.util.Scanner;

public class CorssFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
        while (true) {
            String[] commandEnd = scanner.nextLine().split(" ");
            if (commandEnd[0].equals("Nuke it from orbit")) {
                break;
            }
            int indexOfRow = Integer.parseInt(commandEnd[0]);
            int indexOfCol = Integer.parseInt(commandEnd[1]);
            int radius = Integer.parseInt(commandEnd[2]);


            int[][] result = destroy(matrix, indexOfCol, indexOfRow, radius, rows, cols);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] destroy(int[][] matrix, int ofCol, int ofRow, int indexOfCol, int indexOfRow, int radius) {

        int[][] result = new int[ofRow][ofCol];
        int resultIndex = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == matrix[indexOfRow][indexOfCol]) {
                    System.arraycopy(matrix[row], 0, result[resultIndex], 0, matrix[row].length);
                }
            }
        }
        return result;

    }
}

