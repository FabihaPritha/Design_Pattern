package patterns;
// State interface
interface TrafficLightState {
    void handle();
}

// Concrete States
class RedLight implements TrafficLightState {
    public void handle() {
        System.out.println("Red Light: Stop!");
    }
}

class GreenLight implements TrafficLightState {
    public void handle() {
        System.out.println("Green Light: Go!");
    }
}

class YellowLight implements TrafficLightState {
    public void handle() {
        System.out.println("Yellow Light: Slow Down!");
    }
}

// Context class
class TrafficLight {
    private TrafficLightState state;

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void handle() {
        state.handle();
    }
}

// Client code
public class State {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        light.setState(new RedLight());
        light.handle();  // Output: Red Light: Stop!

        light.setState(new GreenLight());
        light.handle();  // Output: Green Light: Go!

        light.setState(new YellowLight());
        light.handle();  // Output: Yellow Light: Slow Down!
    }
}

