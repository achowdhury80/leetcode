package comp.prep2019.less2000;
import java.util.*;
public class Prob1248 {
	public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> oddPosition = new LinkedList<>();
        int start = 0, count = 0, last = -1, result = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] % 2 == 1) {
        		count++;
        		if (count > k) {
	        		int first = oddPosition.peek();
	        		int leftCount = first - start + 1;
	        		int rightCount = i - 1 - last + 1;
	        		result += leftCount * rightCount;
	        		start = oddPosition.poll() + 1;
	        		count--;
        		}
        		oddPosition.offer(i);
        		last = i;
        	}
        }
        if (count == k) {
        	int first = oddPosition.peek();
    		int leftCount = first - start + 1;
    		int rightCount = nums.length - 1 - last + 1;
    		result += leftCount * rightCount;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1248 prob = new Prob1248();
		System.out.println(prob.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
	}
}
