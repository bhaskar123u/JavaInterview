import java.util.concurrent.locks.ReentrantLock;

class MovieHall {
  private final ReentrantLock[][] seatLocks;
  private final boolean[][] seats; // Initialize all with false(all seats are available)
  private final int rows, cols;

  public MovieHall(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    seats = new boolean[rows][cols];
    seatLocks = new ReentrantLock[rows][cols];

    // Initialize locks for all seats
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        seatLocks[i][j] = new ReentrantLock();
      }
    }
  }

  public boolean bookSeats(String userName, int[][] seatChoices) {
    // Attempt to lock all desired seats
    for (int[] seat : seatChoices) {
      int row = seat[0];
      int col = seat[1];

      if (row >= rows || col >= cols || row < 0 || col < 0) {
        System.out.println(userName + ": Invalid seat selection.");
        return false;
      }

      if (!seatLocks[row][col].tryLock()) {
        System.out.println(userName + ": One or more seats are already taken. Retry.");
        return false;
      }
    }

    // Book all seats
    for (int[] seat : seatChoices) {
      int row = seat[0];
      int col = seat[1];
      if (seats[row][col]) {
        System.out.println(userName + ": One or more seats were already booked. Retry.");
        releaseLocks(seatChoices);
        return false;
      }
      // lock the seat
      seatLocks[row][col].lock();
      seats[row][col] = true;
    }

    System.out.println(userName + ": Successfully booked seats: " + formatSeats(seatChoices));
    releaseLocks(seatChoices); // Release locks after successful booking
    return true;
  }

  private void releaseLocks(int[][] seatChoices) {
    for (int[] seat : seatChoices) {
      int row = seat[0];
      int col = seat[1];
      if (row < rows && col < cols && row >= 0 && col >= 0) {
        if (seatLocks[row][col].isHeldByCurrentThread()) {
          seatLocks[row][col].unlock();
        }
      }
    }
  }

  private String formatSeats(int[][] seats) {
    StringBuilder sb = new StringBuilder();
    for (int[] seat : seats) {
      sb.append("(").append(seat[0]).append(", ").append(seat[1]).append(") ");
    }
    return sb.toString();
  }
}

public class MultiThreadedSeatBooking {
  public static void main(String[] args) {
    MovieHall hall = new MovieHall(5, 5); // 5x5 movie hall

    // Simulate users trying to book seats
    Thread user1 = new Thread(() -> hall.bookSeats("User1", new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 } }));
    Thread user2 = new Thread(() -> hall.bookSeats("User2", new int[][] { { 0, 1 }, { 1, 1 }, { 1, 2 } }));
    Thread user3 = new Thread(() -> hall.bookSeats("User3", new int[][] { { 1, 2 }, { 4, 3 } }));
    Thread user4 = new Thread(() -> hall.bookSeats("User4", new int[][] { { 4, 4 }, { 4, 3 }, { 4, 2 } }));

    user1.start();
    user2.start();
    user3.start();
    user4.start();
  }
}