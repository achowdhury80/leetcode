package com.leet.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 12/6/17.
 */
public class Prob621 {
  public int leastInterval(char[] tasks, int n) {
    if(tasks == null || tasks.length == 0) return 0;
    int count = 0;
    Queue<Character> lastRunQ = new LinkedList<>();
    Queue<Character> taskQ = new LinkedList<>();
    for(int i = 0; i < tasks.length; i++){
      taskQ.add(tasks[i]);
    }
    while(!taskQ.isEmpty()){
      boolean ran = false;
      for(int i = 0; i < taskQ.size(); i++){
        if(!lastRunQ.contains(taskQ.peek())){
          char c = taskQ.remove();
          System.out.print(c + "->");
          count++;
          ran = true;
          addToLastRunQ(lastRunQ, c, n);
          break;
        } else {
          char c = taskQ.remove();
          taskQ.add(c);
        }
      }
      if(!ran){
        count++;
        System.out.print("Idle->");
        addToLastRunQ(lastRunQ, '0', n);
      }
    }
    System.out.println();
    return count;
  }

  public void addToLastRunQ(Queue<Character> lastRunQ, char c, int n){
    if(lastRunQ.size() < n){
      lastRunQ.add(c);
    }else{
      lastRunQ.add(c);
      lastRunQ.remove();
    }
  }

  public static void main(String[] args){
    Prob621 prob621 = new Prob621();
    System.out.println(prob621.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
  }
}
