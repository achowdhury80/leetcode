package comp.prep2019.less1000;
import java.util.*;
public class Prob527 {
	public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> result = new ArrayList<>(dict);
        for (int i = 0; i < dict.size(); i++) {
        	String s = dict.get(i);
        	if (s.length() < 4) continue;
        	String abbv = findAbbvr(s);
        	List<Integer> list = map.getOrDefault(abbv, new ArrayList<>());
        	list.add(i);
        	map.put(abbv, list);
        }
        for (List<Integer> values : map.values()) {
        	Map<Integer, String> abbvrMap = findAbvvrForSimilar(values, dict);
        	for (Map.Entry<Integer, String> entry : abbvrMap.entrySet()) {
        		result.set(entry.getKey(), entry.getValue());
        	}
        }
        
        return result;
    }
	
	private Map<Integer, String> findAbvvrForSimilar(List<Integer> list, List<String> dict) {
		int n = dict.get(list.get(0)).length();
		Map<Integer, String> result = new HashMap<>();
		Trie root = new Trie();
		Trie cur = root;
		for (int i : list) {
			String s = dict.get(i);
			cur = root;
			cur.count++;
			for (char c : s.toCharArray()) {
				int idx = c - 'a';
				if (cur.arr[idx] == null) cur.arr[idx] = new Trie();
				cur = cur.arr[idx];
				cur.count++;
			}
			cur.isWord = true;
		}
		for (int i : list) {
			String s = dict.get(i);
			cur = root;
			boolean flag = false;
			for (int j = 0; j < s.length() - 3; j++) {
				int idx = s.charAt(j) - 'a';
				cur = cur.arr[idx];
				if (cur.count == 1) {
					flag = true;
					String abb = s.substring(0, j + 1) + (s.length() - 2 - j) 
							+ s.charAt(s.length() - 1);
					result.put(i, abb);
					break;
				}
			}
			if (!flag) result.put(i, s);
		}
		return result;
	}
	
	private String findAbbvr(String s) {
		if (s.length() < 4) return s;
		return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
	}
	
	class Trie {
		Trie[] arr = new Trie[26];
		boolean isWord = false;
		int count = 0;
	}
}
