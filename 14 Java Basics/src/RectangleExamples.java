public class RectangleExamples {

    public static void main (String[] args) {
        Rectangle smallRect = new Rectangle(5, 4);
        System.out.println(smallRect);
        System.out.println("Area: " + smallRect.area());

        Rectangle bigRect = new Rectangle(100, 80);
        System.out.println(bigRect);
        System.out.println("Area: " + bigRect.area());

        bigRect.setWidth(bigRect.getWidth() * 2);
        bigRect.setHeight(bigRect.getHeight() * 2);

        System.out.println(bigRect);
        System.out.println("Area: " + bigRect.area());
    }
}

