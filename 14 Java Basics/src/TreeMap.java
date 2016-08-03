import java.util.*;

public class TreeMap {

    public static void main(String[] args) {

        java.util.HashMap<String, ArrayList<Integer>> grades = new java.util.HashMap<>();
        grades.put("Peter", new ArrayList<>(java.util.Arrays.asList(5)));
        grades.put("George", new ArrayList<>(java.util.Arrays.asList(5, 5, 6)));
        grades.put("Maria", new ArrayList<>(java.util.Arrays.asList(5, 4, 4)));
        grades.get("Peter").add(6);
        grades.get("George").add(6);

        for (String key : grades.keySet()) {
            System.out.println("" + key + " -> " + grades.get(key));
        }
    }
}
