import java.util.*;

public class P22Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("END"))
                break;
            String[] tokens = input.split("\\s");
            String command = tokens[0];
            String name = tokens[1];

            if (command.equals("A")) {
                String phone = tokens[2];
                phonebook.put(name, phone);
            } else if (command.equals("S")){
                if (phonebook.containsKey(name))
                    System.out.printf("%s -> %s\n", name, phonebook.get(name));
                else
                    System.out.printf("Contact %s does not exist.\n", name);
            }
        }
    }
}