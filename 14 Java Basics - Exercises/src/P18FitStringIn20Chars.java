import java.util.*;

public class P18FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        if (text.length() > 20)
            text = text.substring(0, 20);
        else if (text.length() < 20)
            text = createString(text, 20);
        System.out.println(text);
    }

    private static String createString(String text, int len) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(text);
        for (int i = 0; i < len - text.length(); i++)
            sb.append('*');
        return sb.toString();
    }
}