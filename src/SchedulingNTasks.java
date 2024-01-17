import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class SchedulingNTasks {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> task1 = scheduledExecutor.scheduleAtFixedRate(new RepeatitiveTask(), 2, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> task2 = scheduledExecutor.scheduleAtFixedRate(new RepeatitiveTask(), 3, 2, TimeUnit.SECONDS);
    }
}
class RepeatitiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " printing Hello User");
    }
}
 // output
 /*
  * Thread : pool-1-thread-1 printing Hello User
  * Thread : pool-1-thread-2 printing Hello User
  * Thread : pool-1-thread-1 printing Hello User
  * Thread : pool-1-thread-2 printing Hello User
  * Thread : pool-1-thread-1 printing Hello User
  * Thread : pool-1-thread-2 printing Hello User
  * Thread : pool-1-thread-1 printing Hello User
  * Thread : pool-1-thread-2 printing Hello User
  .
  .
  .
  */