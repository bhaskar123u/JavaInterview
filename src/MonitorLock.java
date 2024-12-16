public class MonitorLock {
  public static void main(String[] args) {
    MonitorLockImpl obj = new MonitorLockImpl();
    Thread t1 = new Thread(() -> {
      obj.task0();
    });
    Thread t2 = new Thread(() -> {
      obj.task1();
    });
    Thread t3 = new Thread(() -> {
      obj.task2();
    });

    t1.start();
    t2.start();
    t3.start();
  }
}

class MonitorLockImpl {
  
  public synchronized void task0() {
    try {
      System.out.println("Inside task0(), accessed by " + Thread.currentThread().getName());
      Thread.sleep(3000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("task0() completed, accessed by " + Thread.currentThread().getName());
  }
  
  public void task1() {
    System.out.println("Inside task1(), accessed by " + Thread.currentThread().getName());
    synchronized (this) {
      System.out.println("Inside task1() sync block, accessed by " + Thread.currentThread().getName());
    }
  }

  public void task2() {
    System.out.println("Inside task2(), accessed by " + Thread.currentThread().getName());
  }
}
