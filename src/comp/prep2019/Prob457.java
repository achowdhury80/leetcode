package comp.prep2019;
import java.util.*;
public class Prob457 {
	public boolean circularArrayLoop(int[] nums) {
		if (nums.length < 2) return false;
        boolean[] arr = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	if (arr[i]) continue;
        	int cur = i;
        	boolean pos = nums[i] > 0;
        	Set<Integer> visited = new HashSet<>();
        	visited.add(cur);
        	int len = 1;
        	while(true) {
        		cur = ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
        		if (nums[cur] > 0 != pos || arr[cur]) break;
        		if (visited.contains(cur)) {
        			if (cur == i && len > 1) return true;
        			else break;
        		}
        		visited.add(cur);
        		len++;
        	}
        	arr[i] = true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Prob457 prob = new Prob457();
		System.out.println(prob.circularArrayLoop(new int[] {2, -1, 1, 2, 2}));
		System.out.println(prob.circularArrayLoop(new int[] {1, 1, 2}));
		System.out.println(prob.circularArrayLoop(new int[] {-2, -3, -9}));
	}
}
