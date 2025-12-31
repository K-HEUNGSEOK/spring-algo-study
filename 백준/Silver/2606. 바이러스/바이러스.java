import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static ArrayList<Integer>[] graph;
  static boolean[] ch;
  static int ans;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph[a].add(b);
      graph[b].add(a);
    }
    ch = new boolean[n + 1];
    ans = 0;
    DFS(1);
    System.out.println(ans);
  }

  static void DFS(int v) {
    ch[v] = true;
    for (Integer num : graph[v]) {
      if (!ch[num]) {
        ch[num] = true;
        ans++;
        DFS(num);
      }
    }
  }
}