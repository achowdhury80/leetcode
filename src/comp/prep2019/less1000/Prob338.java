package comp.prep2019.less1000;

public class Prob338 {
	/**
	 * O(N) time & space
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num < 1) return result;
        result[1] = 1;
        int cur = 1;
        for (int i = 2; i <= num; i++) {
        	if (cur * 2 == i) {
        		result[i] = 1;
        		cur *= 2;
        	} else {
        		result[i] = 1 + result[i - cur];
        	}
        }
        return result;
    }
}
