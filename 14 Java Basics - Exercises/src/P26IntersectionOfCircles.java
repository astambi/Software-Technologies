import java.util.*;

public class P26IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions1 = Arrays.stream(scan.nextLine().split("\\s"))
                            .mapToInt(Integer::parseInt).toArray();
        int[] dimensions2 = Arrays.stream(scan.nextLine().split("\\s"))
                            .mapToInt(Integer::parseInt).toArray();
        Circle circle1 = new Circle(dimensions1[0], dimensions1[1], dimensions1[2]);
        Circle circle2 = new Circle(dimensions2[0], dimensions2[1], dimensions2[2]);
        System.out.println(circlesIntersect(circle1, circle2) ? "Yes" : "No");
    }

    private static boolean circlesIntersect(Circle c1, Circle c2) {
        double deltaX = c1.getX() - c2.getX();
        double deltaY = c1.getY() - c2.getY();
        double distanceCircleCenters = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return distanceCircleCenters <= c1.getRadius() + c2.getRadius();
    }


//    use to submit in Judge

}
