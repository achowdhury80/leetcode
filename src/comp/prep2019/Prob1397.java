package comp.prep2019;

public class Prob1397 {
	public int findGoodStrings(int n, String s1, String s2, String evil) {
		long mod = (long)(1e9 + 7);
        long result = findNumberOfStrings(s1, s2, mod);
        return (int)result;
    }
	
	private long findNumberOfStrings(String s1, String s2, long mod) {
		if (s1.equals(s2)) return 1;
		long result = 0;
		int i = 0;
		while(s1.charAt(i) == s2.charAt(i)) i++;
		if (i != 0) return findNumberOfStrings(s1.substring(i), s2.substring(i), mod);
		int len = s1.length();
		int betwn = s2.charAt(0) - s1.charAt(0) - 1;
		if (betwn > 0) {
			long perm = betwn;
			for (int j = 0; j < len - 1; j++) {
				perm = (perm * 26) % mod;
			}
			result = (result + perm) % mod;
		}
		String temp = "" + s1.charAt(0);
		for (int j = 1; j < len; j++) {
			temp += 'z';
		}
		result = (result + findNumberOfStrings(s1, temp, mod)) % mod;
		temp = "" + s2.charAt(0);
		for (int j = 1; j < len; j++) {
			temp += 'a';
		}
		result = (result + findNumberOfStrings(temp, s2, mod)) % mod;
		return result;
	}
	
	private long findNumberOfEvil(String s1, String s2, String evil, long mod) {
		if (s1.length() < evil.length()) return 0;
		if (s1.equals(s2)) return s1.indexOf(evil) > -1 ? 1 : 0;
		if (s1.indexOf(evil) == 0 && s2.indexOf(evil) == 0) {
			return findNumberOfStrings(s1.substring(evil.length()), 
					s2.substring(evil.length()), mod);
		}
		if (s1.compareTo(evil) >= 0 && s2.compareTo(evil) <= 0) {
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Prob1397 prob = new Prob1397();
		System.out.println(prob.findGoodStrings(2, "ac", "cb", "b"));
	}
}
