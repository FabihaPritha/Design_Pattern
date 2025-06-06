//..........Observer Pattern.........
//Notify all dependents (observers) automatically when the state changes.
//
//Use Case:
//News subscribers
//Event listeners
//Stock price updates
//
//Analogy:
//You subscribe to a YouTube channel. When a new video drops, you get notified.

package patterns.Behavioral_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    String name;
    Subscriber(String name) { this.name = name; }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Channel {
    List<Observer> observers = new ArrayList<>();

    void subscribe(Observer o) { observers.add(o); }

    void notifyAllObservers(String msg) {
        for (Observer o : observers)
            o.update(msg);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Channel tech = new Channel();

        tech.subscribe(new Subscriber("Alice"));
        tech.subscribe(new Subscriber("Bob"));

        tech.notifyAllObservers("New video uploaded!");
    }
}

