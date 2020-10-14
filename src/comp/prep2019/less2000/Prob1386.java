package comp.prep2019.less2000;
import java.util.*;
public class Prob1386 {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] cache = new int[1 << 9];
		for (int i = 0; i < cache.length; i++) cache[i] = -1;
        for (int[] pos : reservedSeats) {
        	if (pos[1] != 1 && pos[1] != 10)
        		map.put(pos[0] - 1, (map.getOrDefault(pos[0] - 1, 0) | (1 << (9 - pos[1] + 1))));
        }
        int result = (n - map.size()) * 2;
        int[] masks = new int[] {(1 << 9) - 2, (1 << 9) - (1 << 5), (1 << 7) - (1 << 3), (1 << 5) - 2};
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int cur = entry.getValue();
            if (cache[cur] != -1) result += cache[cur];
            else {
            	int count = 0;
	            if ((cur & masks[0]) == 0) count += 2;
	            else {
	            	for (int k = 1; k < masks.length; k++) {
	            		if ((cur & masks[k]) == 0) {
	            			count++;
	            			break;
	            		}
	            	}
	            }
	            cache[cur] = count;
	            result += count;
            }
            
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1386 prob = new Prob1386();
		System.out.println(prob.maxNumberOfFamilies(4, new int[][] {{4,3},{1,4},{4,6},{1,7}}));
	}
}
