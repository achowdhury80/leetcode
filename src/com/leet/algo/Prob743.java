package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/15/18.
 */
public class Prob743 {
  public int networkDelayTime(int[][] times, int N, int K) {
    MinHeap minHeap = new MinHeap(N);
    Map<Integer, List<int[]>> map = new HashMap<>();
    Arrays.stream(times).forEach(intArr -> {
      List<int[]> list;
      if(map.containsKey(intArr[0])){
        list = map.get(intArr[0]);
      } else list = new ArrayList<int[]>();
      list.add(new int[]{intArr[1], intArr[2]});
      map.put(intArr[0], list);
    });
    Set<Integer> explored = new HashSet<>();
    if(!map.containsKey(K)) return -1;
    explored.add(K);
    addVertexToHeap(map, new Node(K, 0), explored, minHeap);
    int result = Integer.MIN_VALUE;
    while(explored.size() < N){
      if(minHeap.isEmpty()) return -1;
      Node node = minHeap.extractMin();
      result = Math.max(result, node.value);
      explored.add(node.vertex);
      minHeap.deleteNode(node.vertex);
      addVertexToHeap(map, node, explored, minHeap);
    }
    return result;
  }

  private void addVertexToHeap(Map<Integer, List<int[]>> map, Node source, Set<Integer> explored, MinHeap minHeap){
    if(!map.containsKey(source.vertex)) return;
    List<int[]> edges = map.get(source.vertex);
    for(int[] edge : edges){
      if(explored.contains(edge[0])) continue;
      if(minHeap.contains(edge[0])){
        minHeap.update(edge[0], source.value + edge[1]);
      } else {
        minHeap.insert(new Node(edge[0], source.value + edge[1]));
      }
    }
  }

  class MinHeap {
    Node[] nodes;
    int last = -1;
    int[] loc;
    MinHeap(int n){
      nodes = new Node[n];
      loc = new int[n + 1];
      IntStream.range(0, n + 1).forEach(x -> loc[x] = -1);
    }

    void delete(int index){
      if(index > last) return;
      loc[nodes[index].vertex] = -1;
      if(last == index) {
        last--;
        return;
      }
      nodes[index] = nodes[last--];
      loc[nodes[index].vertex] = index;
      if(index == 0){
        goDown(index);
        return;
      }
      int parent = (index - 1) / 2;
      if(nodes[index].value > nodes[parent].value){
        goUp(index);
        return;
      }
      else {
        goDown(index);
      }
    }

    void insert(Node node){
      if(last == 14){
        System.out.println("hellow");
      }
      nodes[++last] = node;
      loc[node.vertex] = last;
      goUp(last);
    }

    void goUp(int index){
      Node node = nodes[index];
      int parent = (index - 1) / 2;
      int current = index;
      while(parent > -1){
        if(nodes[parent].value <= node.value) return;
        swap(parent, current);
        current = parent;
        parent = (parent - 1) / 2;
      }
    }

    void goDown(int index){
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int current = index;
      while(left <= last){
        int min = left;
        if(right >= last){
          min = nodes[left].value < nodes[right].value ? left : right;
        }
        if(nodes[min].value < nodes[current].value) {
          swap(min, current);
        } else return;
        current = min;
        left = 2 * current + 1;
        right = 2 * current + 2;
        current = min;
      }
    }

    Node extractMin(){
      Node node = nodes[0];
      delete(0);
      return node;
    }

    boolean isEmpty(){
      return last == -1;
    }

    void swap(int i, int j){
      loc[nodes[i].vertex] = j;
      loc[nodes[j].vertex] = i;
      Node temp = nodes[i];
      nodes[i] = nodes[j];
      nodes[j] = temp;
    }

    void update(int vertex, int newValue){
      if(isEmpty()) return;
      if(loc[vertex] < 0) return;
      if(nodes[loc[vertex]].value <= newValue) return;
      delete(loc[vertex]);
      insert(new Node(vertex, newValue));
    }

    boolean contains(int vertex){
      return loc[vertex] > -1;
    }

    void deleteNode(int vertex){
      if(!contains(vertex)) return;
      delete(loc[vertex]);
    }

  }

  class Node {
    public Node(int vertex, int value) {
      this.vertex = vertex;
      this.value = value;
    }

    int vertex;
    int value;

  }

  public static void main(String[] args){
    Prob743 prob743 = new Prob743();
//    System.out.println(prob743.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    System.out.println(prob743.networkDelayTime(new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},
        {1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},
        {2,4,77},{5,2,74}}, 5, 3));

//    System.out.println(prob743.networkDelayTime(new int[][]{{15,8,1},{7,10,41},{7,9,34},{9,4,31},{12,13,50},{14,3,52},
//        {4,11,99},{4,7,86},{10,13,57},{9,6,10},{1,7,51},{7,15,38},{1,9,11},{12,7,94},{9,13,34},{11,7,79},{7,6,28},
//        {5,3,34},{2,6,97},{14,1,97},{6,10,90},{12,10,37},{13,3,73},{11,14,7},{15,1,39},{6,5,90},{13,6,43},{6,9,32},
//        {4,6,45},{11,10,2},{2,13,4},{14,15,29},{1,14,88},{14,6,19},{6,2,29},{3,14,72},{1,15,4},{11,5,2},{6,7,56},
//        {8,7,88},{13,14,70},{14,12,58},{14,2,86},{11,3,57},{5,2,56},{3,10,26},{2,11,21},{14,5,54},{5,12,40},{14,4,81},
//        {15,2,99},{5,7,57},{13,12,5},{4,9,60},{12,15,48},{6,14,1},{9,7,44},{13,7,69},{5,13,42},{4,1,7},{11,9,76},
//        {8,1,76},{5,14,29},{2,3,69},{7,3,23},{12,14,28},{11,4,85},{10,1,10},{15,12,36},{1,11,69},{15,10,96},{11,13,69},
//        {7,12,49},{1,2,95},{6,4,46},{8,12,94},{12,4,93},{13,5,31},{12,2,60},{6,1,87},{4,14,20},{5,11,89},{4,15,88},
//        {4,10,21},{1,6,5},{10,8,26},{8,2,51},{3,15,23},{7,2,12},{11,1,47},{2,1,75},{3,8,63},{8,10,19},{6,8,18},{4,2,55},
//        {14,11,80},{10,3,73},{3,5,22},{12,3,61},{1,13,33},{9,3,98},{9,12,69},{15,9,6},{7,13,76},{11,12,22},{11,15,51},
//        {13,15,46},{5,10,58},{1,10,26},{13,4,85},{7,14,58},{5,8,46},{11,6,32},{10,9,41},{9,14,35},{14,13,60},{3,9,97},
//        {2,5,39},{7,11,19},{1,12,27},{7,5,13},{8,4,34},{9,15,25},{5,1,93},{15,13,97},{14,9,35},{8,6,67},{9,5,39},
//        {13,11,35},{7,4,21},{12,9,64},{14,8,8},{10,12,94},{8,9,76},{8,5,71},{2,9,64},{10,14,59},{1,4,74},{7,1,69},
//        {15,5,55},{6,15,80},{13,8,84},{8,13,63},{8,3,91},{10,4,87},{1,5,39},{8,11,0},{1,3,79},{4,5,82},{4,12,87},
//        {3,11,29},{7,8,92},{10,7,77},{6,12,42},{13,2,40},{9,10,13},{4,13,65},{2,4,34},{3,13,44},{2,14,69},{3,4,42},
//        {5,15,98},{14,7,6},{15,3,94},{10,2,37},{15,11,7},{9,2,15},{13,9,66},{4,8,83},{8,15,23},{13,1,50},{6,13,57},
//        {2,10,37},{10,6,38},{2,7,45},{9,8,8},{3,12,28},{3,2,83},{2,12,75},{1,8,91},{4,3,70},{12,6,48},{3,1,13},{5,6,42},
//        {6,11,96},{3,6,22},{15,6,34},{11,8,43},{15,7,40},{9,11,57},{11,2,11},{2,8,22},{9,1,73},{2,15,40},{12,11,10},
//        {15,4,78},{12,8,75},{10,15,37},{13,10,44},{8,14,33},{3,7,82},{5,4,46},{12,5,79},{15,14,43},{10,5,65},{5,9,34},
//        {12,1,54},{6,3,16},{14,10,83},{10,11,67}}, 15, 8));
  }
}
