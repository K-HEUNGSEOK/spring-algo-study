class Solution {
    public int solution(int n) {
        if(n == 0){
            return 0;
        }
        int total = 0;
        for(int i = 2; i <= n ; i ++){
            if(n % i == 0){
                total += i;
            }
        }
        return total + 1;
    }
}