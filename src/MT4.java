// Object level lock
public class MT4 {
    public static void main(String[] args) {
        TaskDelta taskObj = new TaskDelta();
        // Case 1
        Thread t1 = new Thread(taskObj);
        Thread t2 = new Thread(taskObj);
        t1.start();
        t2.start();
        // Case 2
        // TaskDelta taskObj2 = new TaskDelta();
        // Thread t1 = new Thread(taskObj);
        // Thread t2 = new Thread(taskObj2);
        // t1.start();
        // t2.start();
    }
}
class TaskDelta implements Runnable{
    @Override
    synchronized public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " in run() before sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : " + Thread.currentThread().getName() + " in run() after sleep");
    }
}
/*
    Case 1
    Thread : Thread-0 in run() before sleep
    <pause>
    Thread : Thread-0 in run() after sleep
    Thread : Thread-1 in run() before sleep
    <pause>
    Thread : Thread-1 in run() after sleep
    Case 2
    Thread : Thread-1 in run() before sleep
    Thread : Thread-0 in run() before sleep
    <pause>
    Thread : Thread-1 in run() after sleep
    Thread : Thread-0 in run() after sleep
 */
