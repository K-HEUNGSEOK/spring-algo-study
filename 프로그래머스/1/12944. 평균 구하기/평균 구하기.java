class Solution {
    public double solution(int[] arr) {
        double total = 0;
        for(int n : arr){
            total += n;
        }
        return total / arr.length;
    }
}