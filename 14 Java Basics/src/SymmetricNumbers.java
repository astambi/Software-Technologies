import java.util.Scanner;

public class SymmetricNumbers {
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            if(isSymmetric(Integer.toString(i)))         // "" + i
                System.out.print(i + " ");
        }
    }

    static boolean isSymmetric(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        return true;
    }
}
