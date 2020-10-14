package comp.prep2019.less2000;
import java.util.*;
public class Prob1153 {
	/**
	 * https://leetcode.com/problems/string-transforms-into-another-string/discuss/355382/JavaC%2B%2BPython-Need-One-Unused-Character
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean canConvert(String s1, String s2) {
        if (s1.equals(s2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    }
	
	public static void main(String[] args) {
		Prob1153 prob = new Prob1153();
		System.out.println(prob.canConvert("aabcc","ccdee"));
	}
}
