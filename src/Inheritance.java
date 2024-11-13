//1. for code reusability
//2. for method overriding
//    {
//        1. code reuse
//        2. One interface, multiple implement
//        3. Run time polymorphism
//        }
//3. to implement parent-child relationship.

class People {
    int age;
    String name;
    private int phn;

    public int getPhn() {
        return phn;
    }

    public void setPhn(int phn) {
        this.phn = phn;
    }

    void dis() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(getPhn());
    }
}

class Teacher extends People {
    String qua;

    void display() {
        dis();
        System.out.println(qua);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.name = "Nazia";
        t1.age = 34;
        t1.qua = "MSc";
        t1.setPhn(12);
        t1.display();
    }
}
