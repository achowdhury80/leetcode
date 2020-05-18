package comp.prep2019;
import java.util.*;
public class Prob17 {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() < 1) return result;
        String[] arr = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int num = digits.charAt(0) - '0';
        for (char c : arr[num - 2].toCharArray()) {
        	result.add("" + c);
        }
        for (int i = 1; i < digits.length(); i++) {
        	num = digits.charAt(i) - '0';
        	List<String> temp = new ArrayList<>();
        	for (char c : arr[num - 2].toCharArray()) {
        		for (String s : result) {
        			temp.add(s + c);
        		}
        	}
        	result = temp;
        }
        return result;
    }
}
