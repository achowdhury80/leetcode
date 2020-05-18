package comp.prep2019;
import java.util.*;
public class Prob862 {
	public int shortestSubarray(int[] A, int K) {
        int result = Integer.MAX_VALUE;
        Deque<int[]> dq = new ArrayDeque<>();
        int runningSum = 0;
        for (int i = 0; i < A.length; i++) {
        	runningSum += A[i];
        	if (runningSum <= 0) {
        		runningSum = 0;
        		dq.clear();
        		continue;
        	}
        	if (A[i] <= 0) {
        		while(!dq.isEmpty()) {
        			int[] arr = dq.pollLast();
        			int temp = A[i];
        			A[i] += arr[0];
        			arr[0] += temp;
        			if (arr[0] > 0) {
        				dq.offer(arr);
        				break;
        			}
        		}
        		continue;
        	}
        	while(!dq.isEmpty() && runningSum - dq.peek()[0] >= K) {
        		runningSum -= dq.poll()[0];
        	}
        	dq.offer(new int[] {A[i], i});
        	if (runningSum >= K) result = Math.min(result, i - dq.peek()[1] + 1);
        	
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
	
	public static void main(String[] args) {
		Prob862 prob = new Prob862();
		System.out.println(prob.shortestSubarray(new int[] {84,-37,32,40,95}, 167));
	}
}
