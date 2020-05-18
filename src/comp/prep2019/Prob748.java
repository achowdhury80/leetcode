package comp.prep2019;

import java.util.Arrays;

public class Prob748 {
	/**
	 * n = words.length
	 * O(nLogn) & o(1) space
	 * find charMap for LicensePlate => arr
	 * sort words by length. If length same then their order should be maintained
	 * now check the first word thats satisfies arr
	 * @param licensePlate
	 * @param words
	 * @return
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr = new int[26];
        for (char c : licensePlate.toCharArray()) {
        	if (Character.isLetter(c)) {
        		arr[Character.toLowerCase(c) - 'a']++;
        	}
        }
        Arrays.sort(words, (x, y)-> x.length() - y.length());
        for (String w : words) {
        	int[] wArr = new int[26];
        	for (char c : w.toCharArray()) {
        		wArr[c - 'a']++;
        	}
        	boolean flag = true;
        	for (int i = 0; i < 26; i++) {
        		if (wArr[i] < arr[i]) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) return w;
        }
        return "";
    }
}
