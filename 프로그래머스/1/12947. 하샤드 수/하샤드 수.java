class Solution {
    public boolean solution(int x) {
        return isCheck(x);
    }
    static boolean isCheck(int num){
        int total = 0;
        int temp = num;
        while(temp > 0){
            total += temp % 10;
            temp /= 10;
        }
        return num % total == 0;
    }
}