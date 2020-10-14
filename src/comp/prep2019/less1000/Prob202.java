package comp.prep2019.less1000;
import java.util.*;
public class Prob202 {
	public boolean isHappy(int n) {
        if (n == 1) return true;
        return isHappy(n, new HashSet<>());
    }
	
	private boolean isHappy(int n, Set<Integer> set) {
        int num = findSquareSum(n);
        if (num == 1) return true;
        if (set.contains(num)) return false;
        set.add(num);
        return isHappy(num, set);
    }
	
	private int findSquareSum(int n) {
		int result = 0;
		while(n > 0) {
			int rem = n % 10;
			result += rem * rem;
			n /= 10;
		}
		return result;
	}
}
