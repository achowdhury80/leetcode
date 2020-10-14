package comp.prep2019.less1000;

public class Prob14 {
	/*
	 * O(NW) time
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs.length < 1) return "";
        int i = 0;
        StringBuilder sb = new StringBuilder("");
        while (i < strs[0].length()) {
        	String s = strs[0];
        	char c = s.charAt(i);
        	for (int j = 1; j < strs.length; j++) {
        		s = strs[j];
        		if (s.length() <= i || c != s.charAt(i)) return sb.toString();
        	}
        	i++;
        	sb.append(c);
        }
        return sb.toString();
    }
}
