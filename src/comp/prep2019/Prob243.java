package comp.prep2019;

public class Prob243 {
	public int shortestDistance(String[] words, String word1, String word2) {
        int w1Idx = -1, w2Idx = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
        	if (word1.equals(words[i])) {
        		w1Idx = i;
        		if (w2Idx != -1) result = Math.min(result, Math.abs(w1Idx - w2Idx));
        	} else if (word2.equals(words[i])) {
        		w2Idx = i;
        		if (w1Idx != -1) result = Math.min(result, Math.abs(w1Idx - w2Idx));
        	}
        }
        return result;
    }
}
