import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample3 {
  public static void main(String[] args) {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(5));

    // UseCase 1
    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
      System.out.println(Thread.currentThread().getName());
      return "Bhaskar ";
    }, threadPoolExecutor);

    CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
      System.out.println(Thread.currentThread().getName());
      return 150318;
    });

    CompletableFuture<String> combinedFutureObject = completableFuture.thenCombine(completableFuture2,
        (String val, Integer val2) -> val + val2);

    try {
      System.out.println(combinedFutureObject.get());
    } catch (InterruptedException | ExecutionException e) {
    }

    threadPoolExecutor.shutdown();
  }
}
