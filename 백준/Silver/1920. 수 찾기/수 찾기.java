import java.io.*;
import java.util.*;

public class Main {

  static int[] a, b;

  public static void main(String[] args) throws IOException {
 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = sc.nextInt();
    }
    StringBuilder sb = new StringBuilder();
    Arrays.sort(a);
    for (int i = 0; i < m; i++) {
      int num = b[i];
      if (check(num)) {
        sb.append("1").append("\n");
      } else {
        sb.append("0").append("\n");
      }
    }
    System.out.println(sb);
  }

  static boolean check(int num) {
    int lt = 0;
    int rt = a.length - 1;
    while (rt >= lt) {
      int mid = (lt + rt) / 2;
      if (a[mid] == num) {
        return true;
      }

      if (a[mid] > num) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
    return false;
  }
}
