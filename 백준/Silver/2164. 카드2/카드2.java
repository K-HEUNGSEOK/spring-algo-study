import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
  
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n == 1) {
      System.out.println(1);
      return;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    while (queue.size() != 1) {
      queue.poll();
      queue.offer(queue.poll());
    }
    System.out.println(queue.poll());
  }
}
