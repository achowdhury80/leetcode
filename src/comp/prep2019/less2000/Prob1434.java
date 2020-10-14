package comp.prep2019.less2000;
import java.util.*;
public class Prob1434 {
	public int numberWays(List<List<Integer>> hats) {
		int n = hats.size();
        List<Integer>[] h2p = new List[41]; // h2p[i] indicates the list of people who can wear i_th hat
        for (int i = 1; i <= 40; i++) h2p[i] = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int hat : hats.get(i))
                h2p[hat].add(i);
        return (int)helper(0, (1 << n) - 1, 1, h2p, new HashMap<>(), (long)(1e9 + 7));
    }
	
	private long helper(int assigned, int allMask, int start, List<Integer>[] h2p, 
			Map<Integer, Long> map, long mod) {
		if (assigned == allMask) return 1;
		if (start == 41) return 0;
		int key = (start << 10) | assigned;
		if (map.containsKey(key)) return map.get(key);
		long result = helper(assigned, allMask, start + 1, h2p, map, mod); // Don't wear this hat
		for (int p : h2p[start]) {
			if ((assigned & (1 << p)) > 0) continue;
			result = (result +  helper(assigned | (1 << p), allMask, start + 1, h2p, map, mod)) 
					% mod; 
		}
		map.put(key, result);
		return result;
	}
}
