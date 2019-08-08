package com.leet.algo;

public class Prob945 {
	//O(n) 
	// find max and min, allocate a count array size 40000 + length of A
	// iterate from min to max and populate empty spaces in the array
	public int minIncrementForUnique(int[] A) {
        if (A.length < 2) return 0;
        int[] arr = new int[40000 + A.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int freeIndex = -1;
        for (int a : A) {
        	arr[a]++;
        	min = Math.min(min, a);
        	max = Math.max(max, a);
        }
        int result = 0;
        for (int i = min; i <= max; i++) {
        	while (arr[i] > 1) {
        		for (int j = i + 1; j < arr.length; j++) {
        			if (arr[j] == 0) {
        				freeIndex = j;
        				break;
        			}
        		}
        		result += freeIndex - i;
        		arr[freeIndex] = 1;
        		arr[i]--;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob945 prob = new Prob945();
		//System.out.println(prob.minIncrementForUnique(new int[] {1, 2, 2}));
		//System.out.println(prob.minIncrementForUnique(new int[] {0, 2, 2}));
		System.out.println(prob.minIncrementForUnique(new int[] {3,2,1,2,1,7}));
	}
}
