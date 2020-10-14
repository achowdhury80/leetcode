package comp.prep2019;

public class Prob65 {
	public boolean isNumber(String s) {
        s = s.trim();
        int eId = -1;
        if ((eId = s.indexOf('e')) > 0) {
        	if (eId == s.length() - 1 || eId == 0) return false;
        	return isValidNumberWithoutE(s.substring(0, eId)) 
        			&& isValidNumberWithoutEAfter(s.substring(eId + 1, s.length()));
        } 
        return isValidNumberWithoutE(s);
    }
	
	private boolean isValidNumberWithoutE(String s) {
		if ("".equals(s)) return false;
		if (".".equals(s)) return false;
		if (s.indexOf('e') > -1) return false;
		if (!isValidChar(s)) return false;
		
		return true;
	}
	
	private boolean isValidNumberWithoutEAfter(String s) {
		if ("".equals(s)) return false;
		if (s.indexOf('.') > -1) return false;
		if (s.indexOf('e') > -1) return false;
		if (!isValidChar(s)) return false;
		
		return true;
	}
	
	private boolean isValidChar(String s) {
		int dotCount = 0, signCount = 0, numCount = 0;
		for (char c : s.toCharArray()) {
			if (c == '.') dotCount++;
			else if (c == '+' || c == '-') signCount++;
			else if (c < '0' || c > '9') return false;
			else numCount++;
		}
		if (numCount == 0) return false;
		if (signCount > 0) 
			if (s.charAt(0) != '+' && s.charAt(0) != '-') 
				return false;
			else if (s.length() == 1) return false;
		return dotCount < 2 && signCount < 2;
	}
}
