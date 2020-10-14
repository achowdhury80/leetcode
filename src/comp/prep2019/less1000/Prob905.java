package comp.prep2019.less1000;

public class Prob905 {
	/**
	 * O(N) time
	 * in each turn either move start by 1 to find odd number or end by -1 to find
	 * even number
	 * or swap start and end
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        while(start < end) {
        	if (A[start] % 2 == 0) {
        		++start;
        		continue;
        	}
        	if (A[end] % 2 == 1) {
        		--end;
        		continue;
        	}
        	swap(A, start, end);
        }
        return A;
    }
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
