import java.util.*;
class Solution {
    static List<String> list;
    static String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        list = new LinkedList<>();
        DFS("");
        for(int i = 0 ; i < list.size(); i ++){
            if(list.get(i).equals(word)){
                answer = i + 1;
                return answer;
            }
        }
        return answer;
    }
    static void DFS(String str){
        if (str.length() > arr.length){
            return;
        }
        if(!str.equals("")){
            list.add(str);
        }
        for(int i = 0 ; i < arr.length; i ++){
            DFS(str + arr[i]);
        }
    }
}