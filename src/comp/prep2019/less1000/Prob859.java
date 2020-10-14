package comp.prep2019.less1000;

public class Prob859 {
	public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) return false;
        int diffCount = 0;
        int[] aMap = new int[26], bMap = new int[26];
        for (int i = 0; i <A.length(); i++) {
        	char a = A.charAt(i), b = B.charAt(i);
        	if (a != b) {
        		diffCount++;
        		if (diffCount > 2) return false;
        	}
        	aMap[a - 'a']++;
        	bMap[b - 'a']++;
        }
        if (diffCount == 1) return false;
        if (diffCount == 0) {
        	for (int i = 0; i < 26; i++) {
        		if (aMap[i] > 1) return true;
        	}
        	return false;
        }
        for (int i = 0; i < 26; i++) {
    		if (aMap[i] != bMap[i]) return false;
    	}
        return true;
    }
}
