package algorithms.stackqueue;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<Character>();
        String ans = "YES";
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()){
                    ans = "NO";
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            ans = "NO";
        }
        System.out.println(ans);
    }
}
