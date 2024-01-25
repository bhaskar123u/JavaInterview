public class PrintSequenceMultipleThreads2 {
  public static void main(String... args) throws InterruptedException {
    TaskFactory1 taskFactory1 = new TaskFactory1();
    // one thread one task i.e., t1 - prints 0, t2 - prints 1, t3 - prints 2
    Thread t0 = new Thread(new PrintSequence1(taskFactory1, 0));

    Thread t1 = new Thread(new PrintSequence1(taskFactory1, 1));

    Thread t2 = new Thread(new PrintSequence1(taskFactory1, 2));
    
    t0.start();
    t1.start();
    t2.start();

    t0.join();
    t1.join();
    t2.join();
  }
}

class PrintSequence1 implements Runnable {
  private TaskFactory1 taskFactory1;
  int number;

  PrintSequence1(TaskFactory1 taskFactory1, int number) {
    this.taskFactory1 = taskFactory1;
    this.number = number;
  }

  @Override
  public void run() { // calling actual tasks based on thread number property
    int counter = 0;
    while (counter++ < 5) {
      if (number == 0)
        taskFactory1.printZero();
      else if(number == 1)
        taskFactory1.printOne();
      else
        taskFactory1.printTwo();
    }
  }
}

class TaskFactory1 {
  int num = 0; // decides which task will be performed 1st

  public void printZero() {
    synchronized (this) {
      while (num == 1 || num == 2) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + " printing " + num);
      num = 1;
      notifyAll();
    }
  }

  public void printOne() {
    synchronized (this) {
      while (num == 0 || num == 2) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + " printing " + num);
      num = 2;
      notifyAll();
    }
  }

  public void printTwo() {
    synchronized (this) {
      while (num == 1 || num == 0) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + " printing " + num);
      num = 0;
      notifyAll();
    }
  }
}

// output
/*
 * Thread-0 printing 0
 * Thread-1 printing 1
 * Thread-2 printing 2
 * Thread-0 printing 0
 * Thread-1 printing 1
 * Thread-2 printing 2
 * Thread-0 printing 0
 * Thread-1 printing 1
 * Thread-2 printing 2
 * Thread-0 printing 0
 * Thread-1 printing 1
 * Thread-2 printing 2
 * Thread-0 printing 0
 * Thread-1 printing 1
 * Thread-2 printing 2
 */