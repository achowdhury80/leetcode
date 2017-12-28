package com.leet.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ayanc on 12/10/17.
 */
public class Prob380 {

  private Map<Integer, Integer> positionValueMap;
  private Map<Integer, Integer> valuePositionMap;
  Integer count = null;

  public Prob380() {
    this.positionValueMap = new HashMap<>();
    this.valuePositionMap = new HashMap<>();
    count = 0;
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(valuePositionMap.containsKey(val)) return false;
    count++;
    valuePositionMap.put(val, count);
    positionValueMap.put(count, val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(count == 0 || !valuePositionMap.containsKey(val)) return false;
    int position = valuePositionMap.get(val);
    if(count > 1){
      if(position == count){
        positionValueMap.remove(position);
        valuePositionMap.remove(val);
      } else {
        positionValueMap.remove(position);
        valuePositionMap.remove(val);
        int lastValue = positionValueMap.get(count);
        positionValueMap.put(position, lastValue);
        valuePositionMap.put(lastValue, position);
      }
    } else {
      this.positionValueMap.clear();
      this.valuePositionMap.clear();
    }
    count--;
    return true;

  }

  /** Get a random element from the set. */
  public int getRandom() {
    if(count == 0) return -1;
    int randomNumber = new Random().nextInt(count) + 1;
    System.out.println("randomNumber:" + randomNumber);
    System.out.println("count:" + count);
    return positionValueMap.get(randomNumber);
  }

  public static void main(String[] args){
    Prob380 prob380 = new Prob380();
    System.out.println(prob380.insert(1));
    System.out.println(prob380.remove(2));
    System.out.println(prob380.insert(2));
    System.out.println(prob380.getRandom());
    System.out.println(prob380.remove(1));
    System.out.println(prob380.insert(2));
    System.out.println(prob380.getRandom());
  }
}
