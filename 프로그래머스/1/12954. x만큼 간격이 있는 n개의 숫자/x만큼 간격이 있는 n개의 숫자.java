class Solution {
    public long[] solution(int x, int n) {
        long[] ans = new long[n];
        long total = 0;
        for(int i = 0 ; i < n ; i ++){
            total += x;
            ans[i] = total;
        }
        return ans;
    }
}