//.....Prototype Pattern........
//Purpose: Create objects by cloning an existing object (useful when object creation is expensive).

//Use Case:
// When object creation is expensive or complex.

//Analogy:
//Prototyping the shape for drawing the circle and rectangle.

package patterns.Creational_Design_Pattern;

// Create a Shape interface
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Implement Shape classes
class Circle implements Shape {
    public Shape clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    public Shape clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Use the Prototype pattern
public class Prototype {
    public static void main(String[] args) {
        // Create original objects
        Circle originalCircle = new Circle();
        Rectangle originalRectangle = new Rectangle();

        // Clone the objects
        Shape clonedCircle = originalCircle.clone();
        Shape clonedRectangle = originalRectangle.clone();

        originalCircle.draw();  // Output: Drawing a circle
        clonedCircle.draw();    // Output: Drawing a circle

        originalRectangle.draw();  // Output: Drawing a rectangle
        clonedRectangle.draw();    // Output: Drawing a rectangle
    }
}

