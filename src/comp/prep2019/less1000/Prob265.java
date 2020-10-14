package comp.prep2019.less1000;
import java.util.*;
public class Prob265 {
	public int minCostII(int[][] costs) {
		if (costs.length < 1 || costs[0].length < 1) return 0;
        int[] dp = new int[costs[0].length];
        //int[] - 1st is index and second is cost
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1]- x[1]);
        for (int i = 0; i < costs[0].length; i++) {
        	dp[i] = costs[0][i];
        	q.offer(new int[] {i, costs[0][i]});
        	if (q.size() > 2) q.poll();
        }
        for (int i = 1; i < costs.length; i++) {
        	int[] temp = new int[costs[0].length];
        	Queue<int[]> tempQ = new PriorityQueue<>((x, y) -> y[1]- x[1]);
        	for (int j = 0; j < costs[0].length; j++) {
        		int cost = costs[i][j];
        		int[] arr = q.poll();
        		if (q.peek()[0] == j) cost += arr[1];
        		else cost += q.peek()[1];
        		q.offer(arr);
        		temp[j] = cost;
        		tempQ.offer(new int[] {j, cost});
        		if(tempQ.size() > 2) tempQ.poll();
        	}
        	dp = temp;
        	q = tempQ;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) result = Math.min(result, dp[i]);
        return result;
    }
	
	public static void main(String[] args) {
		Prob265 prob = new Prob265();
		//System.out.println(prob.minCostII(new int[][] {{1, 5, 3},{2, 9, 4}}));
		System.out.println(prob.minCostII(new int[][] {{15,17,15,20,7,16,6,10,4,20,7,3,4},{11,3,9,13,7,12,6,7,5,1,7,18,9}}));
	}
}
