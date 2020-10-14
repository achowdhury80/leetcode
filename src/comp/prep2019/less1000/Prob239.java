package comp.prep2019.less1000;
import java.util.*;
public class Prob239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
        	while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
        	dq.offerLast(i);
        	if (i < k - 1) continue;
        	while(!dq.isEmpty() && i - dq.peekFirst() >= k) dq.pollFirst();
        	result[idx++] = nums[dq.peekFirst()];
        }
        return result;
    }
}
