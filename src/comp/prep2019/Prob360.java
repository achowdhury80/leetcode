package comp.prep2019;

public class Prob360 {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n;
	    if(nums == null || (n = nums.length) < 1) return new int[0];
	    int[] result = new int[n];
	    int index = (a >= 0 ? n - 1 : 0);
	    int i = 0, j = n - 1;
	    while(i <= j) {
	    	int l = quad(nums[i], a, b, c);
	    	int m = quad(nums[j], a, b, c);
	    	if (a >= 0) {
	    		result[index--] = Math.max(l, m);
	    		int k = l > m ? i++ : j--;
	    	} else {
	    		result[index++] = Math.min(l, m);
	    		int k = l < m ? i++ : j--;
	    	}
	    }
	    return result;
    }
	
	private int quad(int num, int a, int b, int c) {
		return a * num * num + b * num + c;
	}
}
