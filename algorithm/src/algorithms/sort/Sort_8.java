package algorithms.sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_8 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
   
        int lt = 0;
        int rt = n;
        while(lt + 1 < rt){
            int mid = (lt+rt) /2;

            if(arr[mid] == target){
                System.out.println(mid+1);
                return;
            }else if(arr[mid] > target){
                rt = mid;
            }else{
                lt = mid;
            }
        }
    }
}
