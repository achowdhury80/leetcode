package comp.prep2019;
import java.util.*;
public class Prob438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int[] charMap = new int[26];
        int count = 0;
        for (char c : p.toCharArray()) {
        	charMap[c - 'a']++;
        	count++;
        }
        for (int i = 0; i < 26; i++) if (charMap[i] == 0) charMap[i] = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
        	int idx = s.charAt(i) - 'a';
        	if (charMap[idx] != Integer.MIN_VALUE) {
        		charMap[idx]--;
            	if (charMap[idx] >= 0) count--;
        	}
        	if (i - start + 1 > p.length()) {
        		if (charMap[s.charAt(start) - 'a'] != Integer.MIN_VALUE) {
        			charMap[s.charAt(start) - 'a']++;
        			if (charMap[s.charAt(start) - 'a'] > 0) count++;
        		}
                start++;
        	}
        	if(count == 0) result.add(start);
        }
        return result;
    }
}
