import java.util.*;

public class FunctionalProgrammingLambda {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        java.util.Arrays.stream(nums)
                .forEach(e -> { System.out.println(e); });
// or
        java.util.Arrays.stream(nums)
                .forEach(System.out::println);

        for (int num : nums)
            System.out.println(num);
    }
}
