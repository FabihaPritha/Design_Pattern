//........Adapter Pattern.........
//Purpose: Convert one interface into another the client expects.

//Use Case:
// When two incompatible interfaces need to work together.
//Real-life Example:

//adding a new payment system without changing the old ones.

package patterns.Structural_Design_Pattern;
// Existing interface
interface PayPalPayment {
    void makePayment();
}

// Existing implementation
class PayPalPaymentService implements PayPalPayment {
    public void makePayment() {
        System.out.println("Payment made using PayPal");
    }
}

// New incompatible interface (Stripe)
interface StripePayment {
    void stripePayment();
}

// New implementation (Stripe)
class StripePaymentService implements StripePayment {
    public void stripePayment() {
        System.out.println("Payment made using Stripe");
    }
}

// Adapter class to convert StripePayment to PayPalPayment
class StripeAdapter implements PayPalPayment {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {

        this.stripePayment = stripePayment;
    }

    public void makePayment() {
        stripePayment.stripePayment();  // Delegates to Stripe's payment method
    }
}

// Client code
public class Adapter {
    public static void main(String[] args) {
        PayPalPayment paypal = new PayPalPaymentService();
        paypal.makePayment();  // Output: Payment made using PayPal

        PayPalPayment stripeAdapter = new StripeAdapter(new StripePaymentService());
        stripeAdapter.makePayment();  // Output: Payment made using Stripe (adapted)
    }
}
