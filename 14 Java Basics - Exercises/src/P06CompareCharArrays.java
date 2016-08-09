import java.util.Scanner;

public class P06CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrayShort = scan.nextLine().split("\\s");
        String[] arrayLong = scan.nextLine().split("\\s");

        if (arrayShort.length > arrayLong.length) {
            String[] arrayTemp = arrayShort;
            arrayShort = arrayLong;
            arrayLong = arrayTemp;
        }
        else if (arrayLong.length == arrayShort.length) {
            for (int i = 0; i < arrayShort.length; i++) {
                if (arrayShort[i].charAt(0) > arrayLong[i].charAt(0)) {
                    String[] arrayTemp = arrayShort;
                    arrayShort = arrayLong;
                    arrayLong = arrayTemp;
                    break;
                }
            }
        }
        printArray(arrayShort);
        printArray(arrayLong);
    }

    public static void printArray(String[] array) {
        for (String element : array)
            System.out.print(element);
        System.out.println();
    }
}