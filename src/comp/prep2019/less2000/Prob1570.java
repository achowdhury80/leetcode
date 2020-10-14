package comp.prep2019.less2000;
import java.util.*;
public class Prob1570 {
	private Map<Integer, Integer> map;
	Prob1570(int[] nums) {
		map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(Prob1570 vec) {
    	if (this.map.size() == 0 || vec.map.size() == 0) return 0;
    	if (this.map.size() > vec.map.size()) return vec.dotProduct(this);
    	int result = 0;
        for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {
        	result += entry.getValue() * vec.map.getOrDefault(entry.getKey(), 0);
        }
        return result;
    }
}
