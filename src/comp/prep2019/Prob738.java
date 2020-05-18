package comp.prep2019;

public class Prob738 {
	public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        String s = "" + N;
        String prefix = "";
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) < s.charAt(i - 1)) {
        		for (int j = 0; j < i; j++) {
        			if (s.charAt(j) > s.charAt(i)) {
        				if (j > 0) prefix = s.substring(0, j);
        				String st = helper(s.substring(j), prefix, i - j);
                		return Integer.parseInt(st);
        			}
        		}
         	}
        }
        return N;
    }
	
	private String helper(String s, String prefix, int idx) {
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		for (int i = 1; i < idx; i++) {
			if (s.charAt(i) > s.charAt(i - 1)) pos = i;
		}
		if (pos > 0) prefix += s.substring(0, pos);
		sb.append((char)(s.charAt(pos) - 1));
		for (int i = pos + 1; i < s.length(); i++) sb.append('9');
		if (!"".equals(prefix)) return prefix + sb.toString();
		while(sb.charAt(0) == '0') sb = sb.deleteCharAt(0);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Prob738 prob = new Prob738();
		System.out.println(prob.monotoneIncreasingDigits(120));
	}
}
