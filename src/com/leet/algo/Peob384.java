package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Peob384 {
  int[] original;
  public Peob384(int[] nums) {
    this.original =nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return original;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    if(original == null || original.length < 2) return original;
    List<Integer> list = new ArrayList<>();
    IntStream.range(0, original.length).forEach(x -> list.add(x));
    Random random = new Random();
    int[] result = new int[original.length];
    for(int i = 0; i < original.length; i++){
      int nextIndex = random.nextInt(list.size());
      result[list.remove(nextIndex)] = original[i];
    }
    return result;
  }
}
