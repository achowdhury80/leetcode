package comp.prep2019;

import java.util.Arrays;

public class Prob1502 {
	public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int commonDiff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) if (arr[i] - arr[i - 1] != commonDiff) return false;
        return true;
    }
}
