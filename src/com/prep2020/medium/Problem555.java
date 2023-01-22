package com.prep2020.medium;

public class Problem555 {
	public String splitLoopedString(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
        	sb.append(findBigger(s));
        }
        String result = "";
        int lastIdx = -1;
        for (int i = 0; i < strs.length; i++) {
        	String left = sb.substring(0, lastIdx + 1);
        	String right = sb.substring(lastIdx + strs[i].length() + 1);
        	String temp = findBestBreak(strs[i], left, right);
        	if (result.equals("") || temp.compareTo(result) > 0) result = temp;
        	lastIdx += strs[i].length();
        }
        return result;
    }

	private String findBestBreak(String s, String left, String right) {
		String result = null;
		for (String st : new String[] {s, new StringBuilder(s).reverse().toString()}) {
			for (int i = 0; i < st.length(); i++) {
				String st1 = st.substring(0, i), st2 = st.substring(i);
				String temp = st2 + right + left + st1;
				if (result == null || temp.compareTo(result) > 0) {
					result = temp;
				}
			}
		}
		return result;
	}

	private String findBigger(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		return s.compareTo(rev) > 0 ? s : rev;
	}
}
