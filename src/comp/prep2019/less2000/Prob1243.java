package comp.prep2019.less2000;
import java.util.*;
public class Prob1243 {
	/**
	 * O(N) space time ??
	 * @param arr
	 * @return
	 */
	public List<Integer> transformArray(int[] arr) {
		List<Integer> result = new ArrayList<>();
		for (int i : arr) result.add(i);
		boolean changed = false;
		do {
			changed = false;
			List<Integer> temp = new ArrayList<>();
			temp.add(result.get(0));
			for (int i = 1; i < result.size() - 1; i++) {
				int prev = result.get(i - 1), cur = result.get(i), next = result.get(i + 1);
				if (cur > prev && cur > next) {
					changed = true;
					temp.add(cur - 1);
				} else if (cur < prev && cur < next) {
					changed = true;
					temp.add(cur + 1);
				} else {
					temp.add(cur);
				}
				
			}
			temp.add(result.get(result.size() - 1));
			result = temp;
		}while(changed);
		return result;
    }
	
	public static void main(String[] args) {
		Prob1243 prob = new Prob1243();
		System.out.println(prob.transformArray(new int[] {6, 2, 3, 4}));
	}
}
