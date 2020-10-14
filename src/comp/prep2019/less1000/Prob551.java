package comp.prep2019.less1000;

public class Prob551 {
	public boolean checkRecord(String s) {
        if (s.length() < 2) return true;
        int aCount = 0;
        char[] lastTwo = new char[] {s.charAt(0), s.charAt(1)};
        if (s.charAt(0) == 'A') aCount++;
        if (s.charAt(1) == 'A') aCount++;
        if (aCount > 1) return false;
        for (int i = 2; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == 'A' && (++aCount > 1)) return false;
        	if (c == 'L' && lastTwo[0] == 'L' && lastTwo[1] == 'L') return false;
        	lastTwo[0] = lastTwo[1];
        	lastTwo[1] = c;
        }
        return true;
    }
}
