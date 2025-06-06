//.....Mediator Pattern.........
//Centralize communication between objects to reduce coupling.
//Decouples objects → easier to manage, maintain, and extend.

//Use Case:
//Chat apps
//GUI components (e.g. textbox, button, etc.)
//Air Traffic Control systems

//Real Life Example:
//Air Traffic Control (mediator) tells each plane when it’s safe to land or take off.

package patterns.Behavioral_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void send(String message, Colleague sender);
}

abstract class Colleague {
    Mediator mediator;
    Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    abstract void receive(String message);
}

class ConcreteColleague extends Colleague {
    String name;
    ConcreteColleague(Mediator m, String name) {
        super(m);
        this.name = name;
    }

    void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.send(message, this);
    }

    void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}

class ChatMediator implements Mediator {
    List<Colleague> users = new ArrayList<>();
    void addUser(Colleague user) {
        users.add(user);
    }

    public void send(String message, Colleague sender) {
        for (Colleague user : users) {
            if (user != sender)
                user.receive(message);
        }
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        ConcreteColleague user1 = new ConcreteColleague(mediator, "Alice");
        ConcreteColleague user2 = new ConcreteColleague(mediator, "Bob");

        mediator.addUser(user1);
        mediator.addUser(user2);

        user1.send("Hi Bob!");
    }
}

