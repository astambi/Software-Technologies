import java.util.Scanner;

public class P05IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int intNumber = Integer.parseInt(scan.nextLine());

        String hexNumber = Integer.toHexString(intNumber);
        String binaryNumber = Integer.toBinaryString(intNumber);

        System.out.println(hexNumber.toUpperCase());
        System.out.println(binaryNumber);
    }
}