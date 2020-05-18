package comp.prep2019;

public class Prob1137 {
	public int tribonacci(int n) {
        int[] arr = new int[] {0, 1, 1};
        if (n < 3) return arr[n];
        for (int i = 3; i <= n; i++) {
        	int temp = arr[0] + arr[1] + arr[2];
        	arr[0] = arr[1];
        	arr[1] = arr[2];
        	arr[2] = temp;
        }
        return arr[2];
    }
}
