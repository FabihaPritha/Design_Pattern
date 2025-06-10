//...Abstract Factory Pattern....
//Purpose: Create families of related objects without specifying their concrete classes.

// Use Case:
// When you need multiple factories for different product families.

//Real-life Example:
//You want a UI toolkit that can switch between Light Theme and Dark Theme.

package patterns.Creational_Design_Pattern;

// Interfaces for different types of vehicles
interface SUV {
    void build();
}

interface Sedan {
    void build();
}

// Toyota brand
class ToyotaSUV implements SUV {
    public void build() {
        System.out.println("Building Toyota SUV");
    }
}

class ToyotaSedan implements Sedan {
    public void build() {
        System.out.println("Building Toyota Sedan");
    }
}

// BMW brand
class BMWSUV implements SUV {
    public void build() {
        System.out.println("Building BMW SUV");
    }
}

class BMWSedan implements Sedan {
    public void build() {
        System.out.println("Building BMW Sedan");
    }
}

// Abstract Factory interface
interface CarFactory {
    SUV createSUV();
    Sedan createSedan();
}

// Toyota factory
class ToyotaFactory implements CarFactory {
    public SUV createSUV() {
        return new ToyotaSUV();
    }

    public Sedan createSedan() {
        return new ToyotaSedan();
    }
}

// BMW factory
class BMWFactory implements CarFactory {
    public SUV createSUV() {
        return new BMWSUV();
    }

    public Sedan createSedan() {
        return new BMWSedan();
    }
}

// Use the Abstract Factory
public class abstractFactoryMethod {
    public static void main(String[] args) {
        CarFactory toyotaFactory = new ToyotaFactory();
        SUV toyotaSUV = toyotaFactory.createSUV();
        toyotaSUV.build();  // Output: Building Toyota SUV

        CarFactory bmwFactory = new BMWFactory();
        Sedan bmwSedan = bmwFactory.createSedan();
        bmwSedan.build();  // Output: Building BMW Sedan
    }
}
