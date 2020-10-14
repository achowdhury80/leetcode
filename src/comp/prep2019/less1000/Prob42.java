package comp.prep2019.less1000;
import java.util.*;
public class Prob42 {
	/**
	 * O(N) time and space
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
        	int curHeight = 0;
        	while(!stack.isEmpty() && height[i] >= height[stack.peek()]) {
        		int idx = stack.pop();
        		result += (i - idx - 1) * (height[idx] - curHeight);
        		curHeight = height[idx];
        	}
        	if (!stack.isEmpty()) {
        		result += (i - stack.peek() - 1) * (height[i] - curHeight);
        	}
        	stack.push(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob42 prob = new Prob42();
		System.out.println(prob.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(prob.trap(new int[] {2, 0, 2}));
	}
}
