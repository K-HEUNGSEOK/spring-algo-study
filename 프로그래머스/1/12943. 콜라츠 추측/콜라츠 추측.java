class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        long temp = num;
        int cnt = 0;
        while(temp != 1){
            if(temp % 2 == 0){
                temp /= 2;
            }else{
                temp = temp * 3 + 1;
            }
            cnt ++;
            
            if(cnt >= 500){
                return -1;
            }
        }
        System.out.print(cnt);
        return cnt;
    }
}