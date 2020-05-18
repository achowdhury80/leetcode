package comp.prep2019;

public class Prob1287 {
	/**
	 * O(N)
	 * find the min count
	 * if a[i] == a[i + min count - 1} return a[i]
	 * @param arr
	 * @return
	 */
	public int findSpecialInteger(int[] arr) {
		int n;
        if ((n = arr.length) < 4) return arr[0];
        int count = n % 4 == 0 ? n / 4 + 1 : (n + 3) / 4;
        for (int i = 0; i + count - 1< arr.length; i++) {
        	if (arr[i + count - 1] == arr[i]) return arr[i];
        }
        return -1;
    }
}
