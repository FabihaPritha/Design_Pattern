//.....Decorator Pattern.........
//Purpose: Add behavior to an object without modifying its structure.

//Use Case:
// When subclassing isn’t flexible enough for adding responsibilities.

//Analogy: Putting extra toppings (cheese, olives) on a pizza


package patterns.Structural_Design_Pattern;
// Component
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double cost() {
        return 2.00;
    }
}

// Decorator class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double cost() {
        return super.cost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double cost() {
        return super.cost() + 0.30;
    }
}

// Client code
public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);  // Adding milk
        coffee = new SugarDecorator(coffee);  // Adding sugar

        System.out.println(coffee.getDescription() + " $" + coffee.cost());
        // Output: Simple Coffee, Milk, Sugar $2.80
    }
}


