package comp.prep2019;

public class Prob1446 {
	public int maxPower(String s) {
        int result = 0, count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c != last) {
        		result = Math.max(result, count);
        		count = 0;
        		last = c;
        	}
        	count++;
        }
        result = Math.max(result, count);
        return result;
    }
}
