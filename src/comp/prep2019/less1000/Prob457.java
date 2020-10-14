package comp.prep2019.less1000;
import java.util.*;
public class Prob457 {
	/**
	 * remove all single length elements
	 * start from an index, 
	 * @param nums
	 * @return
	 */
	public boolean circularArrayLoop(int[] nums) {
		if (nums.length < 2) return false;
        boolean[] arr = new boolean[nums.length];
        // remove single length loop
        for (int i = 0; i < nums.length; i++) {
        	int next = ((i + nums[i]) % nums.length + nums.length) % nums.length;
        	if (next == i) arr[i] = true;
        }
        for (int i = 0; i < nums.length; i++) {
        	if (arr[i]) continue;
        	int cur = i;
        	boolean pos = nums[i] > 0;
        	Set<Integer> visited = new HashSet<>();
        	visited.add(cur);
        	while(true) {
        		cur = ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
        		// an element changes the direction does not mean the element can 
        		//not be part of other loop
        		if (nums[cur] > 0 != pos || arr[cur]) break;
        		// loop found
        		if (visited.contains(cur)) return true;
        		visited.add(cur);
        	}
        	for (int j : visited) arr[j] = true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Prob457 prob = new Prob457();
		System.out.println(prob.circularArrayLoop(new int[] {2, -1, 1, 2, 2}));
		System.out.println(prob.circularArrayLoop(new int[] {1, 1, 2}));
		System.out.println(prob.circularArrayLoop(new int[] {-2, -3, -9}));
	}
}
