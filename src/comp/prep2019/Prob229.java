package comp.prep2019;
import java.util.*;
public class Prob229 {
	public List<Integer> majorityElement(int[] nums) {
		int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
		for (int num : nums) {
			if (num == candidate1) count1++;
			else if (num == candidate2) count2++;
			else if (count1 == 0) {
				candidate1 = num;
				count1++;
			} else if (count2 == 0) {
				candidate2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == candidate1) count1++;
			else if (num == candidate2) count2++;
		}
		List<Integer> result = new ArrayList<>();
		if (count1 > nums.length / 3) result.add(candidate1);
	    if (count2 > nums.length / 3) result.add(candidate2);
	    return result;
    }
}
