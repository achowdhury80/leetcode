package comp.prep2019.less1000;

public class Prob517 {
	/**
	 * https://leetcode.com/problems/super-washing-machines/solution/
	 * @param machines
	 * @return
	 */
	public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i : machines) sum += i;
        if (sum % machines.length != 0) return -1;
        int avg = sum / machines.length;
        for (int i = 0; i < machines.length; i++) machines[i] -= avg;
        int maxSum = 0, curSum = 0, result = 0;
        for (int i : machines) {
        	curSum += i;
        	maxSum = Math.max(maxSum, Math.abs(curSum));
        	result = Math.max(result, Math.max(maxSum, i));
        }
        return result;
    }
}
