class Solution {
    public String solution(int num) {
        String str = "";
        if(isCheck(num)){
            str = "Even";
        }else{
            str = "Odd";
        }
        return str;
    }
    static boolean isCheck(int num){
        return num % 2 == 0;
    }
}