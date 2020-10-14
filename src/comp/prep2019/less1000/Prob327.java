package comp.prep2019.less1000;
import java.util.*;
public class Prob327 {
	public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        int result = 0;
        long sum = 0;
        treeMap.put(0l, 1);
        for (int num : nums) {
        	sum += num;
        	Long lowerKey = treeMap.ceilingKey(sum - upper);
        	Long upperKey = treeMap.floorKey(sum - lower);
        	if (lowerKey != null && upperKey != null && lowerKey <= upperKey) {
        		Map<Long, Integer> sub = treeMap.subMap(lowerKey, true, 
        				upperKey, true);
        		for (Map.Entry<Long, Integer> entry : sub.entrySet()) {
        			result += entry.getValue();
        		}
        	}
        	treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
