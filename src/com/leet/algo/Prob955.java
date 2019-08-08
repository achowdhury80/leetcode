package com.leet.algo;
import java.util.*;
public class Prob955 {
	public int minDeletionSize(String[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) list.add(i);
        int n = A[0].length();
        int result = 0;
        for (int i = 0; i < n && list.size() > 1; i++) {
        	char last = A[list.get(0)].charAt(i);
        	List<Integer> temp = new ArrayList<>();
        	boolean delete = false;
        	for (int j = 1; j < list.size(); j++) {
        		String s = A[list.get(j)];
        		if (s.charAt(i) < last) {
        			result++;
        			delete = true;
        			break;
        		} else if (s.charAt(i) == last) {
        			if (temp.size() < 1 || temp.get(temp.size() - 1) != list.get(j - 1)) temp.add(list.get(j - 1));
        			temp.add(list.get(j));
        		} 
        		last = s.charAt(i);
        		
        	}
        	if(delete) continue;
        	list = temp;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob955 prob = new Prob955();
		System.out.println(prob.minDeletionSize(new String[] {"abx","agz","bgc","bfc"}));
		//System.out.println(prob.minDeletionSize(new String[] {"zyx","wvu","tsr"}));
	}
}
