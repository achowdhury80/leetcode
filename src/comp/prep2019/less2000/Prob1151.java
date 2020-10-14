package comp.prep2019.less2000;

public class Prob1151 {
	/**
	 * find number of 1's (say n)
	 * start a sliding window of n
	 * count no of zeros in that window
	 * find the min
	 * @param data
	 * @return
	 */
	public int minSwaps(int[] data) {
        int n = 0;
        for (int i : data) {
        	if (i == 1) n++;
        }
        if (n == 1) return 0;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
        	if (data[i] == 0) zeroCount++;
        }
        int result = zeroCount;
        for (int i = n; i < data.length; i++) {
        	if (data[i] == 0) zeroCount++;
        	if (data[i - n] == 0) zeroCount--;
        	result = Math.min(result, zeroCount);
        }
        return result;
    }
}
