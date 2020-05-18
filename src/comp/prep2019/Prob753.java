package comp.prep2019;

import java.util.HashSet;
import java.util.Set;

public class Prob753 {
	 /**
		 * https://leetcode.com/problems/cracking-the-safe/discuss/314906/Java-DFS-not-a-fast-solution-but-easy-to-understand.-With-explanation.
		 * 
		 * @param n
		 * @param k
		 * @return
		 */
		public String crackSafe(int n, int k) {
			int total = 1;
	        String res = "";
	        /*
	         * total variation = k^n
	         * in the result string, first one use n chars, then later ones uses
	         * previous n-1 char plus one new char
	         * so total should be n + (k^n - 1)
	         * computing total
	         */
	        for (int i = 0; i < n; i++) {
	        	total *= k;
	        	res += "0";
	        }
	        total += n - 1;
	        Set<String> visited = new HashSet<>();
	        visited.add(res);
	        return dfs(n, k, res, visited, total);
		}

		private String dfs(int n, int k, String res, Set<String> visited, int total) {
			// TODO Auto-generated method stub
			String next = res.substring(res.length() - n + 1);
			for (int i = 0; i < k; i++) {
				next += i;
				if (!visited.contains(next)) {
					visited.add(next);
					String temp = dfs(n, k, res + i, visited, total);
					if (temp.length() == total) return temp;
					visited.remove(next);
				}
				next = next.substring(0, next.length() - 1);
			}
			return res;
		}
}
