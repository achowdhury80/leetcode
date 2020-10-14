package comp.prep2019;

public class Prob1455 {
	public int isPrefixOfWord(String sentence, String searchWord) {
		int j = 0;
		boolean skip = false;
		int idx = 1;
        for (int i = 0; i < sentence.length(); i++) {
        	char c = sentence.charAt(i);
        	if (c == ' ') {
        		skip = false;
        		j = 0;
        		idx++;
        	} else if (!skip) {
        		if (c == searchWord.charAt(j)) {
        			j++;
        			if (j == searchWord.length()) return idx;
        		} else skip = true;
        	}
        }
        return -1;
    }
}
