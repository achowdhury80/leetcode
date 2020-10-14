package comp.prep2019.less1000;

public class Prob258 {
	/**
	 * O(1)
	 * if number is divisible by 9 then sum is always 9
	 * otherwise the sum is num % 9
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
        if (num < 10) return num;
        if ((num % 9) == 0) return 9;
        return num % 9;
    }
}
