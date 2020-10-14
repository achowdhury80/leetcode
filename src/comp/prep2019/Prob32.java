package comp.prep2019;

public class Prob32 {
	public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int[] result = new int[] {Integer.MIN_VALUE};
        helper(arr, result);
        helper1(arr, result);
        return result[0] == Integer.MIN_VALUE ? 0 : result[0];
    }
	
	private void helper(char[] arr, int[] result) {
		int count = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c == '(') count++;
			else count--;
			if (count == 0) result[0] = Math.max(result[0], i - start + 1);
			if (count == -1) {
				count = 0;
				start = i + 1;
			}
		}
	}
	
	private void helper1(char[] arr, int[] result) {
		int count = 0;
		int start = arr.length - 1;
		for (int i = arr.length - 1; i > -1; i--) {
			char c = arr[i];
			if (c == ')') count++;
			else count--;
			if (count == 0) result[0] = Math.max(result[0], start - i + 1);
			if (count == -1) {
				count = 0;
				start = i - 1;
			}
		}
	}
}
