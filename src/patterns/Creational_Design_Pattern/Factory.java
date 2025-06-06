//.......Factory Method Pattern.......
//Purpose: Create objects without exposing class names, using a factory method.
//Real-life Example:
//1. a vehicle, don't care if its bike oe car.
//2. You order a notification, but don't care if it's SMS or Email.


package patterns.Creational_Design_Pattern;
// Vehicle interface
interface Vehicle {
    void drive();
}

// Car class
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

// Bike class
class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

// Factory class
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return null;
    }
}

// Usage
public class Factory {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car");
        car.drive();  // Outputs: Driving a car

        Vehicle bike = VehicleFactory.getVehicle("Bike");
        bike.drive();  // Outputs: Riding a bike
    }
}

