package patterns;

class ConfigurationManager {
    // Private static instance
    private static ConfigurationManager instance;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {
    }

    // Method to get the single instance of the class
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfiguration() {
        System.out.println("Loading configuration...");
    }
}

// Usage
public class SingleTone {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        config1.loadConfiguration();  // Outputs: Loading configuration...

        System.out.println(config1 == config2);  // Outputs: true
    }
}

