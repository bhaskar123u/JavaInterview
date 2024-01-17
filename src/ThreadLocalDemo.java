import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadLocalDemo {
    // declaring a thread local variable
    private static final ThreadLocal<Integer> count = new ThreadLocal<>() {
        @Override
        public Integer initialValue() {
        return Integer.valueOf(0);
        }
    };
    public static void main(String[] args) {
        // defining runnable task
        Runnable increment = () -> {
            count.set(count.get().intValue() + 1);
            System.out.println("Incrementing value by 1");
            System.out.println(Thread.currentThread().getName() + " has count as " + count.get());
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(increment);
        executor.execute(increment);
        executor.execute(increment);
        executor.execute(increment);
        executor.execute(increment);
        executor.shutdown();
    }
}
