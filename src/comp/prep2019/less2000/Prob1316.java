package comp.prep2019.less2000;
import java.util.*;
public class Prob1316 {
	public int distinctEchoSubstrings(String text) {
		int n = text.length();
        if (n < 2) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= n / 2; i++) {
        	String s1 = text.substring(0, i), 
        			s2 = text.substring(i, 2 * i);
        	if (s1.equals(s2)) set.add(s1);
        	for (int j = 1; j + 2 * i <= n; j++) {
        		s1 = (s1 + text.charAt(j + i - 1)).substring(1);
        		s2 = s2 + text.charAt(j + 2 * i - 1); 
        		s2 = s2.substring(1);
        		if (s1.equals(s2)) set.add(s1);
        	}
        }
        return set.size();
    }
	
	public static void main(String[] args) {
		Prob1316 prob = new Prob1316();
		System.out.println(prob.distinctEchoSubstrings("abcabcabc"));
		System.out.println(prob.distinctEchoSubstrings("leetcodeleetcode"));
	}
}
