public class MonitorLock {
  public static void main(String[] args) {
    MonitorLockImpl obj = new MonitorLockImpl();
    Thread t1 = new Thread(() -> {
      obj.task1();
    });
    Thread t2 = new Thread(() -> {
      obj.task2();
    });
    Thread t3 = new Thread(() -> {
      obj.task3();
    });

    t1.start();
    t2.start();
    t3.start();
  }
}

class MonitorLockImpl {
  
  public synchronized void task1() {
    try {
      System.out.println("Inside task1(), accessed by " + Thread.currentThread().getName());
      Thread.sleep(3000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("task1() completed, accessed by " + Thread.currentThread().getName());
  }
  
  public void task2() {
    System.out.println("Inside task2(), accessed by " + Thread.currentThread().getName());
    synchronized (this) {
      System.out.println("Inside task2() sync block, accessed by " + Thread.currentThread().getName());
    }
  }

  public void task3() {
    System.out.println("Inside task3(), accessed by " + Thread.currentThread().getName());
  }
}
