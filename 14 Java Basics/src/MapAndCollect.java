import java.util.*;
import java.util.stream.*;

public class MapAndCollect{

    public static void main(String[] args) {
        List<String> numbers = java.util.Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> parsedNumbers = numbers.stream()
                .map(Integer::parseInt)
                .map(i -> 2*i)
                .collect(Collectors.toList());

        System.out.println(parsedNumbers);

        List<String> names = new ArrayList<>();
        names.add("peter");
        names.add("ivan");
        names.add("maria ivnova");
        names.add("Petar Ivanov");

        names.stream()
                .filter(n -> n.length() > 8)
                .forEach(System.out::println);

        Optional<String> first = names.stream().findFirst();
        System.out.println(first.get());
    }
}
