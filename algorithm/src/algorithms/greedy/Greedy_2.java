package algorithms.greedy;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_2 {
     public static void main(String[] args) throws Exception {
         System.setIn(new FileInputStream("src/input.txt"));
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         Time[] arr = new Time[n];
         for(int i = 0 ; i < n ; i++){
             int s = sc.nextInt();
             int e = sc.nextInt();
             arr[i] = new Time(s,e);
         }
         Arrays.sort(arr);
         int ans = 1;
         int max = arr[0].e;
         for(int i = 1 ; i < n ; i ++){
             if(max <= arr[i].s){
                 max = arr[i].e;
                 ans ++;
             }
         }
         System.out.println(ans);
     }
     static class Time implements Comparable<Time>{
         int s,e;

         public Time(int s, int e) {
             this.s = s;
             this.e = e;
         }
         @Override
         public int compareTo(Time o){
             if(this.e == o.e){
                 return this.s - o.s;
             }
             return this.e - o.e;
         }
     }
}
