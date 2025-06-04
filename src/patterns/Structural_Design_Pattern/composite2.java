package patterns.Structural_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Component
interface Graphic {
    void render();  // Common operation for all shapes and groups
    void move(int x, int y);
}

// Leaf (individual shape)
class Circl implements Graphic {
    private int x, y;

    public Circl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render() {
        System.out.println("Rendering Circle at (" + x + ", " + y + ")");
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        System.out.println("Moved Circle to (" + this.x + ", " + this.y + ")");
    }
}

// Another Leaf (individual shape)
class Rectangl implements Graphic {
    private int x, y;

    public Rectangl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render() {
        System.out.println("Rendering Rectangle at (" + x + ", " + y + ")");
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        System.out.println("Moved Rectangle to (" + this.x + ", " + this.y + ")");
    }
}

// Composite (group of shapes or other groups)
class Group implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

//    public void remove(Graphic graphic) {
//        children.remove(graphic);
//    }

    @Override
    public void render() {
        for (Graphic child : children) {
            child.render();
        }
    }

    @Override
    public void move(int x, int y) {
        for (Graphic child : children) {
            child.move(x, y);
        }
    }
}

// Client code
public class composite2 {
    public static void main(String[] args) {
        // Individual shapes
        Graphic circle1 = new Circl(5, 10);
        Graphic rectangle1 = new Rectangl(15, 20);

        // Group containing individual shapes
        Group group1 = new Group();
        group1.add(circle1);
        group1.add(rectangle1);

        // Another individual shape
        Graphic circle2 = new Circl(25, 30);

        // Another group containing the first group and another shape
        Group group2 = new Group();
        group2.add(group1);
        group2.add(circle2);

        // Render all shapes and groups
        group2.render();
        // Output:
        // Rendering Circle at (5, 10)
        // Rendering Rectangle at (15, 20)
        // Rendering Circle at (25, 30)


        // Move all shapes and groups
        group2.move(10, 10);
        // Output:
        // Moved Circle to (15, 20)
        // Moved Rectangle to (25, 30)
        // Moved Circle to (35, 40)
    }
}
