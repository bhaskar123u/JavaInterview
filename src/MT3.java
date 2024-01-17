// Class Level lock vs Object Level lock
public class MT3 {
    public static void main(String[] args) {
        Hello obj1 = new Hello();
        Hello obj2 = new Hello();
        // these obj will be shared resources
        Thread t1 = new Thread(new TaskA(obj2));
        Thread t2 = new Thread(new TaskA(obj1));
        Thread t3 = new Thread(new TaskA(obj1));
        Thread t4 = new Thread(new TaskA(obj2));
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class TaskA implements Runnable{
    Hello obj;
    TaskA(Hello obj){
        this.obj = obj;
    }
    @Override
    public void run() {
        try {
            obj.sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Hello{
    void sayHello() throws InterruptedException{
        // Class level lock
        /*synchronized(Hello.class){
            System.out.println("In sayHello() with  thread : " + Thread.currentThread().getName());
            for(int i=0; i<2; i++){
                System.out.println("thread : " + Thread.currentThread().getName() + " i : " + i);
                Thread.sleep(500);
            }
        }*/
        // Object level lock
        synchronized(this){
            System.out.println("In sayHello() with  thread : " + Thread.currentThread().getName());
            for(int i=0; i<2; i++){
                System.out.println("thread : " + Thread.currentThread().getName() + " i : " + i);
                Thread.sleep(500);
            }
        }
    }
}
/*
 * We can see here that the same class is accessed by 2 threads at a time, this is because the lock is object based
 * If this would have been a static synchronized function/synchronized(Hello.class) the lock would be on whole class resulting in 1 thread access at a time
 */

// output
/*
 * In sayHello() with thread : t3
 * In sayHello() with thread : t1
 * thread : t3 i : 0
 * thread : t1 i : 0
 * thread : t3 i : 1
 * thread : t1 i : 1
 * In sayHello() with thread : t2
 * thread : t2 i : 0
 * In sayHello() with thread : t4
 * thread : t4 i : 0
 * thread : t2 i : 1
 * thread : t4 i : 1
 */
