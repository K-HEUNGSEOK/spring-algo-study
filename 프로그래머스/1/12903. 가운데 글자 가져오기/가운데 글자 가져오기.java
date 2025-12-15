class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 0){
            int len = s.length() / 2;
            return s.charAt(len-1) + "" + s.charAt(len);
        }else{
            return s.charAt(s.length() / 2) + "";
        }
    }
}