import java.util.*;

public class P16BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sequence = Arrays.stream(scan.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
        int[] bombParams = Arrays.stream(scan.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
        int bombElement = bombParams[0];
        int bombStrength = bombParams[1];

        ArrayList<Integer> remainingSeq = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++)
            remainingSeq.add(sequence[i]);
        while (remainingSeq.indexOf(bombElement) != -1) {
            int bombIndex = remainingSeq.indexOf(bombElement);
            int bombRangeStart = Math.max(0, bombIndex - bombStrength);
            int bombRangeEnd = Math.min(bombIndex + bombStrength, remainingSeq.size() - 1);
            for (int j = bombRangeStart; j <= bombRangeEnd; j++)
                remainingSeq.remove(bombRangeStart); // remove range in java???
        }
        Long sum = 0L;
        for (int number: remainingSeq)
                sum += number;
        System.out.println(sum);
    }
}