package comp.prep2019;

import java.util.Arrays;
import java.util.Comparator;

public class Prob179 {
	public String largestNumber(int[] nums) {
		if(nums.length == 0) return "";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = "" + nums[i];
        Arrays.sort(arr, new Comparator<String>() {
        	public int compare(String a, String b) {
        		if (a.equals(b)) return 0;
        		int factor = 1;
        		if (b.length() > a.length()) {
        			String temp = a;
        			a = b;
        			b = temp;
        			factor= -1;
        		}
        		for (int i = 0; i < b.length(); i++) {
        			if (a.charAt(i) > b.charAt(i)) return -1 * factor;
        			else if (a.charAt(i) < b.charAt(i)) return 1 * factor;
        		}
        		for (int j = b.length(); j < a.length(); j++) {
        			for (int k = 0; k < b.length(); k++) {
        				if (a.charAt(j) > b.charAt(k)) return -1 * factor;
        				else if (a.charAt(j) < b.charAt(k)) return 1 * factor;
        			}
        		}
        		return -1 * factor;
        	}
		});
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb = sb.deleteCharAt(0);
        return sb.toString();
    }
}
