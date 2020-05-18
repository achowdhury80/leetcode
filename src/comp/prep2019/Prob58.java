package comp.prep2019;

public class Prob58 {
	public int lengthOfLastWord(String s) {
		int start = -1;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	if (c != ' ') {
        		if (start == -1) start = i;
        	}
        	if (c == ' ') {
        		if (start > -1) return start - i;
        	}
        }
        if (start > -1) return start + 1;
        return 0;
    }
}
