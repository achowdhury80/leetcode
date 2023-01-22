package com.prep2020.medium;
import java.util.*;
public class Problem1868 {
	public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        // Let's get two pointers to move from the beginning to the back 
        int ptr1 = 0, ptr2 = 0;
        int ptr1val = 0, ptr1freq = 0, ptr2val = 0, ptr2freq = 0;
        List<List<Integer>> result = new ArrayList<>();
        
        while (ptr1 < encoded1.length && ptr2 < encoded2.length) {
            ptr1val = encoded1[ptr1][0]; ptr1freq = encoded1[ptr1][1];
            ptr2val = encoded2[ptr2][0]; ptr2freq = encoded2[ptr2][1];
            int minFreq = Math.min(ptr1freq, ptr2freq);
            int resultVal = ptr1val * ptr2val;
            // Handle the case that we may need to combine same multiply product
            if (!result.isEmpty() && resultVal == result.get(result.size() - 1).get(0)) {
                // Get the previous result's frequency and add current frequency
                // then set the new frequency
                int prevFreq = result.get(result.size() - 1).get(1);
                result.get(result.size() - 1).set(1, prevFreq + minFreq);
            // Otherwise, just add the new resultValue and frequency to the result;
            } else {
                result.add(Arrays.asList(resultVal, minFreq));
            }
            // If frequency of encoded2's element is greater, subtract the frequency
            // of ptr1freq since we've used up ptr1freq # of product already. 
            // move the ptr1 for next iteration. 
            if (ptr2freq > ptr1freq) {
                encoded2[ptr2][1] = ptr2freq - ptr1freq;
                ptr1++;
            // Vice versa if encoded1's element has higher frequency than encoded2's frequency. 
            } else if (ptr2freq < ptr1freq) {
                encoded1[ptr1][1] = ptr1freq - ptr2freq;
                ptr2++;
            // If both frequency are the same, then we move both pointers toward the back 
            // of their respective array. 
            } else {
                ptr1++;
                ptr2++;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		Problem1868 problem = new Problem1868();
		/*System.out.println(problem.findRLEArray(new int[][] {{1, 3}, {2, 1}, {3, 2}}, 
				new int[][] {{2, 3}, {3, 3}}));*/
		System.out.println(problem.findRLEArray(new int[][] {{1, 2}, {3, 4}, {6, 3}}, 
				new int[][] {{2, 2}, {4, 4}, {2, 3}}));
	}
}
