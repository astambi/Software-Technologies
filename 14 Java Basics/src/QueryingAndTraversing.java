import java.util.*;

public class QueryingAndTraversing {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("peter ivanov");
        names.add("maria");
        names.add("ivan");
        names.add("svetlin nakov");

        names.stream()
                .filter(n -> n.length() > 8)
                .forEach(System.out::println);

        Optional<String> first = names.stream()
                .findFirst();
        System.out.println(first.get());
    }
}
