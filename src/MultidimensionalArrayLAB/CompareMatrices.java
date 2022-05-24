package MultidimensionalArrayLAB;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstMatrixRows = size[0];
        int firstMatrixCols = size[1];
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        for (int row = 0; row < firstMatrixRows; row++) {
            size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[row] = size;
        }
        size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRows = size[0];
        int secondMatrixCols = size[1];
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];

        for (int row = 0; row < secondMatrixRows; row++) {
            size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[row] = size;
        }

        if (Arrays.deepEquals(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");

        }
    }
}
