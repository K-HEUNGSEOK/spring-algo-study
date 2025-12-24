import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    Set<String> set = new HashSet<>();

    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < str.length() - i; j++) {
        set.add(str.substring(j, i + 1 + j));
      }
    }
    System.out.println(set.size());
  }
}
