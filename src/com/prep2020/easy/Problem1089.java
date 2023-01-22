package com.prep2020.easy;

public class Problem1089 {
	public void duplicateZeros(int[] arr) {
        int last = arr.length - 1, i = 0;
        boolean lastDoubled = true;
        while(i < last) {
        	if (arr[i] == 0) last--;
        	i++;
        }
        if (i == last) lastDoubled = false;
        int j = arr.length - 1;
        if (arr[last] == 0) {
        	if(lastDoubled) arr[j--] = 0;
        	arr[j] = 0;
        } else arr[j] = arr[last];
        last--;
        j--;
        while(last > -1) {
        	if (arr[last] == 0) {
        		arr[j--] = 0;
        	}
        	arr[j--] = arr[last--];
        }
    }
	
	public static void main(String[] args) {
		Problem1089 problem = new Problem1089();
		problem.duplicateZeros(new int[] {0,0,0,0,0,0,0});
	}
}
