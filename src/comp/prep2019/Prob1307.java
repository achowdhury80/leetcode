package comp.prep2019;
import java.util.*;
public class Prob1307 {
	public boolean isSolvable(String[] words, String result) {
        Set<Character> charSet = new HashSet<>();
        int[] charCount = new int[26];
        boolean[] nonZero = new boolean[26];
        for (String w : words) {
        	int pow = 1;
        	for (int i = w.length() - 1; i > -1; i--) {
        		char c = w.charAt(i);
        		charCount[c - 'A'] += pow;
        		pow *= 10;
        		charSet.add(c);
        	}
        	if (w.length() > 1) nonZero[w.charAt(0) - 'A'] = true;
        }
        int pow = 1;
        for (int i = result.length() - 1; i > -1; i--) {
    		char c = result.charAt(i);
    		charCount[c - 'A'] -= pow;
    		pow *= 10;
    		charSet.add(c);
    	}
        if (result.length() > 1) nonZero[result.charAt(0) - 'A'] = true;
        return helper(new boolean[10], 0, 0, new ArrayList<>(charSet), charCount, 
        		nonZero);
    }
	
	private boolean helper(boolean[] used, int step, int diff, 
			List<Character> charList, int[] charCount, boolean[] nonZero) {
		if (step == charList.size()) return diff == 0;
		char c = charList.get(step);
		for (int d = 0; d < 10; d++) {
			if (used[d] || (d == 0 && nonZero[c - 'A'])) continue;
			used[d] = true;
			if (helper(used, step + 1, diff + charCount[c - 'A'] * d, charList, 
					charCount, nonZero)) return true;
			used[d] = false;
		}
		return false;
	}
}
