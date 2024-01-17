import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class WithoutThreadLocalDemo {
    private static Integer count = Integer.valueOf(0);
    public static void main(String[] args) {
        Runnable increment = () -> {
            count = count + 1;
            System.out.println("Incrementing value by 1");
            System.out.println(Thread.currentThread().getName() + " has count as " + count);
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

// output
/*
 * Incrementing value by 1
 * Incrementing value by 1
 * Incrementing value by 1
 * Incrementing value by 1
 * Incrementing value by 1
 * pool-1-thread-4 has count as 5
 * pool-1-thread-1 has count as 5
 * pool-1-thread-3 has count as 5
 * pool-1-thread-5 has count as 5
 * pool-1-thread-2 has count as 5
 */