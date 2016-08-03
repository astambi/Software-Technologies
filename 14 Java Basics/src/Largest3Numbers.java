import java.util.*;

public class Largest3Numbers {

    public static void main(String[] args) {
        int[] nums = java.util.Arrays.stream(
                    new Scanner(System.in)
                    .nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        java.util.Arrays.sort(nums);

        int count = Math.min(3, nums.length);

        for (int i = 0; i < count; i++)
            System.out.print(nums[nums.length - i - 1] + " ");
    }
}
