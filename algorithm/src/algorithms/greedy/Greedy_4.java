package algorithms.greedy;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_4 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();
        int max = 0;
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();
            max = Math.max(max, t);
            list.add(new Lecture(m, t));
        }
        Collections.sort(list);

        int j = 0;
        int ans = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).t < i) {
                    break;
                } else {
                    q.offer(list.get(j).m);
                }
            }
            if (!q.isEmpty()) {
                ans += q.poll();
            }
        }
        System.out.println(ans);
    }

    static class Lecture implements Comparable<Lecture> {
        int m, t;

        public Lecture(int m, int t) {
            this.m = m;
            this.t = t;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.t == o.t) {
                return o.m - this.m;
            }
            return o.t - this.t;
        }
    }
}
