import java.util.*;
class Solution {
    static int n, ans;
    public int solution(int[] arr, int target) {
        n = arr.length;
        ans = 0;
        DFS(0,0,arr, target);
        return ans;
    }
    static void DFS(int v, int total, int[] arr, int target){
        if(v == n){
            if(total == target){
                ans ++;
            }
        }else{
            DFS(v + 1 , total + arr[v], arr,target);
            DFS(v + 1, total - arr[v], arr,target);
        }
    }
}