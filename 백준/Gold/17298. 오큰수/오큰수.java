import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
          ans[stack.pop()] = arr[i];
        }
        stack.push(i);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int an : ans) {
      sb.append(an).append(" ");
    }
    System.out.println(sb);
  }
}
