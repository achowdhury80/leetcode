package comp.prep2019;
import java.util.*;
public class Prob1224 {
	public int maxEqualFreq(int[] nums) {
        int[] a = new int[100001];
        Map<Integer, Integer> map = new HashMap<>();
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	if (a[num] != 0) {
        		if (map.get(a[num]) == 1) map.remove(a[num]);
        		else map.put(a[num], map.get(a[num]) - 1);
        	}
        	a[num]++;
    		map.put(a[num], map.getOrDefault(a[num], 0) + 1);
    		if (map.entrySet().size() == 1) {
    			Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
    			if (entry.getKey() == 1) {
    				result = Math.max(result, entry.getValue());
    			} else if (entry.getValue() == 1) {
    				result = Math.max(result, entry.getKey());
    			}
    		} else if (map.entrySet().size() == 2) {
    			Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet()
    					.iterator();
    			Map.Entry<Integer, Integer> entry1 = itr.next(), entry2 = itr.next();
    			if (entry1.getValue() == 1) {
    				if (entry1.getKey() == 1 
    						|| entry1.getKey() - entry2.getKey() == 1)
    					result = Math.max(result, i + 1);
    					
    			} 
    			if (entry2.getValue() == 1) {
    				if (entry2.getKey() == 1 
    						|| entry2.getKey() - entry1.getKey() == 1)
    					result = Math.max(result, i + 1);
    			}
    		}
    		
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1224 prob = new Prob1224();
		//System.out.println(prob.maxEqualFreq(new int[] {2,2,1,1,5,3,3,5}));
		System.out.println(prob.maxEqualFreq(new int[] {1,1,1,2,2,2}));
	}
}
