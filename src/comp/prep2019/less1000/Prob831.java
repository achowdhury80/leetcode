package comp.prep2019.less1000;

public class Prob831 {
	public String maskPII(String S) {
        if (S.indexOf('@') > -1) return maskEmail(S);
        return maskPhoneNumber(S);
    }
	
	private String maskEmail(String s) {
		s = s.toLowerCase();
		int idx;
		return s.charAt(0) + "*****" + s.charAt((idx = s.indexOf('@')) - 1) 
		+ s.substring(idx);
	}
	
	private String maskPhoneNumber(String s) {
		String temp = "";
		for (char c : s.toCharArray()) {
			if(Character.isDigit(c)) temp += c;
		}
		StringBuilder result = new StringBuilder();
		if (temp.length() > 10) {
			result.append('+');
			result.append("***".substring(0, temp.length() - 10));
			result.append("-");
		}
		result.append("***-***-");
		result.append(temp.substring(temp.length() - 4));
		return result.toString();
		
	}
}
