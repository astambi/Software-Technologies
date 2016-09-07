import java.util.*;
import java.util.stream.*;

public class P27AverageGrades {
    public static void main(String[] args) {
        ArrayList<Student> studentGrades = getStudentGrades().stream()
                .filter(s -> s.getAverageGrade() >= 5)
                .collect(Collectors.toCollection(ArrayList<Student>::new));
        Collections.sort(studentGrades, Student.StuAvGradeComparator);
        Collections.sort(studentGrades, Student.StuNameComparator);
        printStudentGrades(studentGrades);
    }

    private static void printStudentGrades(ArrayList<Student> studentGrades) {
        for (Student student : studentGrades)
            System.out.printf("%s -> %.2f\n", student.name, student.averageGrade);
    }

    private static ArrayList<Student> getStudentGrades() {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        ArrayList<Student> studentGrades = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] studentData = scan.nextLine().split("\\s");
            ArrayList<Double> grades = new ArrayList<>();
            for (int j = 1; j < studentData.length; j++)
                grades.add(Double.parseDouble(studentData[j]));
            studentGrades.add(new Student(studentData[0], grades)); // name, grades
        }
        return studentGrades;
    }

    static class Student {
        private String name;
        private ArrayList<Double> grades;
        private double averageGrade;

        private Student(String name, ArrayList<Double> grades) {
            this.name = name;
            this.grades = grades;
            this.averageGrade = getAverageGrade();
        }

        private double getAverageGrade() {
            double sum = 0;
            for (double grade : grades)
                sum += grade;
            return sum / grades.size();
        }

        private static Comparator<Student> StuNameComparator = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);              // names ASC
            }
        };

        private static Comparator<Student> StuAvGradeComparator = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                double avGrade1 = s1.averageGrade;
                double avGrade2 = s2.averageGrade;
                return (int)(100 * avGrade2 - 100 * avGrade1);  // avGrade DESC
            }
        };
    }
}