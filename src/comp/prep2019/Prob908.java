package comp.prep2019;

public class Prob908 {
	public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int a : A) {
        	min = Math.min(min, a);
        	max = Math.max(max, a);
        }
        if (max - min <= 2 * K) return 0;
        return max - min - 2 * K;
    }
}
