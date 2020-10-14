package comp.prep2019;

public class Prob4 {
	/**
	 * https://www.youtube.com/watch?v=LPFhl65R7ww
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		int x = nums1.length, y = nums2.length;
		// here low and high signifies number of elements to be taken
		int low = 0, high = nums1.length;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int partitionY = (x + y + 1) / 2 - mid;
			int maxLeftX = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
			int minRightX = mid == nums1.length ? Integer.MAX_VALUE : nums1[mid];
			
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE 
					: nums2[partitionY - 1];
			int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE 
					: nums2[partitionY];
			
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (0. + Math.max(maxLeftX, maxLeftY) 
						+ Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) high = mid - 1;
			else low = mid + 1;
		}
		throw new IllegalArgumentException();
    }
}
