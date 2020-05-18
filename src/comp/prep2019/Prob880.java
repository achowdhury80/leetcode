package comp.prep2019;

public class Prob880 {
	public String decodeAtIndex(String S, int K) {
        int start = 0, end = -1;
        long count = 0;
        for (int i = 1; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (Character.isDigit(c)) {
        		if (end == -1) end = i - 1;
        		count = count * 10 + (c - '0');
        	} else {
        		if (end > -1) {
        			int len = (end - start + 1);
        			long total = len * count;
        			if (total < K) {
        				K -= total;  
        			}
        			else {
        				int idx = K % len;
        				return S.substring(start, end + 1);
        			}
        			start = i;
        			end = -1;
        		}
        		count = 0;
        	}
        }
        return "";
    }
}
