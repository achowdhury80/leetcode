package comp.prep2019;

public class Prob357 {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int result = 10;
        int uniq = 9, avail = 9;
        while(n-- > 1 && avail > 0) {
        	uniq = uniq * avail--;
        	result += uniq;
        }
        return result;
    }
}
