import java.util.*;

public class Examples {

    public static void main(String[] args) {
        String str = "Pesho       Kirov            Kirov";
        String[] words = str.split("\\s+"); // whitespace
        System.out.println(java.util.Arrays.toString(words));
        System.out.println(String.join(", ", words));

        int[] numsArray = {10, 20, 30};
        System.out.println(java.util.Arrays.toString(numsArray));

        Student[] students = new Student[2];
        students[0] = new Student("Peter", "Ivanov");
        students[1] = new Student("Maria", "Ivanova");
        System.out.println(java.util.Arrays.toString(students));

        ArrayList<Integer> numsList = new ArrayList<>();
        numsList.add(10);
        numsList.add(20);
        numsList.add(30);
        System.out.println(numsList);
        for (int num : numsList)
            System.out.println(num * 2);

        ArrayList<Integer> numsList2 = new ArrayList<Integer>() {{
            add(20);
            add(30);
        }};
        numsList2.remove(1);
        numsList2.set(0, 60);
        System.out.println(numsList2);

        ArrayList<Object> mixedArray = new ArrayList<Object>();
        mixedArray.add(10);
        mixedArray.add(20);
        mixedArray.add("baba Penka");
        System.out.println(mixedArray);

        String[][] matrix = {
                {"0,0", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"}
        };
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }

        Integer[] result = numsList.stream()
                .filter(p -> p < 100)
                .unordered()
                .toArray(Integer[]::new);

        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(5);
        set.add(115);
        set.add(5);
        System.out.println(set);
    }
}
