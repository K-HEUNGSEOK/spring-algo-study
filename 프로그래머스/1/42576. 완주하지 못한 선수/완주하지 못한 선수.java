import java.util.*;
class Solution {
    public String solution(String[] a, String[] b) {
        Map<String,Integer> map = new HashMap<>();
    
        for(int i = 0 ; i < a.length; i ++){
            map.put(a[i], map.getOrDefault(a[i],0) + 1);
        }
        for(int i = 0 ; i < b.length; i ++){
            map.put(b[i], map.get(b[i])-1);
        }
        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;

    }
}