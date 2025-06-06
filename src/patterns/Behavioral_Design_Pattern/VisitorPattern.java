//..........Visitor Pattern............
//Add new operations to objects without changing their class.
//
//Use Case:
//Compiler parse trees
//Object structure traversal
//Syntax checkers
//
//Real Life Example:
//A tax officer (visitor) visits different businesses (elements) and calculates tax differently for each.

package patterns.Behavioral_Design_Pattern;


interface Visitor {
    void visit(Book book);
    void visit(Pen pen);
}

interface Item {
    void accept(Visitor visitor);
}

class Book implements Item {
    int price = 50;
    public void accept(Visitor visitor) { visitor.visit(this); }
}

class Pen implements Item {
    int price = 10;
    public void accept(Visitor visitor) { visitor.visit(this); }
}

class PriceVisitor implements Visitor {
    public void visit(Book book) {
        System.out.println("Book price: " + book.price);
    }

    public void visit(Pen pen) {
        System.out.println("Pen price: " + pen.price);
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Item book = new Book();
        Item pen = new Pen();
        Visitor visitor = new PriceVisitor();

        book.accept(visitor);
        pen.accept(visitor);
    }
}
