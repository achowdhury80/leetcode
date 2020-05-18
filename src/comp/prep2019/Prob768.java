package comp.prep2019;

import java.util.Arrays;
import java.util.*;
public class Prob768 {
	/**
	 * O(n) space and time
	 * get a clone and sort it
	 * travel i = 0 to arr.length
	 * maintain a map(element to count) where actual element increases the count
	 * and clone element decreases the count
	 * if for an element, if count is zero remove the element
	 * if at any i, map size is zero, increment result
	 * @param arr
	 * @return
	 */
	public int maxChunksToSorted(int[] arr) {
	    int[] clone = Arrays.copyOf(arr, arr.length);
	    Arrays.sort(clone);
	    Map<Integer, Integer> count = new HashMap<>();
	    int result = 0;
	    for (int i = 0; i < arr.length; i++) {
	    	count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
	    	count.put(clone[i], count.getOrDefault(clone[i], 0) - 1);
	    	if (count.get(arr[i]) == 0) count.remove(arr[i]);
	    	if (count.containsKey(clone[i]) 
	    			&& count.get(clone[i]) == 0) 
	    		count.remove(clone[i]);
	    	if (count.size() == 0) result++;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Prob768 prob = new Prob768();
		System.out.println(prob.maxChunksToSorted(new int[] {1, 0, 1, 3, 2}));
	}
}
