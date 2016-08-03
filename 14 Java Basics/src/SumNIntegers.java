import java.util.Scanner;

public class SumNIntegers {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        int n = Integer.parseInt(scan.nextLine());

        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += scan.nextInt();

        System.out.println("Sum = " + sum);
    }
}
