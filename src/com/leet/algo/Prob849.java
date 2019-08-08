package com.leet.algo;

public class Prob849 {
	public int maxDistToClosest(int[] seats) {
		int result = Integer.MIN_VALUE;
		Integer closestRight = null;
		if (seats[0] == 0)
			closestRight = findNextClosestDistanceToTheRight(seats, -1);
		
		Integer closestLeft = null;
		for (int i = 0; i < seats.length; i++) {
        	if (seats[i] == 1) {
        		closestLeft = 0;
        		closestRight = findNextClosestDistanceToTheRight(seats, i);
        	} else {
        		if (closestLeft != null) closestLeft++;
        		if (closestRight != null) closestRight--;
        		if (closestLeft != null && closestRight != null) {
        			result = Math.max(result, Math.min(closestLeft, closestRight));
        		} else if(closestLeft == null) result = Math.max(result, closestRight);
        		else result = Math.max(result, closestLeft);
        		
        		
        	}
        }
        return result;
    }
	
	private Integer findNextClosestDistanceToTheRight(int[] seats, int start) {
		Integer result = null;
		for (int i = start + 1; i < seats.length; i++) {
			if (seats[i] == 1) return i - start;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob849 prob = new Prob849();
		//boolean result = prob.isLongPressedName("alex", "aaleex");
		//boolean result = prob.isLongPressedName("leelee", "lleeelee");
		//boolean result = prob.isLongPressedName("vtkgn", "vttkgnn");
		int result = prob.maxDistToClosest(new int[] {0,1});
		System.out.println(result);
	}
}
