import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        Stack<Integer> stack = new Stack<>();
        int next = 1;
        int idx =0 ;
        StringBuilder sb = new StringBuilder();
        boolean check = true ;
        while (idx < n){
            if (next <= arr[idx]) {
                stack.push(next);
                sb.append("+").append("\n");
                next++;
            }
            if (!stack.isEmpty() && stack.peek() == arr[idx]){
                stack.pop();
                sb.append("-").append("\n");
                idx ++;
            }

            if (idx < n && next > arr[idx] && (stack.isEmpty() || stack.peek() != arr[idx])){
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
