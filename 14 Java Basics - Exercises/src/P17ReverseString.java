import java.util.*;

public class P17ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();
        for (int i = input.length - 1; i >= 0; i--)
            System.out.print(input[i]);
    }
}