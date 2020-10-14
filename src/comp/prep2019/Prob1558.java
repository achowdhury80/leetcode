package comp.prep2019;
import java.util.*;
public class Prob1558 {
	/**
	 * O(N) space
	 * for time complexity - consider each numer 01111.. 1 in all 31 bits
	 * max you will have 31 * 2 or 62 iteration
	 * O(N) time
	 * @param nums
	 * @return
	 */
	public int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int num : nums) {
        	if (num != 0) {
        		if (num % 2 == 1) {
        			result++;
        			if (num > 1) list.add(num - 1);
        		} else list.add(num);
        	} 
        }
        while(list.size() > 0) {
        	result++;
        	for (int i = 0; i < list.size(); i++) {
        		list.set(i, list.get(i) / 2);
        		if (list.get(i) % 2 == 1) {
        			result++;
        			if (list.get(i) > 1) {
        				list.set(i, list.get(i) - 1);
        			} else {
        				list.remove(i);
        				i--;
        			}
        		}
        	}
        }
        return result;
    }
}
