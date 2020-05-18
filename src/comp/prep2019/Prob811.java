package comp.prep2019;
import java.util.*;
public class Prob811 {
	/**
	 * 
	 * @param cpdomains
	 * @return
	 */
	public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
        	String[] arr = s.split(" ");
        	int visit = Integer.parseInt(arr[0]);
        	map.put(arr[1], map.getOrDefault(arr[1], 0) + visit);
        	String name = arr[1];
        	int idx;
        	while((idx = name.indexOf('.')) > -1) {
        		name = name.substring(idx + 1);
        		map.put(name, map.getOrDefault(name, 0) + visit);
        	}
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
