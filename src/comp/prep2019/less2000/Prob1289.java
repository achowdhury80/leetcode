package comp.prep2019.less2000;
import java.util.*;
public class Prob1289 {
	public int minFallingPathSum(int[][] arr) {
		if (arr[0].length == 1) {
			if (arr.length == 1) return arr[0][0];
			return 0;
		}
        Queue<int[]> sumQ = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        sumQ.offer(new int[] {0, -1});
        for (int i = 0; i < arr.length; i++) {
        	int[][] curSum = new int[sumQ.size()][2];
        	int idx = 0;
        	while(!sumQ.isEmpty()) curSum[idx++] = sumQ.poll();
        	for (int j = 0; j < arr[0].length; j++) {
        		int min = Integer.MAX_VALUE;
        		for (int k = 0; k < curSum.length; k++) {
        			if (curSum[k][1] != j) {
        				min = Math.min(min, curSum[k][0] + arr[i][j]);
        			}
        		}
        		if (min != Integer.MAX_VALUE) {
        			sumQ.offer(new int[] {min, j});
    				if (sumQ.size() > 2) sumQ.poll();
    			}
        	}
        }
        while (sumQ.size() > 1) sumQ.poll();
        return sumQ.peek()[0];
    }
	
	public static void main(String[] args) {
		Prob1289 prob = new Prob1289();
		System.out.println(prob.minFallingPathSum(new int[][] {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}}));
	}
}
