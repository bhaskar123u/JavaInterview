import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample2 {
  public static void main(String[] args) {
    for(int i=0;i<10;i++)
      main();
  }
  public static void main() {
      ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS,
          new ArrayBlockingQueue<>(2));

      CompletableFuture<String> futureObj = CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "1";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
        }
        return val + "2";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        return val + "3";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(600);
        } catch (InterruptedException e) {
        }
        return val + "4";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(800);
        } catch (InterruptedException e) {
        }
        return val + "5";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(950);
        } catch (InterruptedException e) {
        }
        return val + "6";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(1250);
        } catch (InterruptedException e) {
        }
        return val + "7";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(1400);
        } catch (InterruptedException e) {
        }
        return val + "8";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(1375);
        } catch (InterruptedException e) {
        }
        return val + "9";
      }).thenApplyAsync((String val) -> {
        try {
          Thread.sleep(950);
        } catch (InterruptedException e) {
        }
        return val + "A";
      }).thenApplyAsync((String val)->{
        return val + "B";
      }).thenApplyAsync((String val)->{
        return val + "C";
      }).thenApplyAsync((String val)->{
        return val + "D";
      }).thenApplyAsync((String val)->{
        return val + "E";
      }).thenApplyAsync((String val)->{
        return val + "F";
      }).thenApplyAsync((String val) -> {
        return val + "G";
      }).thenApplyAsync((String val) -> {
        return val + "H";
      }).thenApplyAsync((String val) -> {
        return val + "I";
      }).thenApplyAsync((String val) -> {
        return val + "J";
      }).thenApplyAsync((String val) -> {
        return val + "K";
      }).thenApplyAsync((String val) -> {
        return val + "L";
      }).thenApplyAsync((String val) -> {
        return val + "M";
      }).thenApplyAsync((String val) -> {
        return val + "N";
      }).thenApplyAsync((String val) -> {
        return val + "O";
      }).thenApplyAsync((String val) -> {
        return val + "P";
      }).thenApplyAsync((String val) -> {
        return val + "Q";
      }).thenApplyAsync((String val) -> {
        return val + "R";
      }).thenApplyAsync((String val) -> {
        return val + "S";
      }).thenApplyAsync((String val) -> {
        return val + "T";
      }).thenApplyAsync((String val) -> {
        return val + "U";
      }).thenApplyAsync((String val) -> {
        return val + "V";
      }).thenApplyAsync((String val) -> {
        return val + "W";
      }).thenApplyAsync((String val) -> {
        return val + "X";
      }).thenApplyAsync((String val) -> {
        return val + "Y";
      }).thenApplyAsync((String val) -> {
        return val + "Z";
      });

      
      try {
        String finalResult = futureObj.get();
        System.out.println(finalResult);
      } catch (InterruptedException | ExecutionException e) {
      }

      threadPoolExecutor.shutdown();
  }
}

/*
 * It is not necessary that when we have .thenApplyAsync( ), ordering is maintained, if we want to achieve
 * ordering, .thenComposeAsync( ) will be used.
 */