package comp.prep2019;

public class Prob844 {
	public boolean backspaceCompare(String S, String T) {
        return format(S).equals(format(T));
    }
	
	private String format(String s) {
		StringBuilder sb = new StringBuilder("");
		int bkspCount = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			if (s.charAt(i) == '#') bkspCount++;
			else {
				if (bkspCount > 0) bkspCount--;
				else sb.insert(0, s.charAt(i));
			}
		}
		return sb.toString();
	}
}
