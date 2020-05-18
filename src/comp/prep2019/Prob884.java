package comp.prep2019;
import java.util.*;
public class Prob884 {
	public String[] uncommonFromSentences(String A, String B) {
        Map<String, Boolean> map = new HashMap<>(); 
        for (String s : A.split(" ")) {
        	if (map.containsKey(s)) map.put(s, true);
        	else {
        		map.put(s, false);
        	}
        }
        for (String s : B.split(" ")) {
        	if (map.containsKey(s)) map.put(s, true);
        	else {
        		map.put(s, false);
        	}
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
        	if (!entry.getValue()) list.add(entry.getKey());
        }
        return list.toArray(new String[0]);
    }
}
