package comp.prep2019;
import java.util.*;
public class Prob438 {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        int[] freqMap = new int[26];
        for (char c : p.toCharArray()) freqMap[c - 'a']++;
        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	freqMap[c - 'a']--;
        	while(freqMap[c - 'a'] < 0) {
        		freqMap[arr[start] - 'a']++;
        		start++;
        	}
        	if (i - start + 1 == p.length()) {
        			result.add(start);
    		}
        }
        return result;
    }
}
