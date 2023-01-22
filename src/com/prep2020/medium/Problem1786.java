package com.prep2020.medium;

import java.util.*;

public class Problem1786 {
	final int mod = (int) 1e9+7;
    List<edge> [] adj; 
    int [] dp; // dp[i] -> # of restricted path from i to n
    int [] dis; // dis[i] -> distance from i to n
    public int countRestrictedPaths(int n, int[][] edges) {
        adj = new List[n+1]; dp = new int[n+1]; dis = new int[n+1];
        for (int i = 1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int [] e : edges) {
            adj[e[0]].add(new edge(e[1], e[2]));
            adj[e[1]].add(new edge(e[0], e[2]));
        }
        PriorityQueue<edge> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w; 
        });
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.add(new edge(n, 0));
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (cur.w>=dis[cur.v]) continue;
            dis[cur.v] = cur.w;
            for (edge nxt : adj[cur.v]) {
                pq.add(new edge(nxt.v, dis[cur.v] + nxt.w));
            }
        }
        Arrays.fill(dp, -1);
        return dfs(1, n);
    }
    public int dfs(int u, int n) {
        if (u==n) {
            return 1;
        }
        if (dp[u]!=-1) return dp[u];
        dp[u] = 0;
        for (edge nxt : adj[u]) {
            if (dis[u] > dis[nxt.v]) dp[u]= (dp[u] % mod + dfs(nxt.v, n) % mod)%mod;
        }
        return dp[u];
    }
    public class edge {
        int v, w;
        edge(int u, int c) { v = u; w = c; }
    }
}
