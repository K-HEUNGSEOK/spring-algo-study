import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int [] ans = new int[arr.length-1];
        for(int i = 0 ; i < arr.length ; i ++){
            if(index == i){
                continue;
            }
            list.add(arr[i]);
        }
        for(int i = 0 ; i < list.size(); i ++){
            ans[i] = list.get(i);
        }
    
        return ans;
    }
}