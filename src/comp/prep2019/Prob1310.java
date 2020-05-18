package comp.prep2019;

public class Prob1310 {
	public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) xor[i] = arr[i] ^ xor[i - 1];
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	int[] q = queries[i];
        	if (q[0] == q[1]) result[i] = arr[q[0]];
        	else if (q[0] == 0) result[i] = xor[q[1]];
        	else result[i] = xor[q[1]] ^ xor[q[0] - 1];
        }
        return result;
    }
}
