import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
  
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int target = sc.nextInt();
    Integer[] money = new Integer[n];
    for (int i = 0; i < n; i++) {
      money[i] = sc.nextInt();
    }
    Arrays.sort(money, Collections.reverseOrder());

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (money[i] <= target) {
        cnt += target / money[i];
        target = target % money[i];
        if (target <= 0) {
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
