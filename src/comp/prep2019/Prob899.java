package comp.prep2019;

import java.util.Arrays;

public class Prob899 {
	public String orderlyQueue(String S, int K) {
		char[] arr = S.toCharArray();
        if (K > 1) {
        	Arrays.sort(arr);
        	return new String(arr);
        }
        String s = new String(arr);
        int n = arr.length;
        String concat = s + s;
        for (int i = 1; i < n; i++) {
        	String temp = concat.substring(i, i + n);
        	if (s.compareTo(temp) > 0) s = temp;
        }
        return s;
    }
}
