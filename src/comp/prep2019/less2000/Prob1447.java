package comp.prep2019.less2000;
import java.util.*;
public class Prob1447 {
	// gcd can also be used
	public List<String> simplifiedFractions(int n) {
		List<String> result = new ArrayList<>();
		if (n < 2) return result;
		Set<Double> set = new HashSet<>();
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				double fractionVal = (j + 0.0) / i;
				if (!set.contains(fractionVal)) {
					set.add(fractionVal);
					result.add(j + "/" + i);
				}
			}
		}
		return result;
    }
}
