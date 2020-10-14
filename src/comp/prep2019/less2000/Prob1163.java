package comp.prep2019.less2000;
public class Prob1163 {
	public String lastSubstring(String s) {
        int i = 0, j = 1, offset = 0, n = s.length();
        while(i + offset < n && j + offset < n) {
        	char c = s.charAt(i + offset), d = s.charAt(j + offset);
        	if (c == d) offset++;
        	else {
        		if (c < d) i += offset + 1;
        		else j += offset + 1;
        		if (i == j) i++;
        		offset = 0;
        	}
        }
        return s.substring(Math.min(i, j));
    }
	
	public static void main(String[] args) {
		Prob1163 prob = new Prob1163();
		System.out.println(prob.lastSubstring("abab"));
	}
}
