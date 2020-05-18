package com.leet.algo;

public class Prob984 {
	public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 && B > 0) {
        	if (A > B) {
        		sb.append("aa");
        		sb.append("b");
        		A -= 2;
        		B -= 1;
        	} else if (B > A) {
        		sb.append("bb");
        		sb.append("a");
        		A -= 1;
        		B -= 2;
        	} else {
        		String str = "ab";
        		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a') str = "ba";
        		sb.append(str);
        		A--;
        		B--;
        	}
        }
        for (int i = 0; i < A; i++) sb.append("a");
        for (int i = 0; i < B; i++) sb.append("b");
        return sb.toString();
    }
}
