package comp.prep2019.less2000;

public class Prob1122 {
	/**
	 * O(N) time and space
	 * find freq and keep it in array
	 * first refill arr1 from let with taking elements order from 2
	 * then push rest of the elements in sorted order
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int a : arr1) arr[a]++;
        int left = 0;
        for (int i = 0; i < arr2.length; i++) {
        	while(arr[arr2[i]] > 0) {
        		arr[arr2[i]]--;
        		arr1[left++] = arr2[i];
        	}
        }
        for (int i = 0; i < arr.length; i++) {
        	while (arr[i] > 0) {
        		arr[i]--;
        		arr1[left++] = i;
        	}
        }
        return arr1;
    }
	
}
