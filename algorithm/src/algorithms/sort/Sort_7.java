package algorithms.sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_7 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        for(int i = 0 ; i < n ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[i] = new Node(a,b);
        }
        Arrays.sort(nodes);
        for(int i = 0; i < n ; i ++){
            System.out.println(nodes[i].x + " " + nodes[i].y);
        }
    }
    static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o){
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
