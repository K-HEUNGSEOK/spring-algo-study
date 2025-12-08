import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1; j <= n ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] prefix = new int[n+1][n+1];
        //누적합 채우기
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= n ; j ++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + arr[i][j] - prefix[i-1][j-1];
             }
        }
//        for(int i = 1; i <= n ; i ++){
//            for(int j = 1; j <= n; j ++){
//                System.out.print(prefix[i][j] + " ");
//            }
//            System.out.println();
//        }
        //출력 부분
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i ++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            sb.append(prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}