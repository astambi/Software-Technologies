import java.util.Scanner;

public class P03ReverseCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] letters = new char[3];
        for (int i = 0; i < 3; i++)
            letters[i] = scan.nextLine().charAt(0);
        for (int i = letters.length - 1; i >= 0; i--)
            System.out.print(letters[i]);
    }
}