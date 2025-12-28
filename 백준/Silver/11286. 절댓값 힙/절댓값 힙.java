import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
   
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> {
          int absA = Math.abs(a);
          int absB = Math.abs(b);
          if (absA == absB) {
            return Integer.compare(a, b);
          }
          return Integer.compare(absA, absB);
        }
    );
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      if (num == 0) {
        if (queue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(queue.poll()).append("\n");
        }
      } else {
        queue.offer(num);
      }
    }
    System.out.println(sb);
  }
}
