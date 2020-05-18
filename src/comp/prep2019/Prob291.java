package comp.prep2019;

public class Prob291 {
	public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() > str.length()) return false;
        return helper(pattern, str, 0, 0, new String[26]);
    }
	
	private boolean helper(String pattern, String str, 
			int pStart, int sStart, String[] map) {
		if (pStart == pattern.length() && sStart == str.length()) 
			return true;
		if (pStart == pattern.length() || sStart == str.length()) 
			return false;
		int idx = pattern.charAt(pStart) - 'a';
		if (map[idx] != null) {
			if (!str.substring(sStart).startsWith(map[idx]))
				return false;
			return helper(pattern, str, pStart + 1, 
					sStart + map[idx].length(), map);
		}
		for (int j = sStart; j < str.length(); j++) {
			String w = str.substring(sStart, j + 1);
			boolean isAlreadyTaken = false;
			for (int k = 0; k < 26; k++) {
				if (w.equals(map[k])) isAlreadyTaken = true;
			}
			if (isAlreadyTaken) continue;
			map[idx] = w;
			if (helper(pattern, str, pStart + 1, j + 1, map)) return true;
			map[idx] = null;
		}
		return false;
	}
	
	public static void main(String[] args) {
	    Prob291 prob291 = new Prob291();
	    System.out.println(prob291.wordPatternMatch("eecs",
	    		"electronicengineeringcomputerscience"));
	  }
}
