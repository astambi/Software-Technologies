import java.util.*;

public class Arrays {

    public static void main(String[] args) {

//        Array holding numbers
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(java.util.Arrays.toString(numbers));

//        Array holding strings
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(java.util.Arrays.toString(weekDays));

//        Array of mixed data (objects)
        Object[] mixedArr = {1, new Date(), "hello"};
        System.out.println(java.util.Arrays.toString(mixedArr));

//        Array of arrays of strings (matrix)
        String[][] matrix = {
                {"0,0", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"}};

        String[] capitals = {"Sofia", "Berlin", "London", "Paris", "Moscow"};
        capitals[0] = "SOFIA";
        capitals[4] = null;
        System.out.println(java.util.Arrays.toString(capitals));

        for (String capital : capitals)
            System.out.println(capital);
        for (int i = 0; i < capitals.length; i++)
            System.out.println(capitals[i]);
    }
}
