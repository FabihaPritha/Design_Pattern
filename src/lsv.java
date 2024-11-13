// Base class for shapes
class Rectangle {
    protected double width;
    protected double height;

    // Constructor
    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    // Method to calculate area
    public double area() {
        return width * height;
    }

    // Getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Setters
    public void setWidth(double w) {
        this.width = w;
    }

    public void setHeight(double h) {
        this.height = h;
    }
}

// Derived class for squares
class Square extends Rectangle {
    // Constructor for Square
    public Square(double size) {
        super(size, size);
    }

    // Overriding setWidth to ensure square dimensions remain consistent
    @Override
    public void setWidth(double w) {
        this.width = this.height = w;
    }

    // Similarly, override setHeight if needed
    @Override
    public void setHeight(double h) {
        this.width = this.height = h;
    }
}

// Main class to test the code
public class lsv {
    public static void main(String[] args) {
        // Create a rectangle
        Rectangle rect = new Rectangle(10, 5);
        System.out.println("Rectangle area: " + rect.area());

        // Create a square
        Square square = new Square(5);
        System.out.println("Square area: " + square.area());

        // Modify square dimensions using the setWidth method
        square.setWidth(6);
        System.out.println("New square area after setting width: " + square.area());
    }
}