package comp.prep2019;
import java.util.*;
public class Prob49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs.length < 1) return result;
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String s = findStringMap(str);
			List<String> list = map.getOrDefault(s, new ArrayList<>());
			list.add(str);
			map.put(s, list);
		}
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
    }
	
	private String findStringMap(String str) {
		int[] arr = new int[26];
		for (char c : str.toCharArray()) {
			arr[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) sb.append('a' + i).append(arr[i]);
		}
		return sb.toString();
	}
}
