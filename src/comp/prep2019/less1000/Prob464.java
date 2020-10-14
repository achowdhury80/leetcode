package comp.prep2019.less1000;
import java.util.*;
public class Prob464 {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) 
        	return false;
        return helper(maxChoosableInteger, 0, 0, desiredTotal, new HashMap<>());
    }
	
	private boolean helper(int maxChoosableInteger, int chosenSoFar, int sum,
			int desiredTotal, Map<Integer, Boolean> cache) {
		if (cache.containsKey(chosenSoFar)) return cache.get(chosenSoFar);
		for (int i = 1; i <= maxChoosableInteger; i++) {
			if ((chosenSoFar & (1 << i)) > 0) continue;
			sum += i;
			if (sum >= desiredTotal) {
				cache.put(chosenSoFar, true);
				return true;
			}
			if (!helper(maxChoosableInteger, chosenSoFar ^ (1 << i), sum, 
					desiredTotal, cache)) {
				cache.put(chosenSoFar, true);
				return true;
			}
			sum -= i;
		}
		cache.put(chosenSoFar, false);
		return false;
	}
	
	public static void main(String[] args) {
		Prob464 prob = new Prob464();
		System.out.println(prob.canIWin(10, 11));
	}
}
