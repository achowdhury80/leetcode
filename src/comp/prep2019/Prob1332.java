package comp.prep2019;

public class Prob1332 {
	public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        boolean isPal = true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
        	if (s.charAt(i) != s.charAt(j)) {
        		isPal = false;
        		break;
        	}
        	i++;
        	j--;
        }
        return isPal ? 1 : 2;
    }
}
