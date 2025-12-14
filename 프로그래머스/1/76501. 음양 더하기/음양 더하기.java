class Solution {
    public int solution(int[] arr, boolean[] ch) {
        int total = 0;
        
        for(int i = 0 ; i < arr.length; i ++){
            if(ch[i]){
                total += arr[i];
            }else{
                total -= arr[i];
            }
        }
        return total;
    }
}