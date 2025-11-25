package algorithms.sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_4 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        int m = sc.nextInt();
        int[] command = new int[m];
        for(int i = 0 ; i < m ; i++) command[i] = sc.nextInt();

        for(int i = 0 ; i < m ; i++){
            int num = command[i];
            boolean flag = false;
            int index = 0;
            for(int j = 0; j < n ; j++) {
                if(arr[j] == num){
                    flag = true;
                    index = j;
                    break;
                }
            }
            if(flag){
                hit(num, index);
            }else{
                miss(num);
            }
        }
        Arrays.stream(arr)
                .forEach(z -> System.out.print(z + " "));

     }

     static void hit(int num, int index){
        for(int i = index; i >= 1; i --){
            arr[i] = arr[i-1];
        }
        arr[0] = num;
     }
     static void miss(int num){
        for(int i = arr.length-1; i >= 1; i --){
            arr[i] = arr[i-1];
        }
        arr[0] = num;
     }
}
