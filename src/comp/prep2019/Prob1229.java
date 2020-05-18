package comp.prep2019;
import java.util.*;
public class Prob1229 {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (x, y) -> x[0] - y[0]);
        Arrays.sort(slots2, (x, y) -> x[0] - y[0]);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < slots1.length && j < slots2.length) {
        	if (slots1[i][1] <= slots2[j][0]) {
        		i++;
        	} else if (slots2[j][1] <= slots1[i][0]) {
        		j++;
        	} else if (Math.max(slots1[i][0], 
        			slots2[j][0]) + duration <= Math.min(slots1[i][1], slots2[j][1])) {
        		result.add(Math.max(slots1[i][0], 
        			slots2[j][0]));
        		result.add(Math.max(slots1[i][0], 
        			slots2[j][0]) + duration);
        		return result;
        	} else if (slots1[i][0] < slots2[j][0]) {
        		i++;
        	} else if (slots1[i][0] > slots2[j][0]) {
        		j++;
        	} else if (slots1[i][1] < slots2[j][1]) {
        		i++;
        	} else if (slots1[i][1] > slots2[j][1]) {
        		j++;
        	} else {
        		i++;
        		j++;
        	}
        }
        return result;
    }
}
