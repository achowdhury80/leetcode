package com.leet.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 11/15/17.
 */
public class Prob451 {
  public String frequencySort(String s) {
    if(s == null || s.length() == 0) return s;
    Map<Character, Integer> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int size = map.keySet().size();
    MaxHeap heap = new MaxHeap(size);
    for(char c : map.keySet()){
      heap.add(new Info(c, map.get(c)));
    }
    String result = "";
    for(int i = 0; i < size; i++) {
      Info info = heap.remove();
      result = result + info.getVal();
    }
    return result;
  }

  class MaxHeap {
    int n = 0;
    Info[] arr = null;
    MaxHeap(int size){
      arr = new Info[size];
    }

    public void add(Info info){
      arr[n] = info;
      int k = n;
      n++;
      while (k > 0) {
        int parent = (k - 1) / 2;
        if (arr[parent].count < arr[k].count) {
          swap(parent, k);
          k = parent;
        } else break;
      }
    }
    private void swap(int i, int j){
      Info temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    public Info remove(){
      Info result = arr[0];
      arr[0] = arr[n - 1];
      n--;
      int k = 0;
      while(k < n){
        int left = 2 * k + 1;
        int right = left + 1;
        if(left < n && right < n){
          int max = left;
          if(arr[max].count < arr[right].count) max = right;
          if(arr[k].count > arr[max].count) break;
          swap(k, max);
          k = max;
        } else if(left >= n && right >= n) break;
        else if(left < n){
          if(arr[k].count > arr[left].count) break;
          else {
            swap(k, left);
            k = left;
          }
        } else {
          if(arr[k].count > arr[right].count) break;
          else {
            swap(k, right);
            k = right;
          }
        }
      }
      return result;
    }
  }

  class Info {
    char c;
    int count;

    Info(char c, int count) {
      this.c = c;
      this.count = count;
    }

    public String getVal() {
      StringBuilder result = new StringBuilder("");
      for (int i = 0; i < count; i++) {
        result.append(c);
      }
      return result.toString();
    }
  }

  public static void main(String[] args){
    Prob451 prob451 = new Prob451();
    System.out.println(prob451.frequencySort("tree"));
    System.out.println(prob451.frequencySort("cccaaa"));
    System.out.println(prob451.frequencySort("Aabb"));
  }

}
