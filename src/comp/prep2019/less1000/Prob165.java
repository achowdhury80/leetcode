package comp.prep2019.less1000;
import java.util.*;
public class Prob165 {
	public int compareVersion(String version1, String version2) {
        List<Integer> l1 = normalize(version1), l2 = normalize(version2);
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()) {
        	if (l1.get(i) > l2.get(j)) return 1;
        	if (l1.get(i) < l2.get(j)) return -1;
        	i++;
        	j++;
        }
        if (i < l1.size()) return 1;
        else if (j < l2.size()) return -1;
        return 0;
    }
	
	private List<Integer> normalize(String v) {
		List<Integer> result = new ArrayList<>();
		String[] strs = v.split("\\.");
		boolean found = false;
		for (int i = strs.length - 1; i > -1; i--) {
			int val = Integer.parseInt(strs[i]);
			if (val == 0) {
				if (found) result.add(0, val);
			} else {
				result.add(0, val);
				found = true;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob165 prob = new Prob165();
		System.out.println(prob.compareVersion("0.1", "1.1"));
	}
}
