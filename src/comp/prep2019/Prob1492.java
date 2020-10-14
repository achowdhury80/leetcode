package comp.prep2019;
import java.util.*;
public class Prob1492 {
	public int kthFactor(int n, int k) {
		List<Integer> factors = new ArrayList<>();
		int idx = 0;
        for (int j = 1; j * j <= n; j++) {
        	if (n % j != 0) continue;
        	factors.add(idx++, j);
        	if (j * j != n) factors.add(idx, n / j);
        	if (idx == k) return factors.get(k - 1);
        }
        if (factors.size() < k) return -1;
        return factors.get(k - 1);
    }
}
