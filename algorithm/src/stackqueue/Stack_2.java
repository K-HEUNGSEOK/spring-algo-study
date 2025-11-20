package stackqueue;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Stack_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i++){
            char temp = str.charAt(i);
            stack.push(temp);
            if(temp == ')'){
                while(true){
                    Character pop = stack.pop();
                    if(pop == '('){
                        break;
                    }
                }
            }

        }
        for (Character c : stack) {
            System.out.print(c);
        }
    }
}
