package comp.prep2019.less2000;
import java.util.*;
public class Prob1001 {
	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
		Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> d1 = new HashMap<>();
        Map<Integer, Integer> d2 = new HashMap<>();
        
		Set<Long> lampIdx = new HashSet<>();
        for (int[] lamp : lamps) {
        	row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
        	col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
        	d1.put(lamp[1] - lamp[0], d1.getOrDefault(lamp[1] - lamp[0], 0) + 1);
        	d2.put(lamp[0] + lamp[1], d2.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        	lampIdx.add(1l * lamp[0] * N + lamp[1]);
        }
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
        	int[] pos = queries[k];
        	if (row.getOrDefault(pos[0], 0) > 0 
        			|| col.getOrDefault(pos[1], 0) > 0 
        			|| d1.getOrDefault(pos[1] - pos[0], 0) > 0
        			|| d2.getOrDefault(pos[0] + pos[1], 0) > 0) {
        		result[k] = 1;
        		for (int i = -1; i < 2; i++) {
    				for (int j = -1; j < 2; j++) {
    					int[] newPos = new int[] {pos[0] + i, pos[1] + j};
    					long lampId;
    					if (newPos[0] < 0 || newPos[0] == N || newPos[1] < 0 
    							|| newPos[1] == N 
    							|| !lampIdx.contains((lampId = 1l * newPos[0] * N 
    							+ newPos[1]))) 
    						continue;
    					lampIdx.remove(lampId);
    					row.put(newPos[0], row.get(newPos[0]) - 1);
    					col.put(newPos[1], col.get(newPos[1]) - 1);
    					d1.put(newPos[1] - newPos[0], 
    							d1.get(newPos[1] - newPos[0]) - 1);
    					d2.put(newPos[1] + newPos[0], 
    							d2.get(newPos[1] + newPos[0]) - 1);
    				}
    			}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1001 prob = new Prob1001();
		/*int[] result = prob.gridIllumination(5, new int[][] {{0,0},{4,4}},
				new int[][] {{1,1},{1,1}});*/
		int[] result = prob.gridIllumination(5, new int[][] {{0,0}, {0, 1}, {0,4}},
				new int[][] {{0, 0}, {0,1}, {0,1}});
		for (int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
	}
}
