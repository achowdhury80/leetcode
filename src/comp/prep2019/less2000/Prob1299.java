package comp.prep2019.less2000;

public class Prob1299 {
	/**
	 * O(N)
	 * set last element to -1
	 * start from second last. keep track of greatest element
	 * @param arr
	 * @return
	 */
	public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 2; i > -1; i--) {
        	result[i] = last;
        	if (last < arr[i]) last = arr[i];
        }
        return result;
    }
}
