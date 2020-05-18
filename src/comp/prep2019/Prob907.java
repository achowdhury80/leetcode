package comp.prep2019;
import java.util.*;
public class Prob907 {
	public int sumSubarrayMins(int[] A) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;
        int mod = 1000000007;
        long prev = 0;
        for (int i = 0; i < A.length; i++) {
        	int count = 1;
        	while (!stack.isEmpty() && stack.peek()[0] >= A[i]) {
        		int[] node = stack.pop();
        		prev -= node[0] * node[1];
        		count += node[1];
        	}
        	stack.push(new int[] {A[i], count});
        	prev += A[i] * count;
        	result = (int)((result + prev) % mod);
        }
        return result;
    }
}
