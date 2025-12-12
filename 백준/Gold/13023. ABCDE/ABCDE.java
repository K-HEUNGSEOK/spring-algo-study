import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static List<Integer>[] graph;
  static boolean[] ch;
  static int n, m;
  static boolean flag;

  public static void main(String[] args) throws IOException {
    
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph[a].add(b);
      graph[b].add(a);
    }
    flag = false;
    for (int i = 0; i < n; i++) {
      ch = new boolean[n];
      DFS(i, 1);
      if (flag) {
        System.out.println(1);
        return;
      }
    }

    System.out.println(0);
  }

  static void DFS(int v, int depth) {
    ch[v] = true;
    if (flag) {
      return;
    }
    if (depth == 5) {
      flag = true;
      return;
    }
    for (int num : graph[v]) {
      if (!ch[num]) {
        DFS(num, depth + 1);
      }
    }
    ch[v] = false;
  }
}
