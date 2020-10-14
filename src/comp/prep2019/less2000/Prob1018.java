package comp.prep2019.less2000;
import java.util.*;
public class Prob1018 {
	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> result = new ArrayList<>();
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			cur <<= 1;
			cur += A[i];
			cur %= 5;
			result.add(cur == 0);
		}
		return result;
    }
}
