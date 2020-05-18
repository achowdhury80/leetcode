package comp.prep2019;

public class Prob852 {
	/**
	 * O(logN)
	 * since mountain array and pivot > 0 and pivot < arr.length - 1
	 * low = 1 and high = n - 2
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArray(int[] A) {
        int i = 1, j = A.length - 2;
        while(i <= j) {
        	int mid = i + (j - i) / 2;
        	if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
        	if (A[mid] < A[mid + 1]) i = mid + 1;
        	else j = mid - 1;
        }
        return -1;
    }
}
