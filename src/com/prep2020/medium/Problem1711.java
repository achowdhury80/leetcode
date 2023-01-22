package com.prep2020.medium;
import java.util.*;
public class Problem1711 {
	public int countPairs(int[] d) {
        int mod = (int)1e9+7;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : d){
            int power = 1;
            for(int j = 0; j <= 21; j++){
                if(power - val >= 0 && map.containsKey(power-val) == true){
                    count += map.get(power - val);
                    count = count % mod;
                }
                power *= 2;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return count;
    }
}
