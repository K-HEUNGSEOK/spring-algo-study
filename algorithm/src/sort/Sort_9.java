package sort;

import java.io.FileInputStream;
import java.util.Scanner;

public class Sort_9 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max += arr[i];
            min = Math.max(min,arr[i]);
        }

        int lt = min-1;
        int rt = max + 1;
        int ans = 0;
        while (lt + 1 < rt) {
            int mid = (lt + rt) / 2;
            int total = 0;
            int cnt = 1;
            for(int i = 0 ; i < n ;  i++){
                if(total + arr[i] > mid){
                    cnt ++;
                    total = arr[i];
                }else{
                    total += arr[i];
                }
            }

            if(cnt > m){
                lt = mid;
            }else{
                rt =mid;
                ans = mid;
            }

        }
        System.out.println(ans);
    }
}
