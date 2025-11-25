package algorithms.sort;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sort_5 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i ++){
            if(!set.add(sc.nextInt())){
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");

    }
}
