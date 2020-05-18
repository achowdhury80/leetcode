package comp.prep2019;
import java.util.*;
public class Prob368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length < 1) return new ArrayList<>();
		Arrays.sort(nums);
        List<Integer>[] dp = new List[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        dp[1] = list;
        List<Integer> result = list;
        for (int i = 1; i < nums.length; i++) {
        	list = new ArrayList<>();
        	list.add(nums[i]);
        	dp[i + 1] = list;
        	for (int j = 0; j < i; j++) {
        		if (nums[i] % nums[j] == 0) {
        			if (dp[j + 1].size() >= dp[i + 1].size()) {
	        			List<Integer> l1 = new ArrayList<>(list);
	        			l1.addAll(0, dp[j + 1]);
	        			if (l1.size() > result.size()) result = l1;
	        			dp[i + 1] = l1;
        			}
        		}
        	}
        }
        return result;
    }	
	
	public static void main(String[] args) {
		Prob368 prob = new Prob368();
		System.out.println(prob.largestDivisibleSubset(new int[] {1, 2, 3}));
	}
}
