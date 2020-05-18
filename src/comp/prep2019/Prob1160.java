package comp.prep2019;

public class Prob1160 {
	public int countCharacters(String[] words, String chars) {
        int[] avail = new int[26];
        for (char c : chars.toCharArray()) {
        	avail[c - 'a']++;
        }
        int result = 0;
        for (String w : words) {
        	int[] temp = new int[26];
        	boolean flag = true;
        	for (char c: w.toCharArray()) {
        		int idx = c - 'a';
        		temp[idx]++;
        		if (temp [idx] > avail[idx]) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) result += w.length();
        }
        return result;
    }
}
