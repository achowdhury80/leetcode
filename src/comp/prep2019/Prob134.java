package comp.prep2019;

public class Prob134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] min = new int[] {Integer.MAX_VALUE, -1};
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
        	sum  += gas[i] - cost[i];
        	if (min[0] > sum) {
        		min[0] = sum;
        		min[1] = i;
        	}
        }
        return sum < 0 ? -1 : (min[1] + 1) % gas.length;
    }
}
