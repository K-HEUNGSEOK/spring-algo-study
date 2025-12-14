class Solution {
    public int solution(int[] numbers) {
        int total = 0;
        boolean[] ch = new boolean[10];
        
        for(int i = 0 ; i < numbers.length; i ++){
            int num = numbers[i];
            if(!ch[num]){
                ch[num] = true;
            }
        }
        for(int i = 0 ; i < 10 ; i ++){
            if(!ch[i]){
                total += i;
            }
        }
        return total;
    }
}