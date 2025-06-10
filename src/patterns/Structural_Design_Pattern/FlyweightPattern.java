//......Flyweight Pattern.......
//Purpose: Use shared objects to save memory when many similar objects are used.

// Use Case:
// When many objects share the same state (e.g., game characters, text editors).

// Real-World Analogy:
//Instead of giving 1000 students 1000 books with the same content, you give them one
// shared book and let them sit at different desks (x, y).

package patterns.Structural_Design_Pattern;

import java.util.*;

class Shape {
    private String color;
    public Shape(String color) {
        this.color = color;  //color is shared
    }
    public void draw(int x, int y) {
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ")");
        //not shared
    }
}

//Flyweight Factory
//Ensures that only one Shape per color exists.
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        if (!circleMap.containsKey(color)) {
            circleMap.put(color, new Shape(color));
        }
        return circleMap.get(color);
    }
}

// Usage
public class FlyweightPattern {
    public static void main(String[] args) {
        Shape red = ShapeFactory.getCircle("Red");
        red.draw(10, 20);

        Shape red2 = ShapeFactory.getCircle("Red");
        red2.draw(30, 40); // same object reused
    }
}

