package comp.prep2019;

public class Prob821 {
	/**
	 * O(N) time
	 * two pass - one to find shortest from left , another to find shortest from 
	 * right. Made two pass into one
	 * @param S
	 * @param C
	 * @return
	 */
	public int[] shortestToChar(String S, char C) {
        char[] arr = S.toCharArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
        	result[i] = arr.length;
        }
        int[] last = new int[] {-1, -1};
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == C) {
        		last[0] = i;
        		result[i] = 0;
        	} else {
        		if (last[0] > -1) {
        			result[i] = Math.min(result[i], i - last[0]);
        		}
        	}
        	if (arr[arr.length - i - 1] == C) {
        		last[1] = arr.length - i - 1;
        		result[arr.length - i - 1] = 0;
        	} else {
        		if (last[1] > -1) {
        			result[arr.length - i - 1] = Math.min(result[arr.length - i - 1],
        					last[1] - arr.length + i + 1);
        		}
        	}
        }
        return result;
    }
}
