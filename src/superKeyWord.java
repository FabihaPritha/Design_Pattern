/*
* to refer immediate super class object.
1. to call super class instance variable.
2. to call super class method. (overridden method)
3. to call super class constructor.

** connection with super calss
*/
class vehicle{
    String colour;
    double weight;
    vehicle(String c, double w)
    {
        colour=c;
        weight=w;
    }
    void display(){
        System.out.println(colour);
        System.out.println(weight);
    }
}

class car extends vehicle{
    int price;
    car(String c, double w, int p){
        super(c,w);
        price=p;
    }

    void display(){
        super.display();
        System.out.println(price);
    }

}
public class superKeyWord {
    public static void main(String[] args) {
        car ob=new car("orange",45.00,34);
        ob.display();
    }
}
