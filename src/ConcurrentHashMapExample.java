import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
  public static void main(String[] args) {
    // Create a ConcurrentHashMap instance
    ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    // Adding key-value pairs
    concurrentMap.put("A", 1);
    concurrentMap.put("B", 2);
    concurrentMap.put("C", 3);

    // Simulate concurrent access using threads
    Thread t1 = new Thread(() -> {
      // Thread 1 adds and updates values
      concurrentMap.put("D", 4);
      concurrentMap.put("A", 5); // Update value of key "A"
    });

    Thread t2 = new Thread(() -> {
      // Thread 2 reads and adds values concurrently
      System.out.println("Thread 2: " + concurrentMap.get("B"));
      concurrentMap.put("E", 5);
    });

    Thread t3 = new Thread(() -> {
      // Thread 3 checks if a key exists and performs an action
      concurrentMap.computeIfAbsent("F", k -> 6); // Adds "F" with value 6 if absent
    });

    // Start the threads
    t1.start();
    t2.start();
    t3.start();

    // Wait for threads to finish
    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print the map after all threads have executed
    System.out.println("Final ConcurrentMap: " + concurrentMap);
  }
}
