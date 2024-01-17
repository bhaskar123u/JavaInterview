public class MT5 {
    public static void main(String[] args) {
        TaskBeta obj = new TaskBeta();
        Thread t1 = new Thread(obj);
        // Q) What happens when we directly call run() ?
        // Q) Which method is called internally when we call start? - private native void start0();
        t1.run(); // Thread main is invoking run()
        t1.start(); // Thread Thread-0 is invoking run()
    }
}
class TaskBeta implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() +" is invoking run()");
    }
}
// demonstrating lock

// class Number{
//     private AtomicInteger counter = new AtomicInteger(0);
//     public void increment() { 
//         counter.incrementAndGet(); 
//     }
//     public int getCount() { 
//         return counter.get();
//     }
// }

// output
// Thread main is invoking run()
// Thread Thread-0 is invoking run()