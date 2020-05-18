package comp.prep2019;
import java.util.*;
public class Prob159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int result = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	}
        	else {
        		map.put(c, 1);
        		count++;
        		while(count > 2) {
        			char ch = s.charAt(start);
        			start++;
        			map.put(ch, map.get(ch) - 1);
        			if(map.get(ch) == 0) {
        				map.remove(ch);
        				count--;
        			}
        		}
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob159 prob = new Prob159();
		System.out.println(prob.lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}
