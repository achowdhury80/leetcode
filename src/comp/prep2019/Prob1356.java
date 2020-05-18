package comp.prep2019;

import java.util.Arrays;

public class Prob1356 {
	public int[] sortByBits(int[] arr) {
		Integer[] a = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) a[i] = arr[i];
        Arrays.sort(a, (x, y) -> compare(x, y));
        int[] result = new int[arr.length];
        for (int i = 0; i < a.length; i++) result[i] = a[i];
        return result;
    }
	
	private int compare(int x, int y) {
		int xBit = Integer.bitCount(x), yBit = Integer.bitCount(y);
		return xBit == yBit ? x - y : xBit - yBit;
	}
	
}	
