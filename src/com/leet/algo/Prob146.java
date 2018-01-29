package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/26/18.
 */
public class Prob146 {

  private int capacity;
  private Map<Integer, ListNode> map = new HashMap<>();
  private ListNode root = null;
  private ListNode last = null;
  private int count = 0;
  public Prob146(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if(count == 0) return -1;
    ListNode node = map.getOrDefault(key, null);
    if(node == null) {
      if(root.key == key) {
        if(last == root){
          return root.value;
        }
        last.next = root;
        map.put(key, last);
        last = last.next;
        root = root.next;
        map.put(root.key, null);
        last.next = null;
        return last.value;
      } else {
        return -1;
      }
    }
    ListNode targetNode = node.next;
    if(targetNode == last){
      return targetNode.value;
    }
    last.next = targetNode;
    map.put(key, last);
    last = last.next;
    node.next = targetNode.next;
    last.next = null;
    map.put(node.next.key, node);
    return targetNode.value;
  }

  public void put(int key, int value) {
    if(capacity < 1) return;
    ListNode newNode = new ListNode(key, value);
    if(root == null){
      root = newNode;
      last = newNode;
      map.put(key, null);
      count++;
      return;
    }
    ListNode node = map.getOrDefault(key, null);
    if(node == null) {
      if(root.key == key) {
        if(last == root){
          root.value = value;
          return;
        }
        last.next = root;
        map.put(key, last);
        last = last.next;
        root = root.next;
        map.put(root.key, null);
        last.next = null;
        last.value = value;
        return;
      }
      last.next = new ListNode(key, value);
      map.put(key, last);
      last = last.next;
      count++;
      if(count > capacity){
        map.remove(root.key);
        root = root.next;
        map.put(root.key, null);
        count--;
      }
    } else {
      ListNode targetNode = node.next;
      if(targetNode == last){
        targetNode.value = value;
        return;
      }
      last.next = targetNode;
      map.put(key, last);
      last = last.next;
      node.next = targetNode.next;
      last.next = null;
      map.put(node.next.key, node);
      targetNode.value = value;
    }


  }

  class ListNode {
    int key;
    int value;
    ListNode next;

    ListNode(int key, int value){
      this.key = key;
      this.value = value;
    }
  }
}
