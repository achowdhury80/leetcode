package com.leet.algo;
import java.util.*;
public class Prob907 {
	/*
	 * Somewhat of a mix between DP and stack. The intuition required is that for any elements A[i], where i > j, and A[i] > A[j] , dp[i] = dp[j] + (i - j) * A[i].

Using a stack we can make sure that any elements we keep in the stack is monotonously increasing, and that we should pop until we reach the left-most element where A[i] < A[j]. This combines our previously stored answer in dp[j] and second part A[i] * (width of subarray where A[i] is the minimum).

In the end, we sum up all values from our dp array. Note that the conditions used to handle when stack is empty (we should use -1 as the "wall", or you can push a dummy 0 in front that works too).
	 */
	public int sumSubarrayMins(int[] A) {
        int MOD = 1000000007;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
        	while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
        	int lastSmaller = -1;
        	if (!stack.isEmpty()) lastSmaller = stack.peek();
        	dp[i] = ((lastSmaller == -1 ? 0 : dp[lastSmaller]) + (i - lastSmaller) * A[i]) % MOD;
        	stack.push(i);
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) result = (result + dp[i]) % MOD;
        return result;
    }
	
	public static void main(String[] args) {
		Prob907 prob = new Prob907();
		System.out.println(prob.sumSubarrayMins(new int[] {3, 1, 2, 4}));
	}
}
