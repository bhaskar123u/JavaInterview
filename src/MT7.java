// Stop a thread

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MT7 {
  public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println(task()));
        t.start();
       //making main thread to sleep for 10 seconds
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            System.out.println("going to interrup in 10 seconds");
            t.interrupt();
        },10,TimeUnit.SECONDS); // this will run after a delay of 10 seconds
        scheduler.shutdown();
    }
    public static String task(){
        System.out.println("task started");
        while(!Thread.currentThread().isInterrupted()){
            //next step
        }
        System.out.println("task completed");
        return "some random string";
    }
}
