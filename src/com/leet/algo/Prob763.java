package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob763 {
  public List<Integer> partitionLabels(String S) {
    List<Integer> list = new ArrayList<>();
    if(S == null || S.length() < 1){
      list.add(0);
      return list;
    } else if(S.length() == 1){
      list.add(1);
      return list;
    }
    ListNode head = new ListNode("" + S.charAt(0));
    Map<Character, ListNode> map = new HashMap<>();
    map.put(S.charAt(0), head);
    char[] chars = S.toCharArray();
    ListNode node = head;
    for(int i = 1; i < chars.length; i++){
      if(map.containsKey(chars[i])){
        ListNode start = map.get(chars[i]);
        ListNode mover = start;
        while(mover.next != null){
          mover = mover.next;
          for(char c : mover.str.toCharArray()){
            map.put(c, start);
          }
          start.str += mover.str;

        }
        start.str += chars[i];
        start.next = null;
        node = start;
      } else {
        node.next = new ListNode("" + chars[i]);
        map.put(chars[i], node.next);
        node = node.next;
      }
    }
    node = head;
    while (node != null) {
      list.add(node.str.length());
      node = node.next;
    }
    return list;
  }

  class ListNode {
    String str;
    ListNode next;

    ListNode(String str) {
      this.str = str;
    }
  }

  public static void main(String[] args){
    Prob763 prob763 = new Prob763();
    System.out.println(prob763.partitionLabels("ababcbacadefegdehijhklij"));
  }
}
