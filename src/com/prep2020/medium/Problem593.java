package com.prep2020.medium;
import java.util.*;
public class Problem593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Integer> list = new ArrayList<>();
        list.add(dis(p1, p2));
        list.add(dis(p2, p3));
        list.add(dis(p3, p4));
        list.add(dis(p1, p3));
        list.add(dis(p1, p4));
        list.add(dis(p2, p4));
        Collections.sort(list);
        return list.get(0).intValue() == list.get(3).intValue() 
        		&& list.get(4).intValue() == list.get(5).intValue()
        		&& list.get(3).intValue() != list.get(4).intValue();
    }
	
	private int dis(int[] x, int[] y) {
		return (x[0] - y[0])  * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
	}
	
	public static void main(String[] args) {
		Problem593 problem = new Problem593();
		System.out.println(problem.validSquare(new int[] {1134,-2539},
new int[] {492,-1255},
new int[] {-792,-1897},
new int[] {-150,-3181}));
	}
}
