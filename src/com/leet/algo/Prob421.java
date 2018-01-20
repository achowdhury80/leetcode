package com.leet.algo;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob421 {
  private TrieNode root = new TrieNode();
  public int findMaximumXOR(int[] nums) {
    for (int num : nums) addNum(num);
    TrieNode[] left = new TrieNode[2];
    TrieNode[] right = new TrieNode[2];
    int result = 0;
    for(int i = 0; i < 32; i++){
      //if(le)
    }

    return result;
  }


  public void addNum(int num) {
    int i = 0;
    TrieNode node = root;
    int mask = 1 << 31;
    while (i < 32){
      if((num & mask) == 0){
        if(node.arr[0] == null){
          node.arr[0] = new TrieNode();
        }
        node = node.arr[0];
      } else {
        if(node.arr[1] == null){
          node.arr[1] = new TrieNode();
        }
        node = node.arr[1];
      }
    }

  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[2];
  }
}
