//.....Bridge Pattern.....
//Purpose: Separate abstraction from implementation so both can change independently.

//Use Case:
// When both abstraction and implementation can vary independently.

//Goal: To separate the high-level abstraction (like a remote control) from the low-level
// implementation (like a TV or Radio), so you can change either side without affecting the other.
//You can add new devices or new remotes without touching existing code.


package patterns.Structural_Design_Pattern;

// Implementation interface
interface Device {
    void turnOn();
}

class Television implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio is ON");
    }
}

// Abstraction (Acts as bridge)
abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    abstract void pressPowerButton();
}

//A refined version of the abstraction.
class BasicRemote extends Remote {
    public BasicRemote(Device device) {
        super(device);
    }

    public void pressPowerButton() {
        device.turnOn();
    }
}

// Usage
public class BridgePattern {
    public static void main(String[] args) {
        Device tv = new Television(); //create a Television
        Remote remote = new BasicRemote(tv); // Pass it to a Remote
        remote.pressPowerButton(); // Remote uses the bridge to turn it on
    }
}


