package comp.prep2019;
import java.util.*;
public class Prob1166 {
	private Map<String, Integer> map;
	public Prob1166() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
    	if (map.containsKey(path)) return false;
        int idx = path.lastIndexOf("/");
        if (idx == 0) {
        	map.put(path, value);
        	return true;
        }
        String parentPath = path.substring(0, idx);
        if (!map.containsKey(parentPath)) return false;
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}
