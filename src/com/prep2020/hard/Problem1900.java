package com.prep2020.hard;
import java.util.*;
public class Problem1900 {
	public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return solve(n, (1<<n)-1, 0, n-1, firstPlayer-1, secondPlayer-1, new HashMap<>());
    }

    private int[] solve(int n, int mask, int lo, int hi, int a, int b, Map<Integer, int[]> map){
        while((mask&1<<hi)==0){ // find the next set bit for hi
            hi--;
        }
        while((mask&1<<lo)==0){ // find the next set bit for lo
            lo++;
        }
        if (lo>=hi){ // if the round ends, advance to the next layer "anew"
            if (map.containsKey(mask)){ // if we've seen it, just return it.
                return map.get(mask);
            }
            int[] res = solve(n, mask, 0, n-1, a, b, map);
            res[0]++; res[1]++;
            map.put(mask, res);
            return res;
        }
        if (lo==a&&hi==b||lo==b&&hi==a){ // oops, it ends here.
            return new int[]{1, 1};
        }
        int[] ans = new int[]{100, 0};
        if (hi!=a&&hi!=b){ // make hi lose 
            int[] x = solve(n, mask^1<<hi, lo+1, hi-1, a, b, map);
            ans[0] = Math.min(ans[0], x[0]);
            ans[1] = Math.max(ans[1], x[1]);
        }
        if (lo!=a&&lo!=b){ // make lo lose
            int[] y = solve(n, mask^1<<lo, lo+1, hi-1, a, b, map);
            ans[0] = Math.min(ans[0], y[0]);
            ans[1] = Math.max(ans[1], y[1]);
        }
        return ans;
    }
}
