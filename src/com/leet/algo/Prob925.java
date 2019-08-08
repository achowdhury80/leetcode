package com.leet.algo;

public class Prob925 {
	public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 || typed.length() == 0 || name.length() > typed.length()) return false;
        char[] nameArr = name.toCharArray();
        char[] arr = typed.toCharArray();
        char prevChar = nameArr[0];
        if (arr[0] != prevChar) return false;
        int idx = 1;
        int i = 1;
        for (i = 1; i < arr.length; i++) {
        	if (idx == nameArr.length) break;
        	while(i < arr.length && arr[i] != nameArr[idx]) {
        		if (arr[i] != prevChar) return false;
        		i++;
        	}
        	if (i == arr.length || arr[i] != nameArr[idx]) return false;
        	prevChar = arr[i];
        	idx++;
        }
        if(idx < nameArr.length) return false;
        while (i < arr.length) {
        	if (arr[i] != prevChar) return false;
        	i++;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob925 prob = new Prob925();
		//boolean result = prob.isLongPressedName("alex", "aaleex");
		//boolean result = prob.isLongPressedName("leelee", "lleeelee");
		//boolean result = prob.isLongPressedName("vtkgn", "vttkgnn");
		boolean result = prob.isLongPressedName("pyplrz", "ppyypllr");
		System.out.println(result);
	}
}
