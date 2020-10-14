package comp.prep2019.less1000;

public class Prob769 {
	public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
        	max = Math.max(max, arr[i]);
        	if (i == max) result++;
        }
        return result;
    }
}
