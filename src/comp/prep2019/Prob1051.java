package comp.prep2019;

public class Prob1051 {
	/**
	 * O(N) tme and space
	 * first count the freq of all heights
	 * find cumulative sum of the heights
	 * for any hight h, if its index is less than h - 1 's cumaltive index 
	 * or greater than h + 1 's cumulative index, then move needs to happen
	 * @param heights
	 * @return
	 */
	public int heightChecker(int[] heights) {
        int[] arr = new int[102];
        for (int h : heights) arr[h]++;
        for (int i = 1; i < 102; i++) arr[i] += arr[i - 1];
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
        	int cur = heights[i];
        	if (i < arr[cur - 1]) result++;
        	else if (i >= arr[cur]) result++;
        }
        return result;
    }
}
