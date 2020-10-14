package comp.prep2019.less2000;

public class Prob1342 {
	/**
	 * O(logN)
	 * @param num
	 * @return
	 */
	public int numberOfSteps(int num) {
        if (num == 0) return 0;
        if (num % 2 == 0) return 1 + numberOfSteps(num / 2);
        return 1 + numberOfSteps(num - 1);
    }
}
