package comp.prep2019;
import java.util.*;
public class Prob1297 {
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        char[] arr = s.toCharArray();
        for (int i = minSize; i <= maxSize; i++) {
        	int[] charMap = new int[26];
        	int count = 0;
        	for (int j = 0; j < i; j++) {
        		int idx = arr[j] - 'a';
        		if (charMap[idx] == 0) {
        			count++;
        		}
        		charMap[idx]++;
        	}
        	if (count <= maxLetters) {
        		String sub = s.substring(0, i);
        		map.put(sub, map.getOrDefault(sub, 0) + 1);
        		result = Math.max(result, map.get(sub));
        	}
        	for (int j = i; j < s.length(); j++) {
        		int idx = arr[j] - 'a';
        		if (charMap[idx] == 0) {
        			count++;
        		}
        		charMap[idx]++;
        		idx = arr[j - i] - 'a';
        		if (charMap[idx] == 1) {
        			count--;
        		}
        		charMap[idx]--;
        		if (count <= maxLetters) {
            		String sub = s.substring(j - i + 1, j + 1);
            		map.put(sub, map.getOrDefault(sub, 0) + 1);
            		result = Math.max(result, map.get(sub));
            	}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1297 prob = new Prob1297();
		System.out.println(prob.maxFreq("aaaa",1,3,3));
	}
}
