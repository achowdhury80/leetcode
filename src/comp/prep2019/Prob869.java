package comp.prep2019;

public class Prob869 {
	public boolean reorderedPowerOf2(int N) {
		if (N == 0) return false;
        return helper("" + N, 0, 0);
    }
	
	private boolean helper(String s, int used, int cur) {
		if (cur != 0 && (cur + "").length() == s.length()) {
			if (cur > 0 && (cur & (cur - 1)) == 0) return true;
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(0) == '0' ||(used & (1 << i)) > 0) continue;
			if (helper(s, used | (1 << i), cur * 10 + s.charAt(i) - '0')) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Prob869 prob = new Prob869();
		System.out.println(prob.reorderedPowerOf2(46));
		System.out.println(prob.reorderedPowerOf2(10));
	}
}
