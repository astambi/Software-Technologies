public class Strings {

    public static void main(String[] args) {
        comparingStraings();
        stringExamples();
    }

    private static void stringExamples() {

        String str = "SoftUni";

        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            System.out.printf("str[%d] = %s\n", i, str.charAt(i));
        }

        System.out.println(str.indexOf("Uni")); // 4
        System.out.println(str.indexOf("uni")); // -1 (not found)
        System.out.println(str.substring(4, 7)); // Uni
        System.out.println(str.replace("Soft", "Hard")); // HardUni
        System.out.println(str.toLowerCase()); // softuni
        System.out.println(str.toUpperCase()); // SOFTUNI

        String firstName = "Steve";
        String lastName = "Jobs";
        int age = 56;
        System.out.println(
                firstName + " " +
                lastName + " (age: " + age + ")"); // Steve Jobs (age: 56)

        String allLangs = "C#, Java; HTML, CSS; PHP, SQL";
        String[] langs = allLangs.split("[, ;]+");
        for (String lang : langs) {
            System.out.println(lang);
        }
        System.out.println("Langs = " + String.join(", ", langs));
        System.out.println("  \n\n Software   University  ".trim());
    }

    private static void comparingStraings() {
        String s = "sho";
        if ("Pesho".equals("Pe" + s)) // NB!! "Pesho" == "Pe" + s does not work
            System.out.println("Здрасти, Пешо!");
    }
}
