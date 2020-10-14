package comp.prep2019.less1000;
import java.util.*;
public class Prob187 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 11) return result;
		StringBuilder sb = new StringBuilder(s.substring(0, 10));
		Map<String, Integer> map = new HashMap<>();
		map.put(sb.toString(), 1);
		char[] arr = s.toCharArray();
		for (int i = 10; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.deleteCharAt(0);
			String st = sb.toString();
			map.put(st, map.getOrDefault(st, 0) + 1);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) result.add(entry.getKey());
		}
		return result;
    }
}
