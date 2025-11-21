package sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++) {
            int index = i;
            for(int j = i + 1 ; j < n ; j++){
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        Arrays.stream(arr)
                .forEach(q -> System.out.print(q + " "));
     }
}
