public class MT1 {
    public static void main(String[] args) {
        System.out.println("Creating thread using Thread class");
        for (int i = 0; i < 5; i++) {
            Demo obj = new Demo();
            obj.setName("thread " + i);
            obj.start();
        }
        System.out.println("Creating thread using Runnable interface");
        for (int i = 0; i < 5; i++) {
            Thread obj = new Thread(new Demo1());
            obj.setName("thread " + i);
            obj.start();
        }
        System.out.println("Creating thread using class which doesn't override run()");
        Thread obj1 = new Thread(new Demo2());
        obj1.start();
    }
}

class Demo extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
class Demo1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
class Demo2 extends Thread{
}
