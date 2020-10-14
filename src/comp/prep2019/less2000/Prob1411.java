package comp.prep2019.less2000;
import java.util.*;
public class Prob1411 {
	public int numOfWays(int n) {
		if (n < 1) return 0;
        int mod = (int)(1e9 + 7);
        Map<String, List<String>> cache = new HashMap<>();
        Map<String, Long> count = new HashMap<>();
        count.put("", 1l);
        for (int i = 0; i < n; i++) {
        	Map<String, Long> temp = new HashMap<>();
        	for (Map.Entry<String, Long> entry : count.entrySet()) {
        		List<String> list = cache.get(entry.getKey());
        		if (list == null) {
        			list = findNextState(entry.getKey());
        			cache.put(entry.getKey(), list);
        		} 
        		for (String key : list) {
        			temp.put(key, (temp.getOrDefault(key, 0l) + entry.getValue()) % mod);
        		}
        		
        	}
        	count = temp;
        }
        long result = 0;
        for (long val : count.values()) {
        	result = (result + val) % mod;
        }
        return (int) result;
    }
	
	private List<String> findNextState(String cur) {
		List<String> result = new ArrayList<>();
		if (cur.length() == 0 || cur.charAt(0) != 'R') result.add("R");
		if (cur.length() == 0 || cur.charAt(0) != 'G') result.add("G");
		if (cur.length() == 0 || cur.charAt(0) != 'B') result.add("B");
		for (int i = 1; i < 3; i++) {
			List<String> temp = new ArrayList<>();
			for (String s : result) {
				if (s.charAt(i - 1) != 'R' && (cur.length() == 0 || cur.charAt(i) != 'R')) temp.add(s + 'R');
				if (s.charAt(i - 1) != 'G' && (cur.length() == 0 || cur.charAt(i) != 'G')) temp.add(s + 'G');
				if (s.charAt(i - 1) != 'B' && (cur.length() == 0 || cur.charAt(i) != 'B')) temp.add(s + 'B');
			}
			result = temp;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob1411 prob = new Prob1411();
		System.out.println(prob.numOfWays(1));
	}
}
