package comp.prep2019;
import java.util.*;
public class Prob1425 {
	public int constrainedSubsetSum(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
        	nums[i] += dq.isEmpty() ? 0 : dq.peek();
        	result = Math.max(result, nums[i]);
        	while(!dq.isEmpty() && nums[i] >= dq.peekLast()) dq.pollLast();
        	if (nums[i] > 0) dq.offer(nums[i]);
        	if (i - k >= 0 && !dq.isEmpty() && dq.peek() == nums[i - k]) dq.poll();
        }
        return result;
    }
}
