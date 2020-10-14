package comp.prep2019;
import java.util.*;
public class Prob784 {
	/**
	 * O(N*2^N) time and space
	 * start from first char. if letter take lower and upper variation otherwise 
	 * number take only the existing one
	 * do recursive call for remaining substring
	 * merge all variations with the new list
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
	/*public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
        if ("".equals(S)) return result;
        char[] arr = S.toCharArray();
        int letterCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
        	if (Character.isLetter(arr[i])) {
        		map.put(letterCount, i);
        		letterCount++;
        	}
        	
        }
        for (int i = 0; i < Math.pow(2, letterCount); i++) {
        	StringBuilder sb = new StringBuilder(S);
        	int j = i;
        	for (int k = 0; k < letterCount; k++) {
        		int idx = map.get(k);
        		if ((i & (1 << k)) == 0) {
        			sb.replace(idx, idx + 1, "" + Character.toLowerCase(arr[idx]));
        		} else {
        			sb.replace(idx, idx + 1, "" + Character.toUpperCase(arr[idx]));
        		}
        	}
        	result.add(sb.toString());
        }
        return result;
    }*/
}
