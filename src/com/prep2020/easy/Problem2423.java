package com.prep2020.easy;
import java.util.*;
public class Problem2423 {
	public boolean equalFrequency(String word) {
		int [] table = new int[26];
		for(int i=0; i<word.length(); ++i){
			table[word.charAt(i)-'a'] ++;
		}
		Arrays.sort(table);
		int index = 0;
		while(table[index] == 0) index++; // filter all zeros,  


		//case1 : all letter appears once or all the letter are the same 
		if(table[index] == table[25] && table[25] == 1 || table[24]==0)return true;

		//case2: the most frequency letter - 1 == the least frequency letter 
		if(table[index] == table[24] && table[25] == table[24]+1) return true; 

		// case3; there is one letter only appearing once, others are equal frequencies
		if(table[index] == 1 && table[index+1] == table[25]) return true;

		return false;
	}
}