package comp.prep2019.less2000;
import java.util.*;
public class Prob1508 {
	public int rangeSum(int[] nums, int n, int left, int right) {
        int[] preSum = new int[n + 1];
        Queue<int[]> q = new PriorityQueue<>((x, y) -> 
    		(preSum[x[1] + 1] - preSum[x[0]]) - (preSum[y[1] + 1] - preSum[y[0]]));
        for (int i = 0; i < nums.length; i++) {
        	preSum[i + 1] = nums[i] + preSum[i];
        	q.offer(new int[] {i, i});
        }
        long result = 0, mod = (long)(1e9 + 7);
        
        for (int i = 1; i <= right; i++) {
        	int[] arr = q.poll();
        	if (arr[1] != n - 1) {
        		q.offer(new int[] {arr[0], arr[1] + 1});
        	}
        	if (i < left) continue;
        	result = (result + preSum[arr[1] + 1] - preSum[arr[0]]) % mod;
        }
        return (int) result;
    }
}
