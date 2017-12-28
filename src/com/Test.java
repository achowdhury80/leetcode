package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 5/30/17.
 */
public class Test {
  public static void main(String[] args){
//    List<String> list = Arrays.asList(new String[] {"abc", "bcd", "def"});
//    List<String> list1 = list.stream().filter(s -> s.contains("x")).collect(Collectors.toList());
    //System.out.println(list1.stream().findFirst().ifPresent(););
    //System.out.println(Integer.toBinaryString(1));
    System.out.println(new Test().missingNumber(new int[]{0, 2}));
  }

  public int missingNumber(int[] nums) {
    if(nums == null || nums.length == 0) return -1;
    boolean lastNumFound = false;
    boolean firstNumFound = false;
    for(int i = 0; i < nums.length; i++){
      int index = Math.abs(nums[i]);
      if(index == nums.length){
        lastNumFound = true;
      } else if(nums[index] > -1){
        nums[index] = 0 - nums[index];
      }
    }
    if(!lastNumFound) return nums.length;
    if(!firstNumFound) return 0;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] > 0){
        return i;
      }
    }
    return -1;
  }
}
