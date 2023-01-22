package com.prep2020.hard;
import java.util.*;
public class Problem757 {
	public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 2; // minimum 2 sized SET should be there
        
        // in Increasing order of END Time and if END TIME is same then Decreasing order of START time as well
        Arrays.sort(intervals, (a,b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        
        int highestValInSet = intervals[0][1]; // max value of first interval
        int secondHighestValueInSet = intervals[0][1] - 1; // second max value from first interval
        
        for(int i = 1; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            
            if(start > highestValInSet) { // means ther is no common between curr interval and intervals before this
                // add 2 new values
                // end - 1 first and then end to make the SET SORTED
                res += 2;
                highestValInSet = intervals[i][1];
                secondHighestValueInSet = intervals[i][1] - 1;
            } else if(start > secondHighestValueInSet && start <= highestValInSet) { // atleast 1 value from current interval matches with previosu sets
                // just add 1 max value
                res += 1;
                secondHighestValueInSet = highestValInSet; // now second max becomes previous max
                highestValInSet = intervals[i][1]; // new max for current interval
            }
        }
        
        return res;
    } 
}
