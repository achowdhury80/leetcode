package comp.prep2019;
import java.util.*;
public class Prob756 {
	public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
        	String key = s.substring(0, 2);
        	List<Character> list = map.getOrDefault(key, new ArrayList<>());
        	list.add(s.charAt(2));
        	map.put(key, list);
        }
        return helper(bottom, map);
    }
	
	private boolean helper(String bottom, Map<String, List<Character>> map) {
		if (bottom.length() == 1) return true;
		List<String> nextLayers = findNextLayers(bottom, map);
        if (nextLayers.size() == 0) return false;
        for (String nextLayer : nextLayers) {
        	if (helper(nextLayer, map)) return true;
        }
        return false;
	}

	private List<String> findNextLayers(String bottom, Map<String, List<Character>> map) {
		int idx = 0;
		List<String> list = new ArrayList<>();
		list.add("");
		while(idx < bottom.length() - 1) {
			String key = bottom.substring(idx, idx + 2);
			if (!map.containsKey(key)) return new ArrayList<>();
			List<Character> chars = map.get(key);
			List<String> temp = new ArrayList<>();
			for (char c : chars) {
				for (String s : list) {
					temp.add(s + c);
				}
			}
			list = temp;
			idx++;
		}
		return list;
	}
}
