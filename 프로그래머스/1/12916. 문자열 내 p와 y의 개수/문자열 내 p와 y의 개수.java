class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        int a = 0;
        int b = 0;
        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) == 'p'){
                a ++;
            }else if(s.charAt(i) == 'y'){
                b ++;
            }
        }
        if(a != b){
            return false;
        }
        return true;
    }
}