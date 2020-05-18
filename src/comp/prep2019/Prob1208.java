package comp.prep2019;

public class Prob1208 {
	public int equalSubstring(String s, String t, int maxCost) {
		int n;
        if ((n = s.length()) > t.length()) s = s.substring(0, t.length());
        int start = 0, cost = 0, result = 0;
        for (int i = 0; i < n; i++) {
        	cost += Math.abs(s.charAt(i) - t.charAt(i));
        	while(cost > maxCost) {
        		cost -= Math.abs(s.charAt(start) - t.charAt(start));
        		start++;
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
