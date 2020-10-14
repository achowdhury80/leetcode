package comp.prep2019.less1000;

public class Prob410 {
	public int splitArray(int[] nums, int m) {
        long low = 0;
        long high = 0;        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
        	high += nums[i];
        	if (low < nums[i]) {
                low = nums[i];
            }
        }
        long result = high;
        while (low <= high) {
            long mid =  low + (high - low) / 2;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
            	result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) result;      
    }
	
	public static void main(String[] args) {
		Prob410 prob = new Prob410();
		System.out.println(prob.splitArray(new int[] {7, 2, 5, 10, 8}, 2));
		System.out.println(prob.splitArray(new int[] {1,2147483647}, 2));
	}
}
