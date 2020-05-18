package comp.prep2019;
import java.util.*;
public class Prob139 {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i - 1; j >= -1; j--) {
        		if (dp[j + 1] == true && set.contains(s.substring(j + 1, i + 1))) {
        			dp[i + 1] = true;
        			break;
        		}
        	}
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		Prob139 prob = new Prob139();
		System.out.println(prob.wordBreak("leetcode", Arrays.asList("leet","code")));
	}
}
