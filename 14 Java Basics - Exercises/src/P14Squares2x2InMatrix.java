import java.util.*;

public class P14Squares2x2InMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s"))
                            .mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String [dimensions[0]][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s");
        }
        int countSquares = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                String element = matrix[row][col];
                if (element.equals(matrix[row][col + 1]) &&
                    element.equals(matrix[row + 1][col]) &&
                    element.equals(matrix[row + 1][col + 1]))
                    countSquares++;
            }
        }
        System.out.println(countSquares);
    }
}