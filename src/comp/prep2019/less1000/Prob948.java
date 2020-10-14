package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob948 {
	public int bagOfTokensScore(int[] tokens, int P) {
		if (tokens.length == 0) return 0;
        Arrays.sort(tokens);
        if (P < tokens[0]) return 0;
        return helper(tokens, P, 0, tokens.length - 1, 0);
    }
	
	private int helper(int[] tokens, int p, int start, int end, int pt) {
		if (start == end) {
			if (p >= tokens[start]) return pt + 1;
			return pt;
		}
		while (start <= end && p >= tokens[start]) {
			p -= tokens[start++];
			pt++;
		}
		if (start >= end) return pt;
		return helper(tokens, p + tokens[end], start, end - 1, pt - 1);
	}
}
