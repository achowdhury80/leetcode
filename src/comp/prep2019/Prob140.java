package comp.prep2019;
import java.util.*;
public class Prob140 {
	public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }
	
	private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) return map.get(s);
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= s.length(); i++) {
			String word = s.substring(0, i);
			if (wordDict.contains(word)) {
				if (i == s.length()) result.add(word);
				else {
					List<String> list = dfs(s.substring(i), wordDict, map);
					if (list.size() > 0) {
						for (String w : list) result.add(word + " " + w);
					}
				}
			}
		}
		map.put(s,  result);
		return result;
	}
}
