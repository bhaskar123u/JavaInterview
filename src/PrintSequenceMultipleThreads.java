public class PrintSequenceMultipleThreads {
    public static void main(String... args) {
        TaskFactory taskFactory = new TaskFactory();
        //one thread one task i.e., t1 - prints 0, t2 - prints 1
        Thread t0 = new Thread(new PrintSequence(taskFactory, 0));
        t0.setName("t0");
        Thread t1 = new Thread(new PrintSequence(taskFactory, 1));
        t1.setName("t1");
        t1.start();
        t0.start();
    }
}
class PrintSequence implements Runnable {
    private TaskFactory taskFactory;
    int number;
    PrintSequence(TaskFactory taskFactory, int number) {
        this.taskFactory = taskFactory;
        this.number = number;
    }
    @Override
    public void run() { // calling actual tasks based on thread number property
        int counter = 0;
        while(counter++ < 5){
            if (number == 0)
                taskFactory.printZero();
            else
                taskFactory.printOne();
        }
    }
}
class TaskFactory {
    int num = 0; // decides which task will be performed 1st
    public void printZero() {
        synchronized(this){
            while(num == 1) {
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
        synchronized(this){
            while(num == 0) {
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
