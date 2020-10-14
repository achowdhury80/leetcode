package comp.prep2019.less1000;
import java.util.*;
public class Prob456 {
	public boolean find132pattern(int[] nums) {
	    if(nums == null || nums.length < 3) return false;
	    int s3 = Integer.MIN_VALUE;
	    Stack<Integer> stack = new Stack<>();
	    for (int i = nums.length - 1; i > -1; i--){
	      if(s3 > nums[i] && !stack.isEmpty()) return true;
	      else while(!stack.isEmpty() && nums[i] > stack.peek()){
	        s3 = stack.peek();
	        stack.pop();
	      }
	      stack.push(nums[i]);
	    }
	    return false;
	  }
	
	public static void main(String[] args) {
		Prob456 prob = new Prob456();
		System.out.println(prob.find132pattern(new int[] {-1, 3, 2, 0}));
	}
}
