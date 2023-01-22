package com.prep2020.hard;

import java.util.*;

public class Problem850 {
	public int rectangleArea(int[][] rectangles) {
        int[][] events = new int[rectangles.length * 2][];
        for (int i = 0; i < rectangles.length; i++) {
        	events[2 * i] = new int[] {rectangles[i][1], 0, rectangles[i][0], rectangles[i][2]};
        	events[2 * i + 1] = new int[] {rectangles[i][3], 1, rectangles[i][0], rectangles[i][2]};
        }

        Arrays.sort(events, (x, y) -> x[0] - y[0]);

        List<int[]> active = new ArrayList<>();
        int lastY = events[0][0];
        long result = 0, mod = (long)(1e9 + 7);
        for (int[] e: events) {
            // Calculate query
            long query = 0;
            int cur = -1;
            for (int[] xs: active) {
                cur = Math.max(cur, xs[0]);
                query += Math.max(xs[1] - cur, 0);
                cur = Math.max(cur, xs[1]);
            }

            result = (result + (query * (e[0] - lastY)) % mod) % mod;

            if (e[1] == 0) {
                active.add(new int[]{e[2], e[3]});
                Collections.sort(active, (x, y) -> x[0] - y[0]);
            } else {
                for (int i = 0; i < active.size(); ++i)
                    if (active.get(i)[0] == e[2] && active.get(i)[1] == e[3]) {
                        active.remove(i);
                        break;
                    }
            }

            lastY = e[0];
        }

        return (int) result;
    }
}
