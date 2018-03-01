package com.leet.algo;

/**
 * Created by ayanc on 2/26/18.
 */
public class Prob4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m, n;
    if (nums1 == null && nums2 == null ||  (m = nums1.length) < 1 && (n = nums2.length) < 1) throw new IllegalArgumentException();
    if (nums2 == null || (n = nums2.length) < 1) {
      return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
    }
    if (nums1 == null || (m = nums1.length) < 1){
      return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
    }
    if (m > n) return findMedianSortedArrays(nums2, nums1);
    int iMin = 0, iMax = m;
    int i, j;
    while (iMin <= iMax) {
      i = (iMin + iMax) / 2;
      j = (m + n + 1) / 2 - i;
      if (i > 0 && nums1[i - 1] > nums2[j]) iMax = i - 1;
      else if (i < m && nums2[j - 1] > nums1[i]) iMin = i + 1;
      else {
        int maxOfLeft = 0;
        if (i == 0) maxOfLeft = nums2[j - 1];
        else if (j == 0) maxOfLeft = nums1[i - 1];
        else maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        if ((m + n) % 2 == 1) return maxOfLeft;
        int minOfRight;
        if (i == m) minOfRight = nums2[j];
        else if (j == n) minOfRight = nums1[i];
        else minOfRight = Math.min(nums1[i], nums2[j]);
        return (maxOfLeft + minOfRight) / 2.0;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Prob4 prob4 = new Prob4();
    System.out.println(prob4.findMedianSortedArrays(new int[]{1}, new int[]{1}));
  }
}
