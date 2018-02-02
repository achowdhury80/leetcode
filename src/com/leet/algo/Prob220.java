package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/1/18.
 */
public class Prob220 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0) return false;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++){
      long mappedNum = (long)nums[i] - Integer.MIN_VALUE;
      long bucket = mappedNum / ((long)t + 1);
      if (map.containsKey(bucket) || map.containsKey(bucket - 1) && mappedNum - map.get(bucket - 1) <= t
        || map.containsKey(bucket + 1) && map.get(bucket + 1) - mappedNum <= t) return true;
      if (map.entrySet().size() >= k) {
        long lastBucket = (nums[i - k] - (long)Integer.MIN_VALUE) / ((long) t + 1);
        map.remove(lastBucket);
      }
      map.put(bucket, mappedNum);
    }
    return false;
  }

  public static void main(String[] args){
    Prob220 prob220 = new Prob220();
    System.out.println(prob220.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0));
    System.out.println(prob220.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
  }
}
