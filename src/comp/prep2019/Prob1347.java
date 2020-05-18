package comp.prep2019;

public class Prob1347 {
	public int minSteps(String s, String t) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()) {
        	charMap[c - 'a']++;
        }
        int result = 0;
        for (char c : t.toCharArray()) {
        	if (charMap[c - 'a'] > 0) charMap[c - 'a']--;
        	else {
        		result++;
        	}
        }
        return result;
    }
}
