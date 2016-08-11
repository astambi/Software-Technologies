import java.util.*;

public class P25AdvertisementMessage {
    public static void main(String[] args) {
        String[] phrases = {"Excellent product.",
                        "Such a great product.",
                        "I always use that product.",
                        "Best product of its category.",
                        "Exceptional product.",
                        "I can’t live without this product."};
        String[] events = {"Now I feel good.",
                        "I have succeeded with this product.",
                        "Makes miracles. I am happy of the results!",
                        "I cannot believe but now I feel awesome.",
                        "Try it yourself, I am very satisfied.",
                        "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena",
                            "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Scanner scan = new Scanner(System.in);
        int msgCount = Integer.parseInt(scan.nextLine());
        Random random = new Random();
        for (int i = 0; i < msgCount; i++) {
            String randomMsg = randomStr(phrases, random) + " "
                            + randomStr(events, random) + " "
                            + randomStr(authors, random) + " - "
                            + randomStr(cities, random);
            System.out.println(randomMsg);
        }
    }

    private static String randomStr(String[] sequence, Random random) {
        int index = random.nextInt(sequence.length);
        return sequence[index];
    }
}