package comp.prep2019;
import java.util.*;
public class Prob681 {
	public String nextClosestTime(String time) {
	    char[] timeArr = time.toCharArray();
	    char[] arr = new char[]{timeArr[0], timeArr[1], timeArr[3], timeArr[4]};
	    Arrays.sort(arr);
	    for (int i = 0; i < 4; i++) {
	      if (timeArr[4] < arr[i]) {
	        timeArr[4] = arr[i];
	        return new String(timeArr);
	      }
	    }
	    timeArr[4] = arr[0];
	    for (int i = 0; i < 4 && timeArr[4] < '5'; i++) {
	      if (timeArr[3] < arr[i] && arr[i] < '6') {
	        timeArr[3] = arr[i];
	        return new String(timeArr);
	      }
	    }
	    timeArr[3] = arr[0];
	    for (int i = 0; i < 4; i++) {
	      if (timeArr[1] < arr[i]) {
	        if (timeArr[0] < '2' || arr[i] < '4') {
	          timeArr[1] = arr[i];
	          return new String(timeArr);
	        }
	      }
	    }

	    timeArr[1] = arr[0];
	    for (int i = 0; i < 4; i++) {
	      if (timeArr[0] <= arr[i]) {
	        timeArr[0] = arr[i];
	        return new String(timeArr);
	      }
	    }
	    return null;
	  }
}
