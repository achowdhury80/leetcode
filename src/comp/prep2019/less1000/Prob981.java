package comp.prep2019.less1000;
import java.util.*;
public class Prob981 {
	/** Initialize your data structure here. */
	private Map<String, List<Pair>> map;
    public Prob981() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        Pair resultPair = null;
        while(l <= r) {
        	int mid = l + (r - l) / 2;
        	Pair pair = list.get(mid);
        	int t = pair.timestamp;
        	if (t == timestamp) return pair.value;
        	if (t > timestamp) r = mid - 1;
        	else {
        		resultPair = pair;
        		l = mid + 1;
        	}
        }
        if (resultPair != null) return resultPair.value;
        return "";
    }
    
    class Pair {
    	String value;
    	int timestamp;
    	Pair(String value, int timeStamp) {
    		this.value = value;
    		this.timestamp = timeStamp;
    	}
    }
    
    public static void main(String[] args) {
    	Prob981 prob = new Prob981();
    	prob.set("foo", "bar", 1);
    	System.out.println(prob.get("foo", 1));
    }
}
