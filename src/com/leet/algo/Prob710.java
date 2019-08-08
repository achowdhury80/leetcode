package com.leet.algo;
import java.util.*;
public class Prob710 {
	Map<Integer, Integer> map;
    int M;
    Random rand;
    public Prob710(int N, int[] b) {
        map = new HashMap<>();
        M = N - b.length;

        for(int e : b) map.put(e, -1);

        N--;
        for(int e : b) {
            if(e < M) {
                while(map.containsKey(N)) N--;
                map.put(e, N--);
            }
        }

        rand = new Random();
    }
    
    public int pick() {
        int idx = rand.nextInt(M);
        return map.containsKey(idx) ? map.get(idx) : idx;
    }
}
