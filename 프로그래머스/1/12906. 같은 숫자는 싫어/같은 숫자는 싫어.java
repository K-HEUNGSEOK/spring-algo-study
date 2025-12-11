import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr){
            if(stack.isEmpty()){
                stack.push(num);
            }
            if(!stack.isEmpty() && stack.peek() != num){
                stack.push(num);
        }
    }
        int len = stack.size();
        int[] ans = new int[len];
        for(int i = 0 ; i < len ; i ++){
            ans[len-1-i] = stack.pop();
        }
        return ans;
}
}