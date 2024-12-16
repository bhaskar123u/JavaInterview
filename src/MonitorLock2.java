public class MonitorLock2 {
  public static void main(String[] args) {
    int numThreads = 8;
    Thread[] threadArray = new Thread[numThreads];
    TaskDemo sharedTaskDemo = new TaskDemo();

    for (int i = 0; i < numThreads; i++) {

      if (i % 2 == 0)
        threadArray[i] = new Thread(new TaskDemo());
      else
        threadArray[i] = new Thread(sharedTaskDemo);
    }
    
    for(int i=0;i< numThreads;i++)
      threadArray[i].start();
  }
}

class TaskDemo implements Runnable {
  public void run() {
    synchronized (this) // synchronized (TaskDemo.class)
    {
      System.out.println(Thread.currentThread().getName() + " have entered the synchronized block");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}