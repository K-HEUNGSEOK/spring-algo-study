import java.util.*;
class Solution {
    public int[] solution(long n) {
        char[] arr = (n+"").toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i <arr.length; i ++ ){
            stack.push(arr[i]);
        }
        
        int len = stack.size();
        int[] ans = new int[len];
        
        for(int i = 0 ; i < len; i ++){
            ans[i] = stack.pop() - '0';
        }
        return ans;
    }
}