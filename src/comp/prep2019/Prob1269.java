package comp.prep2019;
import java.util.*;
public class Prob1269 {
	public int numWays(int steps, int arrLen) {
        int mod = (int)(1e9 + 7);
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1l);
        for (int i = 1; i <= steps; i++) {
        	Map<Integer, Long> temp = new HashMap<>();
        	for (int j = -1; j < 2; j++) {
        		for (Map.Entry<Integer, Long> entry : map.entrySet()) {
        			int newKey = entry.getKey() + j;
        			if (newKey < arrLen && newKey > - 1 
        					&& Math.abs(newKey) <= steps - i) {
        				temp.put(newKey, 
        						(temp.getOrDefault(newKey, 0l) 
        								+ entry.getValue()) % mod);
        			}
        		}
        	}
        	map = temp;
        }
        return map.get(0).intValue();
    }
	
	public static void main(String[] args) {
		Prob1269 prob = new Prob1269();
		System.out.println(prob.numWays(3, 2));
	}
}
