package com.prep2020.medium;
import java.util.*;
public class Problem1073 {
	public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int[] carries = new int[2];
        reverse(arr1);
        reverse(arr2);
        int i = 0, j = 0, n1 = arr1.length, n2 = arr2.length;
        while(i < n1 || j < n2 || carries[1] > 0 || carries[0] > 0) {
        	int sum = carries[0];
        	if (i < n1) {
        		sum += arr1[i];
        		i++;
        	}
        	if (j < n2) {
        		sum += arr2[j];
        		j++;
        	}
        	carries[1] = carries[0];
        	carries[0] = 0;
        	if (sum > 1) carries[0] = 1;
        	if (sum == 2 || sum == 3) carries[1] += 1;
        	if (sum == 3) sum = 1;
        	else if (sum == 2 || sum == 4) sum = 0;
        	list.add(sum);
        }
        int n = list.size();
        int[] result = new int[n];
        for (int k = 0; k < n; k++) result[k] = list.get(n - k - 1);
        return result;
    }
	
	private void reverse(int[] arr) {
		int i = 0, j = arr.length - 1;
		while(i < j) swap(arr, i++, j--);
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
