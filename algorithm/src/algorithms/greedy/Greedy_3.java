package greedy;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Greedy_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for(int i = 0; i < n ; i ++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time(s,'s'));
            list.add(new Time(e,'e'));
        }

        Collections.sort(list);
        int ans =0;
        int cnt = 0;

        for(Time t : list) {
            if(t.e == 's'){
                cnt ++;
            }else {
                cnt --;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    static class Time implements Comparable<Time>{
        int s;
        char e;

        public Time(int s, char e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if(this.s == o.s) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
}
