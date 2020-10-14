package comp.prep2019.less1000;
import java.util.*;
public class Prob218 {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<>();
	    if (buildings == null || buildings.length < 1) return result;
	    int n = buildings.length;
	    // maintains an array of each building's start and ends x-coordinate 
	    //and heights. 1st element x co-ord, 2nd element height, 3rd-start(1), end(0)
	    int[][] arr = new int[n * 2][3];
	    for (int i = 0; i < n; i++) {
	    	arr[2 * i][0] = buildings[i][0];
	    	arr[2 * i][1] = buildings[i][2];
	    	arr[2 * i][2] = 1;
	    	arr[2 * i + 1][0] = buildings[i][1];
	    	arr[2 * i + 1][1] = buildings[i][2];
	    	arr[2 * i + 1][2] = 0;
	    }
	    Arrays.sort(arr, (x, y) -> x[0] == y[0] ? (x[2] == y[2] ? (x[2] == 1 ? 
	    		(y[1] - x[1]) : (x[1] - y[1])) 
	    		: (y[2] - x[2])) 
	    		: x[0] - y[0]);
	    // maintains height as key and freq as value
	    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	    treeMap.put(0, 1);
	    int maxVal = 0;
	    for (int[] elem : arr) {
	    	if (elem[2] == 1) {
	    		treeMap.put(elem[1], treeMap.getOrDefault(elem[1], 0) + 1);
	    	} else {
	    		treeMap.put(elem[1], treeMap.get(elem[1]) - 1);
	    		if (treeMap.get(elem[1]) == 0) treeMap.remove(elem[1]);
	    	}
	    	int last = treeMap.lastKey();
	    	if (last != maxVal) result.add(Arrays.asList(elem[0], last));
	    	maxVal = last;
	    }
	    return result;
    }
}
