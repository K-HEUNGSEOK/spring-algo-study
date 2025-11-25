package solved.class2;
import java.util.*;
import java.io.*;
public class S5_1436 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //666이 들어가야 하는 수
        int cnt = 1;
        int result = 666;
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(result);
            return;
        }

        while (true) {
            if (cnt == n) {
                break;
            }
            result++;

            if (check(result)) {
                cnt++;
            }
        }
        System.out.println(result);
    }

    static boolean check(int r) {
        char[] arr = String.valueOf(r).toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        if (cnt == 3) {
            return true;
        }
        return false;
    }
}