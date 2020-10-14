package comp.prep2019.less1000;

public class Prob161 {
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        boolean insert = true;
        if (s.length() == t.length()) insert = false;
        boolean changed = false;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
        	if (s.charAt(i) == t.charAt(j)) {
        		i++;
        		j++;
        	} else {
        		if (changed) return false;
        		changed = true;
        		if (insert) j++;
        		else {
        			i++;
        			j++;
        		}
        	}
        }
        if (insert && !changed) {
        	changed = true;
        }
        return changed;
    }
}
