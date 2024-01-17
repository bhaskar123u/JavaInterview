public class MT2 {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<30; i++){
            Thread obj = new Thread(new Task());
            obj.setName("thread"+i);
            obj.start();
            if(i == 18)
                obj.join();
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread in run : " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
Thread in run : thread4
Thread in run : thread12
Thread in run : thread17
Thread in run : thread3
Thread in run : thread10
Thread in run : thread15
Thread in run : thread6
Thread in run : thread8
Thread in run : thread7
Thread in run : thread0
Thread in run : thread1
Thread in run : thread13
Thread in run : thread11
Thread in run : thread16
Thread in run : thread14
Thread in run : thread9
Thread in run : thread2
Thread in run : thread18
Thread in run : thread5
Thread in run : thread19
Thread in run : thread20
Thread in run : thread21
Thread in run : thread22
Thread in run : thread23
Thread in run : thread24
Thread in run : thread25
Thread in run : thread26
Thread in run : thread27
Thread in run : thread28
Thread in run : thread29
 */
