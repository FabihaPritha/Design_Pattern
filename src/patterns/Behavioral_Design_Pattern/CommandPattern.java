//...Command Pattern.......
//Encapsulate a request as an object so you can parameterize clients, queue, and log requests.

//Use Case:
//Undo/redo systems
//Task queues
//GUI button actions

//Real Life Example:
//Think of a waiter taking your order (command) and passing it to the kitchen.
package patterns.Behavioral_Design_Pattern;
// Command interface
interface Command {
    void execute();
}

// Concrete Commands
class LightOnCommand implements Command {
    public void execute() {
        System.out.println("Light is ON");
    }
}

class TVOffCommand implements Command {
    public void execute() {
        System.out.println("TV is OFF");
    }
}

// Invoker
class SmartHome {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandPattern {
    public static void main(String[] args) {
        SmartHome smartHome = new SmartHome();

        // Issue commands
        smartHome.setCommand(new LightOnCommand());
        smartHome.pressButton();  // Output: Light is ON

        smartHome.setCommand(new TVOffCommand());
        smartHome.pressButton();  // Output: TV is OFF
    }
}


