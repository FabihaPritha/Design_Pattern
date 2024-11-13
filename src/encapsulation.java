//1. provides data hiding
//2. Reusability
//3. code can be modified without breaking the code
//4. Maintainability: Hiding implementation details reduces complexity

class personal{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class encapsulation {
    public static void main(String[] args) {
        personal ob=new personal();
        ob.setAge(27);
        ob.setName("Nazia");
        System.out.println("She is "+ob.getName()+" and her age is "+ob.getAge());
    }
}
