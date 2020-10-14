package comp.prep2019;
import java.util.*;
public class Prob568 {
	public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length, k = days[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (flights[i][j] == 1) {
        			List<Integer> list = map.getOrDefault(j, new ArrayList<>());
        			list.add(i);
        			map.put(j, list);
        		}
        	}
        }
        int[] dp = new int[n];
        dp[0] = days[0][0];
        for (int i = 1; i < n; i++) dp[i] = -1;
        for (int i = 1; i < n; i++) {
        	if (flights[0][i] == 1) {
        		dp[i] = days[i][0];
        	}
        }
        for (int i = 1; i < k; i++) {
        	int[] temp = new int[n];
        	for (int x = 0; x < n; x++) {
            	temp[x] = -1;
            }
        	for (int j = 0; j < n; j++) {
        		if (dp[j] != -1) temp[j] = dp[j] + days[j][i];
        		if (map.get(j) != null) {
        			for (int c : map.get(j)) {
        				if (dp[c] != -1) temp[j] = Math.max(temp[j], days[j][i] + dp[c]);
        			}
        		}
        	}
        	dp = temp;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) result = Math.max(result, dp[i]);
        return result;
    }
	
	public static void main(String[] args) {
		Prob568 prob = new Prob568();
		System.out.println(prob.maxVacationDays(new int[][]{{0,1,1},{1,0,1},{1,1,0}},
		new int[][]{{1,3,1},{6,0,3},{3,3,3}}));
		
		System.out.println(prob.maxVacationDays(new int[][]{{0,1,0},{0,0,0},{0,0,0}},
				new int[][]{{0,0,7},{2,7,7},{7,7,7}}));
	}
}
