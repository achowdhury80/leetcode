package comp.prep2019;
import java.util.*;
public class Prob784 {
	/**
	 * O(N) time and space
	 * start from first char. if letter take lower and upper variation otherwise 
	 * number take only the existing one
	 * do recursive call for remaining substring
	 * merge all variatio with the new list
	 * @param S
	 * @return
	 */
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
        if ("".equals(S)) return result;
        char c = S.charAt(0);
        List<String> l = letterCasePermutation(S.substring(1));
        char[] arr;
        if (Character.isLetter(c)) {
        	arr = new char[] {Character.toLowerCase(c), Character.toUpperCase(c)};
        } else {
        	arr = new char[] {c};
        }
        if (!l.isEmpty()) {
	        for (String str : l) {
		        for (char ch : arr) result.add(ch + str);
	        }
        } else {
        	for (char ch : arr) result.add(ch + "");
        }
        return result;
    }
}
