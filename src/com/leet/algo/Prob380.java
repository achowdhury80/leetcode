package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by ayanc on 12/10/17.
 */
public class Prob380 {

  //private Map<Integer, Integer> positionValueMap;
  private Map<Integer, Integer> valuePositionMap;
  private List<Integer> list;
  private Random random;
  Integer count = null;

  public Prob380() {
    this.valuePositionMap = new HashMap<>();
    list = new ArrayList<>();
    random = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(valuePositionMap.containsKey(val)) return false;
    list.add(val);
    valuePositionMap.put(val, list.size() - 1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!valuePositionMap.containsKey(val)) return false;
    int last = list.get(list.size() - 1);
    int pos = valuePositionMap.get(val);
    valuePositionMap.put(last, pos);
    list.set(pos, last);
    list.remove(list.size() - 1);
    valuePositionMap.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    if(list.size() == 0) return -1;
    int randomNumber = random.nextInt(list.size());
    return list.get(randomNumber);
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
