class Solution {
    public long solution(int a, int b) {
        if(a == b){
            return (long)a;
        }
        int tempA = a;
        int tempB = b;
        a = Math.min(tempA, tempB);
        b = Math.max(tempA,tempB);
        System.out.print(a + " " + b);
        long total = 0;
        for(int i = a ; i <= b; i ++){
            total += i;
        }
        return total;
    }
}