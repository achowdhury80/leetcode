package comp.prep2019.less1000;
import java.util.*;
public class Prob472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String w : words) {
        	if (canBeConcatenated(w, set)) {
        		result.add(w);
        	}
        	set.add(w);
        }
        return result;
    }

	private boolean canBeConcatenated(String w, Set<String> set) {
		if (set.isEmpty()) return false;
		boolean[] dp = new boolean[w.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= w.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j]) continue;
				if (set.contains(w.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[w.length()];
	}
}
