import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MT6 {
    public static void main(String[] args) {
        Number num = new Number();
        Tasklock task = new Tasklock(num);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for ( int i = 0 ; i < 3 ; i++ )
            executorService.submit( task );
        executorService.shutdown();
        try {
            executorService.awaitTermination( 1 , TimeUnit.MINUTES ); 
        } catch ( InterruptedException e ){ 
            throw new RuntimeException( e ); 
        }
        System.out.println(num.getCount());
    }
}

class Tasklock implements Runnable {
    Number num;
    ReentrantLock lock = new ReentrantLock();

    Tasklock(Number num) {
        this.num = num;
    }

    @Override
    public void run() {

        // lock.lock();
        for (int i = 0; i < 1000000; i++) {
            num.increment();
        }
        System.out.println("Value of count is: " + num.getCount() + ", and was incremented by thread "
                + Thread.currentThread().getName());
        // lock.unlock();

    }
}

class Number{
    int count;
    Number(){
        count = 0;
    }
    void increment(){
        count++;
    }
    int getCount(){
        return count;
    }
}

/*
Without lock
Value of count is: 2752048, and was incremented by thread pool-1-thread-2
Value of count is: 2752048, and was incremented by thread pool-1-thread-1
Value of count is: 2752048, and was incremented by thread pool-1-thread-3
2752048

With lock
Value of count is: 1000000, and was incremented by thread pool-1-thread-1
Value of count is: 2000000, and was incremented by thread pool-1-thread-2
Value of count is: 3000000, and was incremented by thread pool-1-thread-3
3000000 
 */