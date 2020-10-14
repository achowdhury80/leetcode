package comp.prep2019.less2000;

import java.util.*;

public class Prob1234 {
	public int balancedString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) map.put(c, map.getOrDefault(c, 0) + 1);
        int count = 0;
        for (char c : new char[] {'Q', 'W', 'E', 'R'}) {
        	if (map.get(c) != null && map.get(c) > n /4) {
        		map.put(c, map.get(c) - n /4);
        		count += map.get(c);
        	} else map.remove(c);
        }
        if (count == 0) return 0;
        int result = Integer.MAX_VALUE, start = 0;
        for(int i = 0; i < arr.length; i++) {
        	if (map.containsKey(arr[i])) {
        		map.put(arr[i], map.get(arr[i]) - 1);
        		if (map.get(arr[i]) > -1) {
        			count--;
        		}
        	}
        	while (count == 0) {
        		result = Math.min(result, i - start + 1);
        		char c = arr[start++];
        		if (map.containsKey(c)) {
        			map.put(c, map.get(c) + 1);
        			if (map.get(c) > 0) count++;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1234 prob = new Prob1234();
		System.out.println(prob.balancedString("WQWRQQQW"));
	}
}
