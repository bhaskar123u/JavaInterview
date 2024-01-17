// https://amiyasahu.github.io/singleton-class-per-thread-in-java.html
public class SingletonPerThread {
 public static void main(String[] args) {
    Thread t1 = new ThreadLocalSingleton();
    t1.start();
    Thread t2 = new ThreadLocalSingleton();
    t2.start();
 }
}

class Singleton2 {
  private static ThreadLocal<Singleton2> threadLocalSingleton = ThreadLocal.withInitial(() -> new Singleton2());

  private Singleton2() {
  }

  public static Singleton2 getInstance() {
    return threadLocalSingleton.get();
  }
}

class ThreadLocalSingleton extends Thread {

  public void run() {
    Singleton2 obj = Singleton2.getInstance();
    System.out.println("Thread " + Thread.currentThread().getName() + " has object with hashcode " + obj.hashCode());
  }
}
