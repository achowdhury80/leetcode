package com.leet.algo;

public class Prob831 {
	public String maskPII(String S) {
		int i;
        if ((i = S.indexOf('@')) > -1) {
        	S = S.toLowerCase();
            String name = S.substring(0, i);
            return name.charAt(0) + "*****" + S.charAt(i - 1) + S.substring(i);
        }
        String num = "";
        for (i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (Character.isDigit(c)) num += c;
        }
        int extra = num.length() - 10;
        String result = "";
        if (extra > 0) result = "+";
        for (int j = 0; j < extra; j++) result += "*";
        if (extra > 0) result += "-";
        result += "***-***-";
        result += num.substring(num.length() - 4);
        return result;
    }
}
