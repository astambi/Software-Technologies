import java.util.*;

public class P15MaxPlatform3x3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int [dimensions[0]][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
        }
        Long maxSum = Long.MIN_VALUE;
        int maxPlatformR = 0;   int maxPlatformC = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                Long sum = 0L;
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++)
                        sum += matrix[r][c];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    maxPlatformR = row; maxPlatformC = col;
                }
            }
        }
        System.out.println(maxSum);
        for (int r = maxPlatformR; r < maxPlatformR + 3; r++) {
            for (int c = maxPlatformC; c < maxPlatformC + 3; c++)
                System.out.print(matrix[r][c] + " ");
            System.out.println();
        }
    }
}