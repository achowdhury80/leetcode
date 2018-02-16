package com.leet.algo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob362 {
  private Map<Integer, Integer> map;
  /** Initialize your data structure here. */
  public Prob362() {
    map = new ConcurrentHashMap<>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    int start = timestamp - 300;
    int result = 0;
    for (int key : map.keySet()) {
      if (key > start) result += map.get(key);
      else map.remove(key);
    }
    return result;
  }

  public static void main(String[] args) {
    Prob362 prob362 = new Prob362();
    prob362.hit(1);
    prob362.hit(2);
    prob362.hit(3);
    System.out.println(prob362.getHits(4));
    prob362.hit(300);
    System.out.println(prob362.getHits(300));
    System.out.println(prob362.getHits(301));

  }
}
/**
 * Design Hit Counter
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Design a hit counter which counts the number of hits received in the past 5 minutes.

 Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

 It is possible that several hits arrive roughly at the same time.

 Example:
 HitCounter counter = new HitCounter();

 // hit at timestamp 1.
 counter.hit(1);

 // hit at timestamp 2.
 counter.hit(2);

 // hit at timestamp 3.
 counter.hit(3);

 // get hits at timestamp 4, should return 3.
 counter.getHits(4);

 // hit at timestamp 300.
 counter.hit(300);

 // get hits at timestamp 300, should return 4.
 counter.getHits(300);

 // get hits at timestamp 301, should return 3.
 counter.getHits(301);
 Follow up:
 What if the number of hits per second could be very large? Does your design scale?

 Credits:
 Special thanks to @elmirap for adding this problem and creating all test cases.
 */
