import java.util.*;

public class P21ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        // replace "<upcase>Software University</upcase>"
        // with "SOFTWARE UNIVERSITY"
        while (text.contains("<upcase>")) {
            int indexStart = text.indexOf("<upcase>");
            int indexEnd = text.indexOf("</upcase>") + "</upcase>".length();
            String textToReplace = text.substring(indexStart, indexEnd);
            String textToUpper = textToReplace
                    .substring("<upcase>".length(), textToReplace.length() - "</upcase>".length())
                    .toUpperCase();
            text = text.replace(textToReplace, textToUpper);
        }
        System.out.println(text);
    }
}