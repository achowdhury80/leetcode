package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2178 {
	public List<Long> maximumEvenSplit(long finalSum) {
		// if its not a even no
		if (finalSum % 2 != 0)
			return new ArrayList<>();
		long num = 2;
		long trace = 0;
		List<Long> arr = new ArrayList<>();
		// we want to maximise the list size so we would start form lowest even no and
		// then add successive no untill it gets greater ,
		while (trace < finalSum) {

			trace += num;
			arr.add(num);
			num += 2;
		}
		// now we remove the diff from the list so that trace==finalSum
		arr.remove(trace - finalSum);
		return arr;
	}
	
	public static void main(String[] args) {
		Problem2178 problem = new Problem2178();
		//System.out.println(problem.maximumEvenSplit(28));
		System.out.println(problem.maximumEvenSplit(90));
	}
}
