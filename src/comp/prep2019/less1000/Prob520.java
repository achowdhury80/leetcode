package comp.prep2019.less1000;

public class Prob520 {
	/**
	 * O(N)
	 * set all the cases(cap, small, firstCap true
	 * go through ech character set those flag false if needed
	 * answer should be or of the variables
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse(String word) {
        boolean cap = true, small = true, firstCapOnly = true;
        if (word.charAt(0) > 'Z') {
        	cap = false;
        	firstCapOnly = false;
        }
        for (int i = 1; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (c > 'Z') {
        		cap = false;
        	} else {
        		small = false;
        		firstCapOnly = false;
        	}
        }
        return cap || small || firstCapOnly;
    }
}
