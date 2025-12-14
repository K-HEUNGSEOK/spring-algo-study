class Solution {
    public long solution(long n) {
        for(long i = 1 ; i <= (long) Math.sqrt(n); i ++){
            if(i * i == n){
                long num = i + 1;
                return num * num;
            }
        }
        return -1;
    }
}