package comp.prep2019;

public class Prob66 {
	/**
	 * O(N) time and O(1) space
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i > -1 && carry != 0; i--) {
        	digits[i] += carry;
        	if (digits[i] < 10) return digits;
        	digits[i] = 0;
        	carry = 1;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
