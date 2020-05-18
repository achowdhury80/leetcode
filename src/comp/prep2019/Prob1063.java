package comp.prep2019;
import java.util.*;
public class Prob1063 {
	/**
	 * O(N^2) time and o(N) space
	 * @param nums
	 * @return
	 */
	public int validSubarrays(int[] nums) {
        int result = 0;
        //stack maintains the index in the order of decreasing value.. topMost max and smaller next
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
        	while(!s.isEmpty() && nums[i] < nums[s.peek()]) {
        		// the subArr is from s.pop value till i - 1
        		result += i - s.pop();
        	}
        	s.push(i);
        }
        // now stack is decreasing
        while(!s.isEmpty()) {
        	result += n - s.pop();
        }
        return result;
    }
}
