//..........Facade Pattern.........
//Purpose: Simplify interaction with a complex system by providing a single interface.

//Use Case:
// When you want to hide system complexity from clients.
//
//Analogy: A restaurant waiter takes your order and handles the kitchen behind the scenes.


package patterns.Structural_Design_Pattern;
// Subsystem classes
class CPU {
    void start() { System.out.println("CPU started"); }
}

class Memory {
    void load() { System.out.println("Memory loaded"); }
}

class Disk {
    void read() { System.out.println("Disk read"); }
}

// Facade
class Computer {
    CPU cpu = new CPU();
    Memory mem = new Memory();
    Disk disk = new Disk();

    void startComputer() {
        cpu.start();
        mem.load();
        disk.read();
    }
}

// Usage
public class Facade {
    public static void main(String[] args) {
        Computer pc = new Computer();
        pc.startComputer();
    }
}
