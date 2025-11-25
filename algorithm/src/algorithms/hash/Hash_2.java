package algorithms.hash;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Hash_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = -1;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0 ; i < n ; i ++){
            for(int j = i + 1; j < n ; j ++){
                for(int k = j + 1; k < n ; k ++){
                    tree.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        int cnt = 0;
        for(Integer num : tree){
            cnt ++;
            if(cnt == m){
                ans = num;
                break;
            }
        }
        System.out.println(ans);
    }
}
