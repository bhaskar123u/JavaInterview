import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class RunTaskForNSeconds {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // start the task with 0 initial delay, and which should repeat after 2 second
        ScheduledFuture<?> beeperHandler = scheduledExecutorService.scheduleAtFixedRate(new Beeper(), 0, 2, TimeUnit.SECONDS);
        // schedule a stop task after 7 seconds
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandler.cancel(false);
                // stop the executor service
                scheduledExecutorService.shutdown();
                try {
                    // if no threads are running, shutDown immediately
                    if(scheduledExecutorService.awaitTermination(0, TimeUnit.SECONDS)){
                        scheduledExecutorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }, 7, TimeUnit.SECONDS);
        
    }
}
class Beeper implements Runnable{
    @Override
    public void run() {
        System.out.println("Beep");
    }
}
