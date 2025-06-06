//........Strategy Pattern.........
//Define a family of algorithms, encapsulate them, and make them interchangeable.
//
//Use Case:
//Payment strategies (PayPal, CreditCard)
//Sorting algorithms
//Compression formats
//
//Real Life Example:
//Google Maps lets you pick fastest route, shortest route, or scenic — strategy changes, result changes.



package patterns.Behavioral_Design_Pattern;

import java.util.Scanner;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPament implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class GooglePayPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code
public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);  // Output: Paid 100 using Credit Card.

        cart.setPaymentStrategy(new PayPalPament());
        cart.checkout(200);  // Output: Paid 200 using PayPal.
    }
}


