package comp.prep2019.less2000;

import java.util.TreeSet;

public class Prob1099 {
	public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2) return -1;
        TreeSet<Integer> set = new TreeSet<>();
        int result = -1;
        for (int a : A) {
        	int b = K - a - 1;
        	Integer c;
        	if ((c = set.floor(b)) != null) {
        		result = Math.max(result, a + c);
        	}
        	set.add(a);
        }
        return result;
    }
}
