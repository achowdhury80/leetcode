package comp.prep2019.less1000;

public class Prob370 {
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        if(length < 1) return result;
        for (int[] update : updates) {
        	result[update[0]] += update[2];
        	if (update[1] < length - 1) result[update[1] + 1] -= update[2];
        }
        int inc = result[0];
        for (int i = 1; i < length; i++) {
        	inc += result[i];
        	result[i] = inc;
        }
        return result;
    }
}
