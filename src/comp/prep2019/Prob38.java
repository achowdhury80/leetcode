package comp.prep2019;

public class Prob38 {
	public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        for (int i = 2; i <= n; i++) {
        	s = say(s);
        }
        return s;
    }
	
	private String say(String s) {
		int count = 0;
		char ch = '\0';
		String result = "";
		for (char c : s.toCharArray()) {
			if (ch == '\0') {
				ch = c;
				count = 1;
			}
			else if (ch == c) count++;
			else {
				result += "" + count + ch;
				ch = c;
				count = 1;
			}
		}
		result += "" + count + ch;
		return result;
	}
	
	public static void main(String[] s) {
		Prob38 prob = new Prob38();
		System.out.println(prob.countAndSay(4));
	}
}
