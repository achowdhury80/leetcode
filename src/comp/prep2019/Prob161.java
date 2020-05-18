package comp.prep2019;

public class Prob161 {
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        boolean replace = s.length() == t.length();
        boolean insert = false;
        if (s.length() < t.length()) insert = true;
        boolean changed = false;
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); i++, j++) {
        	if (s.charAt(i) != t.charAt(j)) {
        		if(changed) return false;
        		changed = true;
        		if (!replace && insert) i--;
        		else if(!replace && !insert) j--;
        	}
        }
        if (changed && (i != s.length() && j != t.length())) return false;
        if (!changed) {
        	if (i == s.length() && j == t.length()) return false;
            changed = true;
        }
        return changed;
    }
}
