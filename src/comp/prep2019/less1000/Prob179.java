package comp.prep2019.less1000;

import java.util.Arrays;
import java.util.Comparator;

public class Prob179 {
	public String largestNumber(int[] nums) {
		if(nums.length == 0) return "";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = "" + nums[i];
        Arrays.sort(arr, (x, y) -> (x + y).compareTo(y + x) > 0 ? -1 : 1);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb = sb.deleteCharAt(0);
        return sb.toString();
    }
}
