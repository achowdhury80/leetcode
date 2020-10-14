package comp.prep2019.less1000;
import java.util.*;
public class Prob228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int n;
		if ((n = nums.length) < 1) return result;
		int start = nums[0], cur = nums[0];
		for (int i = 1; i < n; i++) {
			if (cur + 1 != nums[i]) {
				if (start == cur) result.add("" + cur);
				else result.add(start + "->" + cur);
				start = nums[i];
				cur = start;
			} else cur = nums[i];
		}
		if (start == cur) result.add("" + cur);
		else result.add(start + "->" + cur);
		return result;
    }
}
