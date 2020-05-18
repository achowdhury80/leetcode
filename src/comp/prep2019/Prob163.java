package comp.prep2019;
import java.util.*;
public class Prob163 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	    long start = lower;
	    int i = 0;
	    List<String> list = new ArrayList<>();
	    while (i < nums.length) {
	      int num = nums[i];
	      if (start == num) start++;
	      else if (start + 1 == num) {
	        list.add("" + start);
	        start = num + 1l;
	      } else if (start < num){
	        list.add("" + start + "->" + (num - 1));
	        start = num + 1l;
	      }
	      i++;
	    }
	    if (start == upper) list.add("" + start);
	    else if (start < upper) list.add(start + "->" + upper);
	    return list;
	  }
}
