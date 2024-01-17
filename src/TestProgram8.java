public class TestProgram8 {
    public static void main(String[] args) {
        TestProgram8 obj = new TestProgram8();
        obj.start();
        Mobile mobile = new Mobile("1+", 2000);
        obj.method(mobile);
        System.out.println(mobile);
    }
    void start() {
        long[] P = { 3, 4, 5 };
        long[] Q = method(P);
        method(P);
        System.out.print(P[0] + P[1] + P[2] + ":");
        System.out.println(Q[0] + Q[1] + Q[2]);
    }
    long[] method(long[] R) {
        R[1] = 7;
        return R;
    }
    void method(Mobile m){
        m.setPrice(m.getPrice() + 1000);
    }
}
class Mobile{
    private String name;
    private int price;
    public Mobile(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Mobile [name=" + name + ", price=" + price + "]";
    }
}

// output
/*
 * 15:15
 * Mobile [name=1+, price=3000]
 */