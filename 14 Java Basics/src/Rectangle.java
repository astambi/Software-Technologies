public class Rectangle implements IRectangle {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long area() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Rect[width=%d, height=%d]",
                this.width, this.height);
    }
}