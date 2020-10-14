package comp.prep2019;
import java.util.*;
public class Prob1104 {
	/**
	 * O(H)
	 * @param label
	 * @return
	 */
	public List<Integer> pathInZigZagTree(int label) {
		int i = 1;
        while(Math.pow(2, i) - 1 < label) i++;
        List<Integer> result = new ArrayList<>();
        for (int j = i; j > 0; j--) {
        	result.add(0, label);
        	int actualLabel =  findActualLabel(label, j);
        	int parentActual = actualLabel / 2;
        	label = findFakeLabel(parentActual, j - 1);
        }
        return result;
    }
	
	private int findActualLabel(int fakeLabel, int depth) {
		if (depth % 2 == 1) return fakeLabel;
		int min = (int)Math.pow(2, depth - 1);
		int max = (int)Math.pow(2, depth) - 1;
		return max - (fakeLabel - min);
	}
	
	private int findFakeLabel(int actualLabel, int depth) {
		if (depth % 2 == 1) return actualLabel;
		int min = (int)Math.pow(2, depth - 1);
		int max = (int)Math.pow(2, depth) - 1;
		return max - (actualLabel - min);
	}
}
