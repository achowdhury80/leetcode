package comp.prep2019;
import java.util.*;
public class Prob904 {
	public int totalFruit(int[] tree) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, start = 0;
        for (int i = 0; i < tree.length; i++) {
        	map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
        	count++;
        	while(map.keySet().size() > 2) {
    			map.put(tree[start], map.get(tree[start]) - 1);
    			count--;
    			if (map.get(tree[start]) == 0) {
    				map.remove(tree[start]);
    			}
    			start++;
    		}
        	result = Math.max(result, count);
        }
        return result;
    }
}
