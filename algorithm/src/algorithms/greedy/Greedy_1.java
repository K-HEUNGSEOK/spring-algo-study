package algorithms.greedy;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_1 {
     public static void main(String[] args) throws Exception {
         System.setIn(new FileInputStream("src/input.txt"));
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         Student[] arr = new Student[n];
         for(int i = 0 ; i < n ; i ++){
             int h = sc.nextInt();
             int w = sc.nextInt();
             arr[i] = new Student(h,w);
         }
         Arrays.sort(arr);
         int ans = 1;
         int max = arr[0].w;
         for(int i = 1 ; i < n ; i ++){
             if(max < arr[i].w){
                 ans ++;
                 max = arr[i].w;
             }
         }

         System.out.println(ans);
     }
     static class Student implements Comparable<Student>{
         int h;
         int w;

         public Student(int h, int w) {
             this.h = h;
             this.w = w;
         }

         @Override
         public int compareTo(Student o){
             return o.h - this.h;
         }

         @Override
         public String toString() {
             return "Student{" +
                     "h=" + h +
                     ", w=" + w +
                     '}';
         }
     }
}
