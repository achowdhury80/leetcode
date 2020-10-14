package comp.prep2019;

public class Prob88 {
	/**
	 * O(m + n) time
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, i = m - 1, j = n - 1;
        while(i > - 1 && j > -1) {
        	if (nums1[i] >= nums2[j]) {
        		nums1[idx--] = nums1[i--];
        	} else nums1[idx--] = nums2[j--];
        }
        while(i > - 1) nums1[idx--] = nums1[i--];
        while(j > -1) nums1[idx--] = nums2[j--];
    }
}
