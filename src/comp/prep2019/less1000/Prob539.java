package comp.prep2019.less1000;
import java.util.*;
public class Prob539 {
	/**
	 * O(N^2)
	 * @param timePoints
	 * @return
	 */
	public int findMinDifference(List<String> timePoints) {
		if(timePoints == null || timePoints.size() < 2 || timePoints.size() > 24 * 60) return 0;
	    int result = Integer.MAX_VALUE;
	    for(int i = 0; i < timePoints.size() - 1; i++){
	      for(int j = i + 1; j < timePoints.size(); j++){
	        result = Math.min(result, timeDiff(timePoints.get(i), timePoints.get(j)));
	        if(result == 0) return 0;
	      }
	    }
	    return result;
    }
	
	private int timeDiff(String timePoint1, String timePoint2){
	    int time1 = minutes(timePoint1);
	    int time2 = minutes(timePoint2);
	    return Math.min(time1 >= time2 ? time1 - time2 : time1 + 1440 - time2, time2 >= time1 ? time2 - time1 : time2 + 1440 - time1);
	  }

	  private int minutes(String timePoint1){
	    int result = 0;
	    result += Integer.valueOf(timePoint1.substring(0, timePoint1.indexOf(":"))) * 60;
	    result += Integer.valueOf(timePoint1.substring(timePoint1.indexOf(":") + 1));
	    return result;
	  }
}
