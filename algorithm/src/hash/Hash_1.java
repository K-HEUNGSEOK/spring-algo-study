package hash;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Hash_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String s = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        int ans = 0;
        int n = s.length();
        for(int i = 0 ; i < s.length(); i ++){
            target.put(s.charAt(i), target.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0 ; i < s.length() - 1; i ++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for(int i = s.length()-1; i < str.length(); i ++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if(map.equals(target)){
                ans ++;
            }
            map.put(str.charAt(i - n + 1), map.get(str.charAt(i - n + 1))-1);
            if(map.get(str.charAt(i - n + 1)) == 0){
                map.remove(str.charAt(i-n+1));
            }
        }
        System.out.println(ans);

    }
}
