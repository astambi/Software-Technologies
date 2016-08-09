import java.util.*;

public class P12MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + (char)('a' + row) +
                                        (char)('a' + row + col) +
                                        (char)('a' + row);
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
    }
}