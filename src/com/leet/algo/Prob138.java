package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob138 {
  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) return head;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    map.put(null, null);
    RandomListNode node = head;
    while(node != null){
      RandomListNode newNode = new RandomListNode(node.label);
      map.put(node, newNode);
      node = node.next;
    }
    node = head;
    while(node != null){
      RandomListNode newNode = map.get(node);
      newNode.next = map.get(node.next);
      newNode.random = map.get(node.random);
      node = node.next;
    }
    return map.get(head);
  }

  class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
  }
}
