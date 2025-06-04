package patterns.Behavioral_Design_Pattern;
// Template class
abstract class DataExporter {
    // Template method
    public final void exportData() {
        readData();
        formatData();
        saveData();
    }

    protected abstract void formatData();  // Step to be implemented by subclasses

    private void readData() {
        System.out.println("Reading data from database");
    }

    private void saveData() {
        System.out.println("Saving data to file");
    }
}

// Concrete implementations
class CSVDataExporter extends DataExporter {
    protected void formatData() {
        System.out.println("Formatting data as CSV");
    }
}

class XMLDataExporter extends DataExporter {
    protected void formatData() {
        System.out.println("Formatting data as XML");
    }
}

// Client code
public class Template {
    public static void main(String[] args) {
        DataExporter csvExporter = new CSVDataExporter();
        csvExporter.exportData();
        // Output: Reading data from database, Formatting data as CSV, Saving data to file

        DataExporter xmlExporter = new XMLDataExporter();
        xmlExporter.exportData();
    }}
        // Output: Reading data from database, Formatting


