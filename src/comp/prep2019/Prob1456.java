package comp.prep2019;

public class Prob1456 {
	public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int count = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (vowels.indexOf(c) > -1) count++;
        	if (i >= k) {
        		if (vowels.indexOf(s.charAt(i - k)) > -1) count--;
        	}
        	result = Math.max(result, count);
        }
        return result;
    }
}
