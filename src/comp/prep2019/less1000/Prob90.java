package comp.prep2019.less1000;
import java.util.*;
public class Prob90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
        Arrays.sort(nums);
        int count = (int)Math.pow(2, n);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
        	List<Integer> list = new ArrayList<>();
        	boolean flag = true;
        	for (int j = 0; j < n; j++) {
        		if (((i >> j) & 1) == 1) {
        			if (j + 1 < n && (nums[n - j - 1] == nums[n - j - 2]) 
        					&& ((i >> (j + 1)) & 1) == 0) {
        				flag = false;
        				break;
        			}
        			list.add(nums[n - j - 1]);
        		}
        	}
        	if (flag) result.add(list);
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		Prob90 prob = new Prob90();
		System.out.println(prob.subsetsWithDup(new int[] {1, 2, 2}));
	}
}
