package comp.prep2019;
import java.util.*;
public class Prob1042 {
	/**
	 * O(N) time and space
	 * @param N
	 * @param paths
	 * @return
	 */
	public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        Map<Integer, List<Integer>> map = new HashMap<>();
        /**
         * find connectivity from a node to all its smaller node
         */
        for (int[] path : paths) {
        	List<Integer> list;
        	if (path[0] < path[1]) {
        		list = map.getOrDefault(path[1], new ArrayList<>());
        		list.add(path[0]);
        		map.put(path[1], list);
        	} else {
        		list = map.getOrDefault(path[0], new ArrayList<>());
        		list.add(path[1]);
        		map.put(path[0], list);
        	}
        }
        result[0] = 1;
        // for each node, check the smaller node to which it is connected
        // used the min color that is not used
        for (int i = 2; i <= N; i++) {
        	List<Integer> list = map.get(i);
        	if (list == null) result[i - 1] = 1;
        	else {
        		boolean[] used = new boolean[4];
        		for (int j : list) {
        			used[result[j - 1] - 1] = true;
        		}
        		for (int j = 0; j < 4; j++) {
        			if (!used[j]) {
        				result[i - 1] = j + 1;
        				break;
        			}
        		}
        	}
        }
        return result;
    }
}
