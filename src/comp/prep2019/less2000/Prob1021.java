package comp.prep2019.less2000;

public class Prob1021 {
	/*
	 * O(N) & O(1)
	 * increment count for '(' and add to result if count > 1
	 * decrement count for ')' and add to result if count > 0
	 */
	public String removeOuterParentheses(String S) {
        if (S.length() < 4) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
        	if (c == '(') {
        		count++;
        		if (count > 1) sb.append("(");
        	}
        	else {
        		count--;
        		if (count > 0) sb.append(")");
        	}
        }
        return sb.toString();
    }
}
