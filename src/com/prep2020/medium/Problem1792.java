package com.prep2020.medium;
import java.util.*;
public class Problem1792 {
	/**
	 * O(nlogN)
	 * @param classes
	 * @param extraStudents
	 * @return
	 */
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<Tripple> pq = new PriorityQueue<Tripple>((a,b)-> {
            if (b.ma<a.ma) {
                return -1; 
            } else {
                if (b.ma>a.ma) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int[] c:classes) {
            Tripple t = new Tripple();
            t.pa = c[0];
            t.to = c[1];
            t.ma = ((double)(t.pa+1))/(t.to+1) - ((double)(t.pa))/t.to;
            pq.offer(t);
        }
        while (extraStudents>0) {
            Tripple t = pq.poll();
            t.pa++;
            t.to++;
            t.ma = ((double)(t.pa+1))/(t.to+1) - ((double)(t.pa))/t.to;
            pq.offer(t);
            extraStudents--;
        }
        double s = 0;
        int c = 0;
        while (!pq.isEmpty()) {
            Tripple t = pq.poll();
            s = s + ((double)(t.pa))/t.to;
            c++;
        }
        return s/c;
    }
    
    class Tripple {
        int pa;
        int to;
        double ma;
    }
}
