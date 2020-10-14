package comp.prep2019.less1000;
import java.util.*;
public class Prob503 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
		int max = Integer.MIN_VALUE, n = nums.length;
        int[] result = new int[n];
        if (n < 1) return result;
        int start = 0;
        for (int i = 0; i < n; i++) {
        	if (nums[i] > max) {
        		max = nums[i];
        		start = i;
        	}
        }
        result[start] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(max);
        int idx = (start - 1 + n) % n;
        while (idx != start) {
        	while(!stack.isEmpty() && stack.peek() <= nums[idx]) {
        		stack.pop();
        	}
        	if (stack.isEmpty()) result[idx] = -1;
        	else result[idx] = stack.peek();
        	stack.push(nums[idx]);
        	idx = (idx - 1 + n) % n;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob503 prob = new Prob503();
		System.out.println(prob.nextGreaterElements(new int[] {1, 2, 1}));
	}
}
