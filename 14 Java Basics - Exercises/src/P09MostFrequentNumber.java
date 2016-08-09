import java.util.*;

public class P09MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sequence = Arrays.stream(
                        scan.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int number : sequence) {
            if (!counts.containsKey(number))
                counts.put(number, 0);
            counts.put(number, counts.get(number) + 1);
        }
        int maxCount = 1;
        int bestKey = sequence[0];
        for (int number : sequence) {
            if (maxCount < counts.get(number)) {
                maxCount = counts.get(number);
                bestKey = number;
            }
        }
        System.out.println(bestKey);
    }
}