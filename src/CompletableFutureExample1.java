import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample1 {
  public static void main(String[] args) {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(5));

    // UseCase 1
    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (Exception e) {
      }
      System.out.println(Thread.currentThread().getName());
      return "Bhaskar";
    }, threadPoolExecutor)
        .thenApply((String val) -> { // Same thread will continue to do the task
          System.out.println(Thread.currentThread().getName());
          return val + " Sharan";
        });

    try {
      System.out.println(completableFuture.get());
      System.out.println(Thread.currentThread().getName());
    } catch (InterruptedException | ExecutionException e) {
    }

    // UseCase 2
    CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (Exception e) {
      }
      System.out.println(Thread.currentThread().getName());
      return "Kumud";
    }, threadPoolExecutor)
        .thenApplyAsync((String val) -> { // Async will span new thread for this action
          System.out.println(Thread.currentThread().getName());
          return val + " Raj";
        }, threadPoolExecutor);

    try {
      System.out.println(completableFuture2.get());
      System.out.println(Thread.currentThread().getName());
    } catch (InterruptedException | ExecutionException e) {
    }

    // UseCase 3 (in this case, no threadPoolExecutor has been assigned, hence the operations are spanning thread from default poolExecutor, i.e., Fork-Join pool)
    CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (Exception e) {
      }
      System.out.println(Thread.currentThread().getName());
      return "Ankita";
    })
        .thenApplyAsync((String val) -> {
          System.out.println(Thread.currentThread().getName());
          return val + " Anand";
        });

    try {
      System.out.println(completableFuture3.get());
      System.out.println(Thread.currentThread().getName());
    } catch (InterruptedException | ExecutionException e) {
    }

    threadPoolExecutor.shutdown();
  }
}

/*
 * output
 * pool-1-thread-1
 * pool-1-thread-1
 * Bhaskar Sharan
 * main
 * pool-1-thread-2
 * pool-1-thread-3
 * Kumud Raj
 * main
 * ForkJoinPool.commonPool-worker-1
 * ForkJoinPool.commonPool-worker-1
 * Ankita Anand
 * main
 */

/*
 * .supplyAsync( ) -> initiates async operations
 * .thenApply( ) -> uses same thread and performs further operation, .thenApplyAsync( ) -> spans new thread
 * .thenConsumes( ) -> If we chain multiple .thenApply( ) together, there is no order of execution, hence we use .thenCompose( ) so that any order is established
 * .thenAccept( ) -> terminal operation, after this no futher action is perfomed
 * .thenCombine( ) -> combines result of multiple completable futures
 */