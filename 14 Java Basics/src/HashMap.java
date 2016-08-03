import java.util.*;

public class HashMap {

    public static void main(String[] args) {

        String[] words = { "yes", "hi", "hello", "hi", "welcome", "yes", "yes", "welcome", "hi", "yes", "hello", "yes" };
        java.util.HashMap<String, Integer> wordsCount = new java.util.HashMap<String, Integer>();
        for (String word : words) {
            Integer count = wordsCount.get(word);
            if (count == null) {
                count = 0;
            }
            wordsCount.put(word, count+1);
        }
        System.out.println(wordsCount); // {hi=3, yes=5, hello=2, welcome=2}
    }
}
