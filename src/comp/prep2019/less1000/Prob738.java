package comp.prep2019.less1000;

public class Prob738 {
	public int monotoneIncreasingDigits(int N) {
		if (N < 10) return N;
        String s = "" + N;
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) < s.charAt(i - 1)) {
        		int start = i - 1;
        		for (int j = i - 2; j > -1; j--) {
        			if (s.charAt(j) != s.charAt(i - 1)) break;
        			start = j;
        		}
        		String prefix = s.substring(0, start);
        		String retVal = helper(s, start);
        		return Integer.parseInt(prefix + retVal);
        	}
        }
        return N;
    }
	
	private String helper(String s, int start) {
		int lenOf9 = s.length() - start - 1;
		String nines = "";
		for (int i = 0; i < lenOf9; i++) nines += "9";
		if (start == 0 && s.charAt(start) == '0') return nines;
		return "" + (char)((int)s.charAt(start) - 1) + nines;
		
	}
	
	public static void main(String[] args) {
		Prob738 prob = new Prob738();
		//System.out.println(prob.monotoneIncreasingDigits(332));
		System.out.println(prob.monotoneIncreasingDigits(120));
	}
}
