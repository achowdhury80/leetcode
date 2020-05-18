package comp.prep2019;
import java.util.*;
public class Prob1239 {
	public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (String s : arr) {
        	list.add(findCharMap(s));
        }
        return helper(arr, list, 0, 0, new HashMap<>());
    }
	
	private int helper(List<String> arr, List<Integer> charMaps, int idx, 
			int charMap, Map<String, Integer> cache) {
		String key = charMap + ":" + idx;
		if(cache.containsKey(key)) return cache.get(key);
		int result = Integer.bitCount(charMap);
		if (result > 25) return result;
		for (int i = idx; i < arr.size(); i++) {
			if (charMaps.get(i) < 0 || (charMap & charMaps.get(i)) > 0) continue;
			result = Math.max(result, helper(arr, charMaps, idx + 1, 
					charMap ^ charMaps.get(i), cache));
		}
		cache.put(key, result);
		return result;
	}
	
	private int findCharMap(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			if ((result & (1 << idx)) > 0) return -1;
			result |= (1 << idx);
		}
		return result;
	}
}
