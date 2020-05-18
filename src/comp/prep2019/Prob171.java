package comp.prep2019;

public class Prob171 {
	public int titleToNumber(String s) {
        int mult = 1;
        int result = 0;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	result += mult * (c - 'A' + 1);
        	mult *= 26;
        }
        return result;
    }
}
