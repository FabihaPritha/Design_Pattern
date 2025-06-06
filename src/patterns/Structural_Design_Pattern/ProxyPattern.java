//...Proxy Pattern...
//Purpose: Provide a placeholder to control access to the original object.

//Real-Life Analogy:
//ProxyInternet = Security Guard
//You (user) want to enter a building (site).
//-The guard checks your ID (site name), and either:
//---Lets you in (allowed site)
//---Stops you (banned site)


package patterns.Structural_Design_Pattern;

import java.util.List;

interface Internet {
    void connectTo(String site);
}

class RealInternet implements Internet {
    public void connectTo(String site) {
        System.out.println("Connecting to " + site);
    }
}

class ProxyInternet implements Internet {
    private RealInternet internet = new RealInternet();
    private static List<String> bannedSites = List.of("abc.com", "xyz.com");

    public void connectTo(String site) {
        if (bannedSites.contains(site)) {
            System.out.println("Access Denied to " + site);
        } else {
            internet.connectTo(site);
        }
    }
}

// Usage
public class ProxyPattern {
    public static void main(String[] args) {
        Internet net = new ProxyInternet();
        net.connectTo("google.com");
        net.connectTo("abc.com");
    }
}

