package comp.prep2019.less2000;

public class Prob1513 {
	public int numSub(String s) {
        int start = -1, mod = (int)(1e9 + 7);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '0') start = -1;
        	else {
        		if (start == -1) {
        			start = i;
        			result = (result + 1) % mod;
        		} else {
        			result = (result + (i - start + 1)) % mod;
        		}
        	}
        }
        return result;
    }
}
