package comp.prep2019;

public class Prob697 {
	/**
	 * O(n) time and space
	 * @param nums
	 * @return
	 */
	public int findShortestSubArray(int[] nums) {
		/**
		 * arr[i][0] is count of i
		 * arr[i][1] is start of i
		 * arr[i][2] is end of i
		 */
        int[][] arr = new int[50000][3];
        /**
         * result[0] is the degree
         * result[1] is length
         */
        int[] result = new int[2];
        for (int j = 0; j < nums.length; j++) {
        	int i = nums[j];
        	if(arr[i][0] == 0) {
        		arr[i][1] = j;
        	} 
        	arr[i][2] = j;
        	arr[i][0]++;
        	if (result[0] < arr[i][0] || (result[0] == arr[i][0] && (arr[i][2] - arr[i][1] + 1) < result[1])) {
        		result[0] = arr[i][0];
        		result[1] = arr[i][2] - arr[i][1] + 1;
        	}
        }
        return result[1];
    }
	
	public static void main(String[] args) {
		Prob697 prob = new Prob697();
		System.out.println(prob.findShortestSubArray(new int[]{1,2,2,3,1}));
	}
}
