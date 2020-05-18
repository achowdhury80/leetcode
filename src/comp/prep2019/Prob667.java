package comp.prep2019;

public class Prob667 {
	public int[] constructArray(int n, int k) {
        int max = n, min = 1;
        int i = 0;
        int[] result = new int[n];
        while(i < k - 1) {
        	result[i] = (i % 2 == 0 ? max-- : min++);
        	i++;
        }
        if (k % 2 == 0) {
        	while(i < n) {
        		result[i++] = min++;
        	}
        } else {
        	while(i < n) {
        		result[i++] = max--;
        	}
        }
        return result;
    }
}
