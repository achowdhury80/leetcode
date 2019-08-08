package com.leet.algo;

import java.util.Random;

public class Prob1029 {
	public int twoCitySchedCost(int[][] costs) {
        int low = 0, high = costs.length - 1;
        shuffle(costs);
        while (true) {
        	int i = prtition(costs, low, high);
        	if (i == costs.length / 2) break;
        	if (i > costs.length / 2) high = i - 1;
        	else low = i + 1;
        }
        
        int result = 0;
        for (int i = 0; i < costs.length / 2; i++) {
        	result += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
        	result += costs[i][1];
        }
        return result;
    }
	
	private int prtition(int[][] costs, int low, int high) {
		if (low == high) return low;
		int pivot = low;
		int i = low, j = low;
		while(j < high) {
			j++;
			if (costs[j][0] - costs[j][1] <= costs[pivot][0] - costs[pivot][1]) {
				i++;
				swap(costs, i, j);
			}
		}
		swap(costs, low, i);
		return i;
	}
	
	private void shuffle(int[][] costs) {
		Random random = new Random();
		for (int i = 1; i < costs.length; i++) {
			int next = random.nextInt(i + 1);
			swap(costs, i, next);
		}
		
	}
	
	private void swap(int[][] costs, int i, int j) {
		int[] temp = costs[i];
		costs[i] = costs[j];
		costs[j] = temp;
	}
	
	public static void main(String[] args) {
		Prob1029 prob = new Prob1029();
		int[][] costs = null;
		//costs = new int[][]{{10,20},{30,200},{400,50},{30,20}};
		costs = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
		int sum = prob.twoCitySchedCost(costs);
		System.out.println(sum);
	}
}
