public class TestProgram9 {
    public static void main(String[] args) {
        TaskZ task = new TaskB();
        //task.bye(); // Error - parent interface cannot access child class concrete methods
        TaskB task2 = new TaskB();
        task2.bye();
    }
}
interface TaskZ{
    public void hello();
}

class TaskB implements TaskZ {
    @Override
    public void hello() {
        System.out.println("hello");
    }

    public void bye() {
        System.out.println("bye");
    }
}

// output
// bye
