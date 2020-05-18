package comp.prep2019;

public class Prob245 {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int word1Idx = -1, word2Idx = -1;
        for (int i = 0; i < words.length; i++) {
        	String w = words[i];
        	if (word1.equals(word2) && w.equals(word1)) {
        		if (word1Idx != -1) {
        			result = Math.min(result, i - word1Idx);
        		} 
        		word1Idx = i;
        	} else if (w.equals(word1)) {
        		word1Idx = i;
        		if (word2Idx != -1) result = Math.min(result, i - word2Idx);
        	} else if (w.equals(word2)) {
        		word2Idx = i;
        		if (word1Idx != -1) result = Math.min(result, i - word1Idx);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob245 prob = new Prob245();
		System.out.println(prob.shortestWordDistance(new String[] {"a","b","c","d","d"},
				"a",
				"d"));
	}
}
