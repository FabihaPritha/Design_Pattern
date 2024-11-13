package patterns;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileComponent {
    void open();
}

// Leaf (File)
class File implements FileComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Opening file: " + name);
    }
}

// Composite (Directory)
class Directory implements FileComponent {
    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void open() {
        System.out.println("Opening directory: " + name);
        for (FileComponent child : children) {
            child.open();  // Delegates to children
        }
    }
}

// Client code
public class Composite {
    public static void main(String[] args) {
        FileComponent file1 = new File("File1.txt");
        FileComponent file2 = new File("File2.txt");

        Directory directory = new Directory("Documents");
        directory.add(file1);
        directory.add(file2);

        directory.open();  // Output: Opening directory: Documents, Opening file: File1.txt, Opening file: File2.txt
    }
}

