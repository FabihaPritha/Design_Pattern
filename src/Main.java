class add{
    void addNum(int ... num)
    {
        int sum=0;
        for (int x:num){
            sum=sum+x;
        }
        System.out.println(sum);
    }
}
public class Main {
    public static void main(String[] args) {

        add ob=new add();
        ob.addNum(10,40,60);
        ob.addNum(10,89,57,11,13);
    }
}