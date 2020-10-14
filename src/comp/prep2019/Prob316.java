package comp.prep2019;

public class Prob316 {
	public String removeDuplicateLetters(String s) {
        boolean[] used = new boolean[26];
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) freq[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
        	int idx = c - 'a';
        	if (used[idx]) {
        		freq[idx]--;
        		continue;
        	}
        	int last = sb.length() - 1;
        	char ch;
        	while(last > -1 && (ch = sb.charAt(last)) > c && freq[ch - 'a'] > 0) {
        		sb.deleteCharAt(last);
        		used[ch - 'a'] = false;
        		last--;
        	}
        	used[idx] = true;
        	freq[idx]--;
        	sb.append(c);
        }
        return sb.toString();
    }
}
