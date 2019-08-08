package com.leet.algo;

public class Prob879 {
	/**
	 * https://leetcode.com/problems/profitable-schemes/solution/
	 * d[k][g][v]: means:
the number of schemes by
using 1, 2, .., k plan given g persons to get more than v profits
the result will be d[K][G][P]

due to some plan's profit is 0, we need to consider 3 cases .
	 * @param G
	 * @param P
	 * @param group
	 * @param profit
	 * @return
	 */
	
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
	    int K = group.length;
	    int V = P;
	    int MOD = 1_000_000_007;

	    //  given g person,  create more the v profit  
	    int[][][] d = new int[K+1][G+1][V+1];
	    for (int k = 1; k <= K; ++k) {
	      for (int g = 1; g <= G; ++g) {
	        int need_person = group[k-1];
	        int get_value = profit[k-1];
	        for (int v = 0; v <= V; ++v) {
	          d[k][g][v] = 0;
	          // case 0, only use plan[k]
	          if (v <= get_value && g >= need_person) {
	            d[k][g][v] += 1;
	          }

	          // case 1: not use plan[k]
	          d[k][g][v] += (k < 1 ? 0 : d[k-1][g][v]) % MOD;

	          // case 2: use plan[k] and use plan before
	          if (g > need_person) {
	            d[k][g][v] += (k < 1 ? 0 : d[k - 1][g - need_person][Math.max(0, v - get_value)]) % MOD;
	          }
	          d[k][g][v] %= MOD;
	        }
	      }
	    }
	    int sum = d[K][G][P];
	    return sum;
	  }
}
