import java.util.*;

public class P142By2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(
                            scan.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        String[][] matrix = new String [dimensions[0]][];
        for (int row = 0; row < matrix.length; row++)
            matrix[row] = scan.nextLine().split(" ");
        int countSquares = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                String element = matrix[row][col];
                boolean isSquare = element.equals(matrix[row][col + 1]) &&
                                   element.equals(matrix[row + 1][col]) &&
                                   element.equals(matrix[row + 1][col + 1]);
                if (isSquare) countSquares++;
            }
        }
        System.out.println(countSquares);
    }
}