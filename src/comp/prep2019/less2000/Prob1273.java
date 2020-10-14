package comp.prep2019.less2000;
import java.util.*;
public class Prob1273 {
	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int root = -1;
        for (int i = 0; i < nodes; i++) {
        	int p = parent[i];
        	List<Integer> list = map.getOrDefault(p, new ArrayList<>());
        	list.add(i);
        	map.put(p, list);
        	if (p == -1) root = i;
        }
        int[] result = new int[] {nodes};
        helper(map, value, result, root);
        return result[0];
        
    }
	
	private int[] helper(Map<Integer, List<Integer>> map, int[] value, int[] result, int parent) {
		if (!map.containsKey(parent)) {
			if (value[parent] == 0) result[0]--;
			return new int[] {value[parent], 1};
		}
		int sum = 0, count = 0;
		for (int child : map.get(parent)) {
			int[] subTreeVal = null;
			if ((subTreeVal = helper(map, value, result, child))[0] != 0) {
				sum += subTreeVal[0];
				count += subTreeVal[1];
			}
		}
		sum += value[parent];
		count++;
		if(sum == 0) result[0] -= count;
		return new int[] {sum, count};
	}
}
