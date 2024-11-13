package patterns;
// Subsystem classes
class TV {
    public void on() {
        System.out.println("TV is ON");
    }
    public void off() {
        System.out.println("TV is OFF");
    }
}

class Speakers {
    public void on() {
        System.out.println("Speakers are ON");
    }
    public void off() {
        System.out.println("Speakers are OFF");
    }
}

class BluRayPlayer {
    public void play() {
        System.out.println("Playing Blu-ray");
    }
    public void stop() {
        System.out.println("Stopping Blu-ray");
    }
}

// Facade class
class HomeTheaterFacade {
    private TV tv;
    private Speakers speakers;
    private BluRayPlayer bluRayPlayer;

    public HomeTheaterFacade(TV tv, Speakers speakers, BluRayPlayer bluRayPlayer) {
        this.tv = tv;
        this.speakers = speakers;
        this.bluRayPlayer = bluRayPlayer;
    }

    public void watchMovie() {
        tv.on();
        speakers.on();
        bluRayPlayer.play();
        System.out.println("Enjoy your movie!");
    }

    public void endMovie() {
        bluRayPlayer.stop();
        speakers.off();
        tv.off();
        System.out.println("Movie finished. Shutting down...");
    }
}

// Client code
public class Facade {
    public static void main(String[] args) {
        TV tv = new TV();
        Speakers speakers = new Speakers();
        BluRayPlayer bluRayPlayer = new BluRayPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, speakers, bluRayPlayer);

        homeTheater.watchMovie();  // Output: Turning on TV, Speakers, Playing movie
        homeTheater.endMovie();    // Output: Stopping movie, Turning off system
    }
}

