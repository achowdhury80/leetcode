package comp.prep2019;

public class Prob1392 {
	public String longestPrefix(String s) {
        long h1 = 0, h2 = 0, mul = 1, mod = (int)(1e9 + 7), len = 0;
        for (int i = 0, j = s.length() - 1; j > 0; i++,j--) {
        	int first = s.charAt(i) - 'a', last = s.charAt(j) - 'a';
        	h1 = (h1 * 26 + first) % mod;
        	h2 = (h2 + mul * last) % mod;
        	mul = (mul * 26) % mod;
        	if (h1 == h2 && isEqual(s, 0, i, j)) len = i + 1;
        }
        return s.substring(0, (int)len);
    }
	
	private boolean isEqual(String s, int i, int j, int k) {
		int count = 0;
		for (int x = i; x <= j; x++) {
			if (s.charAt(x) != s.charAt(k + count)) return false;
			count++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Prob1392().longestPrefix("ababab"));
	}
}
