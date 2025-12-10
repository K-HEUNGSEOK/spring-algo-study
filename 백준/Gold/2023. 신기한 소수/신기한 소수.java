import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static int n;
  static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
    StringBuilder sb = new StringBuilder();
    for (Integer i : list) {
      sb.append(i).append("\n");
    }
    System.out.println(sb.toString());
  }

  static void DFS(int num, int len) {
    if (len == n) {
      if (isPrime(num)) {
        list.add(num);
      }
    } else {
      for (int i = 1; i <= 9; i++) {
        if (isPrime(num * 10 + i)) {
          DFS(num * 10 + i, len + 1);
        }
      }
    }
  }

  static boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
