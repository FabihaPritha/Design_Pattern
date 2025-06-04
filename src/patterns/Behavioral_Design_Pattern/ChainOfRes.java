package patterns.Behavioral_Design_Pattern;
// Handler interface
abstract class SupportLevel {
    protected SupportLevel next;

    public void setNext(SupportLevel next) {
        this.next = next;
    }

    public abstract void handleRequest(String issue);
}

// Concrete Handlers
class Level1Support extends SupportLevel {
    public void handleRequest(String issue) {
        if (issue.equals("Simple Issue")) {
            System.out.println("Level 1 Support resolved the issue");
        } else if (next != null) {
            next.handleRequest(issue);
        }
    }
}

class Level2Support extends SupportLevel {
    public void handleRequest(String issue) {
        if (issue.equals("Intermediate Issue")) {
            System.out.println("Level 2 Support resolved the issue");
        } else if (next != null) {
            next.handleRequest(issue);
        }
    }
}

class Level3Support extends SupportLevel {
    public void handleRequest(String issue) {
        System.out.println("Level 3 Support resolved the issue");
    }
}

// Client code
public class ChainOfRes {
    public static void main(String[] args) {
        SupportLevel level1 = new Level1Support();
        SupportLevel level2 = new Level2Support();
        SupportLevel level3 = new Level3Support();

        // Set up the chain
        level1.setNext(level2);
        level2.setNext(level3);

        level1.handleRequest("Simple Issue");   // Output: Level 1 Support resolved the issue
        level1.handleRequest("Intermediate Issue");  // Output: Level 2 Support resolved the issue
        level1.handleRequest("Complex Issue");   // Output: Level 3 Support resolved the issue
    }
}

