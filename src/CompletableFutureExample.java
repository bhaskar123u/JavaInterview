import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newCachedThreadPool();
        // Problems with future is .get( ) blocks the execution
        Future<String> res1 = es.submit(new TaskDelay());
        System.out.println(res1.get());
        Future<String> res2 = es.submit(new TaskNoDelay());
        System.out.println(res2.get());

        es.shutdown();
    }
}
class TaskDelay implements Callable<String>{
    @Override
    public String call() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : " + Thread.currentThread().getName() + " in TaskDelay call()");
        return "HelloAfter5Seconds";
    }
}
class TaskNoDelay implements Callable<String>{
    @Override
    public String call() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " in TaskNoDelay call()");
        return "InstantHello";
    }
}

// output after 3 sec

/*
 * Thread : pool-1-thread-1 in TaskDelay call()
 * HelloAfter5Seconds
 * Thread : pool-1-thread-1 in TaskNoDelay call()
 * InstantHello
 */