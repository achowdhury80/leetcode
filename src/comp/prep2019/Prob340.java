package comp.prep2019;
import java.util.*;
public class Prob340 {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr = s.toCharArray();
        if (arr.length <= k) return arr.length;
        int start = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
        	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        	while(map.keySet().size() > k) {
        		map.put(arr[start], map.get(arr[start]) - 1);
        		if (map.get(arr[start]) == 0) map.remove(arr[start]);
        		start++;
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
