package comp.prep2019.less1000;
import java.util.*;
public class Prob681 {
	public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(time.charAt(0) - '0');
        set.add(time.charAt(1) - '0');
        set.add(time.charAt(3) - '0');
        set.add(time.charAt(4) - '0');
        Set<Integer> nums = new HashSet<>();
        for (int i : set) {
        	for (int j : set) {
        		int num = i * 10 + j;
        		if (num < 60) nums.add(num);
        	}
        }
        int curTimeInMins = findTimeInMinutes((time.charAt(0) - '0') * 10 
        		+ (time.charAt(1) - '0'), (time.charAt(3) - '0') * 10 
        		+ (time.charAt(4) - '0'));
        String result = time;
        int diff = Integer.MAX_VALUE;
        for (int hr : nums) {
        	if (hr > 23) continue;
        	for (int min : nums) {
        		 int timeInMins = findTimeInMinutes(hr, min);
        		 int curDiff = 0;
        		 if (timeInMins > curTimeInMins) curDiff = timeInMins - curTimeInMins;
        		 else if (timeInMins < curTimeInMins) curDiff = timeInMins + 1440 - curTimeInMins;
        		 else continue;
        		 if (curDiff < diff) {
        			 diff = curDiff;
        			 result = (hr < 10 ? "0" + hr : "" + hr) + ":" 
        					 + (min < 10 ? "0" + min : "" + min);
        		 }
        	}
        }
        return result;
    }
	
	private int findTimeInMinutes(int hr, int min) {
		return hr * 60 + min;
	}
	
	public static void main(String[] args) {
		Prob681 prob = new Prob681();
		System.out.println(prob.nextClosestTime("19:34"));
	}
}
