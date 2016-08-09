import java.util.Scanner;

public class P04VowelOrDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String vowels = "aeiou";
        char symbol = scan.nextLine().charAt(0);
        if (Character.isDigit(symbol))
            System.out.println("digit");
        else if (vowels.contains(Character.toString(symbol)))
            System.out.println("vowel");
        else System.out.println("other");
    }
}