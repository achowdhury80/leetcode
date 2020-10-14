package comp.prep2019.less2000;

public class Prob1460 {
	/**
	 * O(N) time and o(1) space
	 * @param target
	 * @param arr
	 * @return
	 */
	public boolean canBeEqual(int[] target, int[] arr) {
        int[] freq = new int[1001];
        for (int a : target) {
        	freq[a]++;
        }
        for (int a : arr) {
        	if (freq[a] > 0) freq[a]--;
        	else return false;
        }
        return true;
    }
}
