package comp.prep2019.less1000;
import java.util.*;
public class Prob84 {
	public int largestRectangleArea1(int[] heights) {
		if (heights == null || heights.length < 1) return 0;
		int result = 0;
		Stack<Integer> stack = new Stack<>();
        int i = 0;
		while(i <= heights.length) {
			int cur = i < heights.length ? heights[i] : 0;
			if (stack.isEmpty() || cur >= heights[stack.peek()]) stack.push(i++);
			else {
				int tp = stack.pop();
				result = Math.max(result, heights[tp] * (stack.isEmpty() ? i 
						: (i - stack.peek() - 1)));
			}
		}
		return result;
    }
	
	
	public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i < heights.length ? heights[i] : 0);
            while(!dq.isEmpty() && heights[dq.peekLast()] > cur) {
                int tpx = dq.pollLast();
                result = Math.max(result, heights[tpx] * (dq.isEmpty() ? i 
                		: (i - dq.peekLast() - 1)));
            }
            dq.offerLast(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob84 prob = new Prob84();
		System.out.println(prob.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
	}
}
