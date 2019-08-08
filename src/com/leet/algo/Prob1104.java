package com.leet.algo;
import java.util.*;
public class Prob1104 {
	public List<Integer> pathInZigZagTree(int label) 
    {
        List<Integer> list = new ArrayList<>();
        int power = 1;
		// calculating power till label
        while(label >= power)
            power *=2;
        while(label != 0)
        {
            list.add(0,label);
			// since the label reverses at each level , new pseudo label is the correct order if it was not reversed
            label = power - label + power/2 - 1;
            label = label/2;
            power = power/2;
        }
        return list;
    }
}
