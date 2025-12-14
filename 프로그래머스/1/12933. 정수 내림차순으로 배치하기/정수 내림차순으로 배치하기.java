class Solution {
    public long solution(long n) {
        char[] arr = (n+"").toCharArray();
        
        for(int i = 0 ; i < arr.length ; i ++){
            int num = arr[i] -'0';
            int index = 0;
            boolean flag = false;
            for(int j = i + 1; j < arr.length; j ++){
                int num2 = arr[j] - '0';
                if(num2 > num){
                    num = num2;
                    index = j;
                    flag = true;
                }
            }
            if(flag){
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return Long.parseLong(new String(arr));
    }
}