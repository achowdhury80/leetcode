package comp.prep2019.less1000;
import java.util.*;
public class Prob318 {
	public int maxProduct(String[] words) {
		// ith cell contains charMap of Ith word
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
        	String w = words[i];
        	int charMap = findCharMap(w);
        	arr[i] = charMap;
        }
        int result = 0;
        // find max length product where two words charMap AND is 0
        for (int i = 0; i < arr.length - 1; i++) {
        	for (int j = i + 1; j < arr.length; j++) {
        		if ((arr[i] & arr[j]) == 0) {
        			result = Math.max(result, words[i].length() * words[j].length());
        		}
        	}
        }
        return result;
    }
	
	/**
	 * returns char map
	 * if a is present, set 0th bit to 1;
	 * if b is present, set 1st bit to 1, so on..
	 * @param word
	 * @return
	 */
	private int findCharMap(String word) {
		int result = 0;
		for (char c : word.toCharArray()) {
			int bit = c - 'a';
			if (((result >> bit) & 1) == 0) result ^= (1 << bit);
		}
		return result;
	}
}
