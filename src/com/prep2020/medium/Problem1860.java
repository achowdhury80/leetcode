package com.prep2020.medium;
public class Problem1860 {
	public int[] memLeak(int memory1, int memory2) {
        int[] mem = new int[] {memory1, memory2};
        int i = 1;
        while(true) {
        	if (mem[0] >= mem[1]) {
        		if (mem[0] < i) break;
        		mem[0] -= i;
        	} else {
        		if (mem[1] < i) break;
        		mem[1] -= i;
        	}
        	i++;
        }
        return new int[] {i, mem[0], mem[1]};
        
    }
	
	public static void main(String[] args) {
		Problem1860 problem = new Problem1860();
		System.out.println(problem.memLeak(2, 2));
	}
}
