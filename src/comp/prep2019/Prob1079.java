package comp.prep2019;

import java.util.Arrays;

public class Prob1079 {
	public int numTilePossibilities(String tiles) {
		int n;
        if ((n = tiles.length()) < 2) return n;
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        int[] result = new int[] {0};
        helper(arr, 0, result, "");
        return result[0];
    }
	
	private void helper(char[] arr, int code, int[] result, String s) {
		if (!"".equals(s)) result[0]++;
		if (s.length() == arr.length) return;
		for (int i = 0; i < arr.length; i++) {
			if (isSelected(code, i)) continue;
			if (i > 0 && arr[i - 1] == arr[i] && !isSelected(code, i - 1)) continue;
			helper(arr, code | (1 << i), result, s + arr[i]);
		}
	}
	
	private boolean isSelected(int code, int idx) {
		return ((1 << idx) & code) > 0;
	}
	
	public static void main(String[] args) {
		Prob1079 prob = new Prob1079();
		System.out.println(prob.numTilePossibilities("AAB"));
	}
}
