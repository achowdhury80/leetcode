package comp.prep2019;
import java.util.*;
public class Prob503 {
	public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i > -1; i--) {
        	while(!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
        	if (!stack.isEmpty()) result[i] = stack.peek();
        	else {
        		result[i] = -1;
        		for (int j = 0; j < i; j++) {
        			if (nums[j] > nums[i]) {
        				result[i] = nums[j];
        				break;
        			}
        		}
        		
        	}
        	stack.push(nums[i]);
        }
        return result;
    }
}
