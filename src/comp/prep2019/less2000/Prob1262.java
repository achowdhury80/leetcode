package comp.prep2019.less2000;
import java.util.*;
public class Prob1262 {
	public int maxSumDivThree(int[] nums) {
        int sum = 0;
        Queue<Integer>[] arr = new Queue[2];
        arr[0] = new PriorityQueue<Integer>((x, y) -> y -x);
        arr[1] = new PriorityQueue<Integer>((x, y) -> y -x);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (nums[i] % 3 == 1) {
        		arr[0].offer(nums[i]);
        		if (arr[0].size() > 2) arr[0].poll();
        	} else if (nums[i] % 3 == 2) {
        		arr[1].offer(nums[i]);
        		if (arr[1].size() > 2) arr[1].poll();
        	}
        }
        if (sum % 3 == 0) return sum;
        int case1 = Integer.MAX_VALUE, case2 = Integer.MAX_VALUE;
        if (sum % 3 == 1) {
        	if(arr[1].size() == 2) {
        		case2 = arr[1].poll() + arr[1].poll();
        	}
        	if (arr[0].size() > 0) {
        		if(arr[0].size() > 1) arr[0].poll();
        		case1 = arr[0].poll();
        	}
        	
        } else {
        	if(arr[0].size() == 2) {
        		case1 = arr[0].poll() + arr[0].poll();
        	}
        	if (arr[1].size() > 0) {
        		if(arr[1].size() > 1) arr[1].poll();
        		case2 = arr[1].poll();
        	}
        }
        
        return Math.max(sum - case1, sum - case2);
    }
	
	public static void main(String[] args) {
		Prob1262 prob = new Prob1262();
		System.out.println(prob.maxSumDivThree(new int[]{4,1,5,3,1}));
	}
}
