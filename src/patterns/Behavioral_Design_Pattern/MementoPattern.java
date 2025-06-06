//........Memento Pattern............
//Capture an object’s internal state without exposing it and restore later.
//
//Use Case:
//Undo/Redo
//Save game state

//Real Life Example:
//Ctrl+Z in Word. Restore the document's previous state.

package patterns.Behavioral_Design_Pattern;

class Memento {
    private String state;
    public Memento(String state) {
        this.state = state; }
    public String getState() { return state; }
}

class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
        System.out.println("State = " + state);
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento m) {
        state = m.getState();
        System.out.println("Restored to " + state);
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("State1");
        Memento m1 = o.save();

        o.setState("State2");
        o.restore(m1); // Back to State1
    }
}

