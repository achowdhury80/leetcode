package comp.prep2019;

import java.util.Arrays;

public class Prob1471 {
	public int[] getStrongest(int[] arr, int k) {
        if (k == arr.length) return arr;
        int[] result = new int[k];
        Arrays.sort(arr);
        int m = (arr.length - 1) / 2;
        int x = 0, y = arr.length - 1;
        for (int i = 0; i < k; i++) {
        	if (x == m) result[i] = arr[y--];
        	else if (y == m) result[i] = arr[x++];
        	else if (Math.abs(arr[y] - arr[m]) >= Math.abs(arr[x] - arr[m])) 
        		result[i] = arr[y--];
        	else result[i] = arr[x++];
        }
        return result;
    }
}
