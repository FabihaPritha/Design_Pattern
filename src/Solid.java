// Single Responsibility: Order class only handles order details
class Order {
    private String product;
    private int quantity;
    private double price;

    public Order(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotal() {
        return quantity * price;
    }
}

// Interface for saving orders
interface OrderPersistence {
    void saveOrder(Order order);
}

// Class that saves orders to a database
class OrderRepository implements OrderPersistence {
    @Override
    public void saveOrder(Order order) {
        System.out.println("Saving order to database...");
    }
}

// Interface for sending notifications
interface Notification {
    void sendNotification(Order order);
}

// Class that sends email notifications
class EmailNotification implements Notification {
    @Override
    public void sendNotification(Order order) {
        System.out.println("Sending confirmation email...");
    }
}

// Class that sends SMS notifications
class SMSNotification implements Notification {
    @Override
    public void sendNotification(Order order) {
        System.out.println("Sending confirmation SMS...");
    }
}

// High-level class that processes orders
class OrderProcessor {
    private OrderPersistence orderPersistence;
    private Notification notification;

    public OrderProcessor(OrderPersistence orderPersistence, Notification notification) {
        this.orderPersistence = orderPersistence;
        this.notification = notification;
    }

    public void processOrder(Order order) {
        orderPersistence.saveOrder(order);
        notification.sendNotification(order);
    }
}

// Using the system
public class Solid {
    public static void main(String[] args) {
        Order order = new Order("Laptop", 1, 1500.00);

        OrderPersistence orderPersistence = new OrderRepository();
        Notification notification = new EmailNotification();

        OrderProcessor orderProcessor = new OrderProcessor(orderPersistence, notification);
        orderProcessor.processOrder(order);
    }
}

