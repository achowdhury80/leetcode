package com.prep2020.hard;

public class Problem1643 {
	public String kthSmallestPath(int[] destination, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < destination[1]; i++) sb.append("H");
        int lastHIndex = destination[1] - 1, curHIndex = destination[1] - 1;
        for (int i = 0; i < destination[0]; i++) sb.append("V");
        char[] arr = sb.toString().toCharArray();
        int lastVIndex = arr.length - 1;
        while(k > 1) {
        	swap(arr, curHIndex, curHIndex + 1);
        	curHIndex++;
        	if(curHIndex == lastVIndex) {
        		lastVIndex--;
        		curHIndex = lastHIndex - 1;
        	}
        	k--;
        }
        return new String(arr);
    }

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
