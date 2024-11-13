// Superclass
class Animal {
    String name = "Animal";

    // Constructor of the superclass
    Animal() {
        System.out.println("Animal constructor called");
    }

    // Method in superclass
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Dog extends Animal {
    String name = "Dog";

    // Constructor of the subclass
    Dog() {
        // Calling superclass constructor
        super();
        System.out.println("Dog constructor called");
    }

    // Overriding method
    @Override
    void sound() {
        // Calling superclass method
        super.sound();
        System.out.println("Dog barks");
    }

    // Method to demonstrate calling superclass instance variable
    void displayNames() {
        System.out.println("Superclass name: " + super.name);
        System.out.println("Subclass name: " + this.name);
    }
}

// Main class
public class superKeyWord2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Calls both superclass and subclass methods
        dog.displayNames(); // Calls superclass and subclass instance variables
    }
}
