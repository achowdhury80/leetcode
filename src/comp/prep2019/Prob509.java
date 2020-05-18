package comp.prep2019;

public class Prob509 {
	/**
	 * O(N) time and O(1) space
	 * @param N
	 * @return
	 */
	public int fib(int N) {
		if (N < 2) return N;
        int[] arr = new int[] {0, 1};
        for (int i = 2; i <= N; i++) {
        	int temp = arr[0] + arr[1];
        	arr[0] = arr[1];
        	arr[1] = temp;
        }
        return arr[1];
    }
}
