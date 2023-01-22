package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2121 {
	public long[] getDistances(int[] arr) {
		long[] result = new long[arr.length];

        /* Store indices/occurrences of elements */
        Map<Integer, ArrayList<Integer>> occurrences = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            occurrences.putIfAbsent(arr[i], new ArrayList<>());
            occurrences.get(arr[i]).add(i);
        }

        /* Loop through the occurrences of each number in input array */
        for (ArrayList<Integer> indices : occurrences.values()) {
            int size = indices.size();

            /*
            To calculate the sum of elements on the left and right side of current occurrence position,
            maintain a sum of elements occurred before the current occurrence in prefixSum
            To get the sum of indices on the right of current occurrence, subtract current index and the prefixSum 
            from the sum
            */
            long sum = 0L;

            for (int index : indices) {
                sum += index;
            }

            long prefixSum = 0L;
            for (long i = 0L; i < size; i++) {
                int index =  indices.get((int) i);
                
                result[index] = index * i - prefixSum + 
                    (sum - prefixSum - index) - (size - i - 1) * index;
                prefixSum += index;
            }
        }
        return result;    
    }
}
