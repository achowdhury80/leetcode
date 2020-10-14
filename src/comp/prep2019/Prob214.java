package comp.prep2019;

public class Prob214 {
	public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder reverse = new StringBuilder(s).reverse();
        for (int i = 0; i < reverse.length(); i++) {
        	if (s.startsWith(reverse.substring(i))) {
        		return reverse.substring(0, i) + s;
        	}
        }
        return "";
    }
	
	public static void main(String[] args) {
		Prob214 prob = new Prob214();
		System.out.println(prob.shortestPalindrome("aba"));
	}
}
