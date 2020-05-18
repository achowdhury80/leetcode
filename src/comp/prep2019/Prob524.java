package comp.prep2019;
import java.util.*;
public class Prob524 {
	public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (x, y) -> x.length() == y.length() ? x.compareTo(y) : y.length() - x.length());
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	List<Integer> list = map.getOrDefault(c, new ArrayList<>());
        	list.add(i);
        	map.put(c, list);
        }
        int lastPos = -1;
        for (String w : d) {
        	boolean flag = true;
        	for (char c : w.toCharArray()) {
        		lastPos = find(map, c, lastPos);
        		if (lastPos < 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) return w;
        }
        return "";
    }
	
	private int find(Map<Character, List<Integer>> map, char c, int lastPos) {
		if (!map.containsKey(c)) return -1;
		List<Integer> list = map.get(c);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > lastPos) return list.get(i);
		}
		return -1;
	}
}
