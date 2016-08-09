import java.util.*;

public class P13DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(
                    scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        Long sumDiagPrimary = 0L;
        Long sumDiagSecondary = 0L;
        for (int i = 0; i < size; i++) {
            sumDiagPrimary += matrix[i][i];
            sumDiagSecondary += matrix[i][size - 1 - i];
        }
        System.out.println(Math.abs(sumDiagPrimary - sumDiagSecondary));
    }
}