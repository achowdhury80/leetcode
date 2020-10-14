package comp.prep2019.less2000;

public class Prob1186 {
	/**
	 * Consider the max sum of all subarrays ending at i (inclusive). t0 is the sum 
	 * with 0 deletion, t1 is with 1 deletion
	**/
	public int maximumSum(int[] arr) {
        int result = arr[0], t0 = arr[0], t1 = 0;
        for (int i = 1; i < arr.length; i++) {
        	int temp = t0;
        	t0 = arr[i] + Math.max(t0, 0);
        	t1 = Math.max(temp, arr[i] + t1);
        	result = Math.max(result, Math.max(t0, t1));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1186 prob = new Prob1186();
		System.out.println(prob.maximumSum(new int[] {1,-2,-2,3}));
	}
}
