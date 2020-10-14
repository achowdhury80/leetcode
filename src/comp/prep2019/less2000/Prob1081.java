package comp.prep2019.less2000;

public class Prob1081 {
	public String smallestSubsequence(String text) {
        int n = text.length();
        char[] arr = text.toCharArray();
        boolean[] used = new boolean[26];
        int[] freq = new int[26];
        for (char c : arr) freq[c - 'a']++;
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
        	if (used[c - 'a']) {
        		freq[c - 'a']--;
        		continue;
        	}
        	int last = result.length() - 1;
        	char ch;
        	while(last > -1 && (ch = result.charAt(last)) > c && freq[ch - 'a'] > 0) {
        		result.deleteCharAt(last);
        		last--;
        		used[ch - 'a'] = false;
        	}
        	used[c - 'a'] = true;
        	freq[c - 'a']--;
        	result.append(c);
        }
        return result.toString();
    }
}
