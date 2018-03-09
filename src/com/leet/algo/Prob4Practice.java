package com.leet.algo;

/**
 * Created by ayanc on 3/4/18.
 */
public class Prob4Practice {
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
    int halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int iMid = iMin + (iMax - iMin) / 2;
      int jMid = halfLen - iMid;
      if (iMid > 0 && nums1[iMid - 1] > nums2[jMid]) iMax = iMid - 1;
      else if (iMid < m && nums2[jMid - 1] > nums1[iMid]) iMin = iMid + 1;
      else {
        int maxOfLeft;
        if (iMid == 0) maxOfLeft = nums2[jMid - 1];
        else if (jMid == 0) maxOfLeft = nums1[iMid - 1];
        else maxOfLeft = Math.max(nums1[iMid - 1], nums2[jMid - 1]);
        if ((m + n) % 2 == 1) return maxOfLeft;
        int minOfRignt;
        if (iMid == m) minOfRignt = nums2[jMid];
        else if (jMid == n) minOfRignt = nums1[iMid];
        else minOfRignt = Math.max(nums1[iMid], nums2[jMid]);
        return (maxOfLeft + minOfRignt) / 2.0;
      }
    }
    return -1;
  }
}
