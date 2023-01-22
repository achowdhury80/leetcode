package com.prep2020.hard;
import java.util.*;

public class Problem759 {
	/**
	 * O(Nlogn) time
	 * and O(N) space
	 * @param schedule
	 * @return
	 */
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? (x[1] - y[1]) 
        		: (x[0] - y[0])));
        for (List<Interval> intervals : schedule) {
        	for (Interval interval : intervals) {
        		pq.offer(new int[] {interval.start, 0});
        		pq.offer(new int[] {interval.end, 1});
        	}
        }
        List<Interval> result = new ArrayList<>();
        int prev = -1;
        int count = 0;
        while(pq.size() > 1) {
        	int[] arr = pq.poll();
        	if (arr[1] == 1) {
        		count--;
        		if (count == 0) prev = arr[0];
        	} else {
        		if (count == 0 && prev != -1) {
        			result.add(new Interval(prev, arr[0]));
        		}
        		count++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args){
	    Problem759 prob759 = new Problem759();
	      List<List<Interval>> schedule = null;
	      List<Interval> intervals = null;
	    schedule = new ArrayList<>();
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(1,2));
	    intervals.add(new Interval(5,6));
	    schedule.add(intervals);
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(1,3));
	    schedule.add(intervals);
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(4,10));
	    schedule.add(intervals);
	    System.out.println(prob759.employeeFreeTime(schedule));


	    /*schedule = new ArrayList<>();
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(1,3));
	    intervals.add(new Interval(6,7));
	    schedule.add(intervals);
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(2,4));
	    schedule.add(intervals);
	    intervals = new ArrayList<>();
	    intervals.add(new Interval(2,5));
	    intervals.add(new Interval(9,12));
	    schedule.add(intervals);
	    System.out.println(prob759.employeeFreeTime(schedule));*/
	  }
	
	static class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }
	}
}


