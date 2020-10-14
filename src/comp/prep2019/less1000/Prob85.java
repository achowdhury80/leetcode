package comp.prep2019.less1000;
import java.util.*;
public class Prob85 {
	/**
	 * O(M*N) and O(N) space
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
        int m, n;
        if (matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1)
        	return 0;
        int[] heights = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '1') heights[j]++;
        		else heights[j] = 0;
        	}
            result = Math.max(result, maximalRentangleHistogram(heights));
        }
        return result;
    }
	
	/**
	 * O(N)
	 * finds max area for a histogram
	 * 
	 * maintain an stack of non-decreasing heights
	 * if new height is not less than height of stack peek index, add the new index
	 * to stack. increment i
	 * otherwise, if stack is non empty, poll the stack top value
	 * that is the height which starts from stack.peek index(exclusive) + 1 till 
	 * current index(i)(exclusixe)
	 * @param heights
	 * @return
	 */
	private int maximalRentangleHistogram(int[] heights) {
		Deque<Integer> dq = new ArrayDeque<>();
		int result = 0, i = 0;
		while(i <= heights.length) {
			int cur = i == heights.length ? 0 : heights[i];
			if (dq.isEmpty() || cur >= heights[dq.peekLast()]) dq.addLast(i++);
			else {
				int tp = dq.pollLast();
				result = Math.max(result, heights[tp] * (dq.isEmpty() ? i 
						: (i - dq.peekLast() - 1)));
			}
		}
		return result;
	}
}
