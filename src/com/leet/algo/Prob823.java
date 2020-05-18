package com.leet.algo;
import java.util.*;
public class Prob823 {
	public int numFactoredBinaryTrees(int[] A) {
        int mode = 1000000007;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
        	result = (result + 1) % mode;
            map.put(A[i],1);
            for(int j = 0; j < i; j++){
                if(A[i] % A[j] != 0) continue;
                int tmp = A[i] / A[j];
                if(map.containsKey(tmp)){
                    int product = (int)((map.get(A[j]) * 1l * map.get(tmp)) % mode);
                    result = (result + product) % mode;
                    map.put(A[i], (map.get(A[i]) + product) % mode);
                }
            }
        }
        return result % mode;
	}
}
