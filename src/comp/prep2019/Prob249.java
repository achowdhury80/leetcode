package comp.prep2019;
import java.util.*;
public class Prob249 {
	public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strings) {
        	List<String> list = map.getOrDefault(s.length(), new ArrayList<>());
        	list.add(s);
        	map.put(s.length(), list);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
        	if (entry.getKey() == 1 || entry.getValue().size() == 1) {
        		result.add(entry.getValue());
        		continue;
        	} 
        	List<String> list = entry.getValue();
        	Collections.sort(list);
        	Map<String, List<String>> diffMap = new HashMap<>();
        	for (String s : list) {
        		String key = "";
        		for (int i = 1; i < s.length(); i++) {
        			int d;
        			key += ((d = s.charAt(i) - s.charAt(i - 1)) < 0 ? d + 26 : d) + ":";
        		}
        		List<String> l = diffMap.getOrDefault(key, new ArrayList<>());
        		l.add(s);
        		diffMap.put(key, l);
        	}
        	for (List<String> g : diffMap.values()) {
        		result.add(g);
        	}
        }
        return result;
    }
}
