package comp.prep2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob688 {
	public double knightProbability(int N, int K, int r, int c) {
		if( K == 0) return 1;
	    Map<int[], List<int[]>> map = new HashMap<>();
	    double[][][] dp = new double[N][N][K + 1];
	    for (int i = 0; i < N; i++) {
	    	for (int j = 0; j < N; j++) dp[i][j][0] = 1;
	    }
	    return findProbability(dp, new int[] {r, c}, K, new HashMap<>(), N);
    }
	
	private double findProbability(double[][][] dp, int[] cur, int k, 
			Map<int[], List<int[]>> map, int N) {
		if(dp[cur[0]][cur[1]][k] != 0) return dp[cur[0]][cur[1]][k];
		List<int[]> nextMoves = findNextMoves(map, N, cur);
		double sum = 0;
		for (int[] nextMove : nextMoves) {
			sum += 0.125 * findProbability(dp, nextMove, k - 1, map, N);
		}
		dp[cur[0]][cur[1]][k] = sum;
		return sum;
	}
	
	private boolean isValidPosition(int N, int[] cur){
	    return cur[0] > - 1 && cur[0] < N && cur[1] > -1 && cur[1] < N;
	}
	
	private List<int[]> findNextMoves(Map<int[], List<int[]>> map, int N, 
			int[] cur) {
	    if(map.get(cur) != null) return map.get(cur);
	    List<int[]> list = new ArrayList<>();
	    int[] next;
	    if(isValidPosition(N, (next = new int[] {cur[0] + 2, cur[1] + 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 2, cur[1] - 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 2, cur[1] + 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 2, cur[1] - 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 1, cur[1] + 2}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 1, cur[1] - 2}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 1, cur[1] + 2})))
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 1, cur[1] - 2})))
	    	list.add(next);
	    map.put(cur, list);
	    return list;
  }
}
