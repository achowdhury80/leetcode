package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob697 {
  public int findShortestSubArray(int[] nums) {
    if(nums == null || nums.length < 1) return 0;
    if(nums.length == 1) return 1;
    Map<Integer, Info> map = new HashMap<>();
    int result = 0;
    int count = 0;
    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i])){
        Info info = map.get(nums[i]);
        info.count++;
        info.end = i;
        if(count < info.count){
          count = info.count;
          result = info.end - info.start + 1;
        } else if(count == info.count && result > info.end - info.start + 1){
          result = info.end - info.start + 1;
        }
      } else {
        Info info = new Info();
        info.count = 1;
        info.start = i;
        info.end = i;
        map.put(nums[i], info);
        if(count < info.count){
          count = 1;
          result = 1;
        }
      }
    }
    return result;

  }

  class Info{
    int count, start, end;
  }
}
