package comp.prep2019;

public class Prob758 {
	/**
	 * O(N) time and space
	 * keep a boolean array to keep track of the characters to be made bold
	 * for each word, mark all the positions of chars to be made bold
	 * @param words
	 * @param S
	 * @return
	 */
	public String boldWords(String[] words, String S) {
        boolean[] arr = new boolean[S.length()];
        for (String w : words) {
        	int start = 0, idx;
        	while(start < S.length() && (idx = S.indexOf(w, start)) > -1) {
        		start = idx + 1;
        		for (int j = 0; j < w.length(); j++) arr[idx + j] = true;
        	}
        }
        StringBuilder sb = new StringBuilder();
        boolean boldStarted = false;
        for (int i = 0; i < S.length(); i++) {
        	if (arr[i]) {
        		if (!boldStarted) {
        			boldStarted = true;
        			sb.append("<b>");
        		}
        	} else {
        		if (boldStarted) {
        			boldStarted = false;
        			sb.append("</b>");
        		}
        	}
        	sb.append(S.charAt(i));
        }
        if (boldStarted) sb.append("</b>");
        return sb.toString();
    }
}
