package comp.prep2019.less2000;
import java.util.*;
public class Prob1155 {
	public int numRollsToTarget(int d, int f, int target) {
		if (d > target || d * f < target) return 0;
		int mod = (int)(1e9 + 7);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= f; i++) {
			if (i <= target) map.put(i, 1); 
		}
        for (int i = 2; i <= d; i++) {
        	Map<Integer, Integer> temp = new HashMap<>();
        	for (int j = 1; j <= f; j++) {
	        	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        		if (entry.getKey() + j + (d - i) <= target 
	        				&& entry.getKey() + j + (d - i) * f >= target) {
	        			temp.put(entry.getKey() + j, 
	        					(temp.getOrDefault(entry.getKey() + j, 0) 
	        							+ entry.getValue()) % mod);
	        		}
	        	}
        	}
        	map = temp;
        }
        return map.get(target);
    }
	
	public static void main(String[] args) {
		Prob1155 prob = new Prob1155();
		System.out.println(prob.numRollsToTarget(2, 6, 7));
		System.out.println(prob.numRollsToTarget(1, 6, 3));
	}
}
