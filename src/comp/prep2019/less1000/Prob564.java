package comp.prep2019.less1000;

public class Prob564 {
	public String nearestPalindromic(String n) {
		if ("1".equals(n)) return "0";
		String a = mirroring(n);
		long diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
		if (diff1 == 0) diff1 = Long.MAX_VALUE;
		StringBuilder s = new StringBuilder(n);
		int i = (s.length() - 1) / 2;
		while(i >= 0 && s.charAt(i) == '0') {
			s.replace(i, i + 1, "9");
			i--;
		}
		if (i == 0 && s.charAt(i) == '1') {
			s.delete(0, 1);
			int mid = (s.length() - 1) / 2;
			s.replace(mid, mid + 1, "9");
		} else s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1));
		String b = mirroring(s.toString());
		long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));
		s = new StringBuilder(n);
		i = (s.length() - 1) / 2;
		while(i >= 0 && s.charAt(i) == '9') {
			s.replace(i, i + 1, "0");
			i--;
		}
		if (i < 0) s.insert(0, '1');
		else s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
		String c = mirroring(s.toString());
		long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));
		if (diff2 <= diff1 && diff2 <= diff3) return b;
		if (diff1 <= diff2 && diff1 <= diff3) return a;
		return c;
	}
	
	private String mirroring(String s) {
		int n = s.length();
		String x = s.substring(0, n / 2);
		return x + (n % 2 == 1 ? "" + s.charAt(n/ 2) : "") 
				+ new StringBuilder(x).reverse().toString();
	}
}
