package comp.prep2019;

public class Prob1055 {
	public int shortestWay(String source, String target) {
        int[] dp = new int[target.length() + 1];
        dp[0] = -1;
        char[] arr = target.toCharArray();
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	boolean found = false;
        	for (int j = dp[i] + 1; j < source.length(); j++) {
        		if (arr[i] == source.charAt(j)) {
        			dp[i + 1] = j;
        			found = true;
        			break;
        		}
        	}
        	if (!found) {
        		for (int j = 0; j <= dp[i]; j++) {
        			if (arr[i] == source.charAt(j)) {
        				dp[i + 1] = j;
        				result++;
        				found = true;
        				break;
        			}
        		}
        	}
        	if (!found) return -1;
        	
        }
        return result;
    }
}
