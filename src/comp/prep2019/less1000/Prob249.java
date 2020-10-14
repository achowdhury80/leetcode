package comp.prep2019.less1000;
import java.util.*;
public class Prob249 {
	public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
        	StringBuilder key = new StringBuilder();
        	for (int i = 1; i < s.length(); i++) {
        		int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
        		key.append(":" + diff);
        	}
        	List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
        	list.add(s);
        	map.put(key.toString(), list);
        }
        return new ArrayList<>(map.values());
    }
}
