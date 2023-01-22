package comp.prep2019.less2000;
import java.util.*;
public class Prob1088 {
	/*public int confusingNumberII(int N) {
		Map<Integer, Integer> map = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(6, 9);
            put(8, 8);
            put(9, 6);
        }};
        return dfs(0, 0, 1, map, N);
    }
    
    private int dfs(long root, long reverse, long base, Map<Integer, Integer> map, int n) {
        if (root > n) return 0;
        int res = root != reverse ? 1 : 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long num = root * 10 + entry.getKey();
            if (num == 0) continue;
            res += dfs(num, base * entry.getValue() + reverse, base * 10, map, n);
        }
        return res;
    }*/
}
