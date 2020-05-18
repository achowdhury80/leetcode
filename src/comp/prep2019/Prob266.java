package comp.prep2019;
import java.util.*;
public class Prob266 {
	public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
        	if (set.contains(c)) set.remove(c);
        	else set.add(c);
        }
        return set.size() < 2;
    }
}
