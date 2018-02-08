package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/6/17.
 */
public class Prob621 {
  public int leastInterval(char[] tasks, int n) {
    int totalTaskCount;
    if(tasks == null || (totalTaskCount = tasks.length) == 0) return 0;
    int[] taskCount = new int[26];
    IntStream.range(0, tasks.length).forEach(idx -> taskCount[tasks[idx] - 'A']++);
    int count = 0;
    List<Character> taskToBeIgnored = new ArrayList<>();
    while (totalTaskCount > 0) {
      Character nextTask = findNextTask(taskCount, taskToBeIgnored);
      count++;
      if (nextTask == null) {
        taskToBeIgnored.add((char)('A' - 1));
      }
      else {
        totalTaskCount--;
        taskCount[nextTask - 'A']--;
        if (n > 0) taskToBeIgnored.add(nextTask);
      }
      if (taskToBeIgnored.size() > n) taskToBeIgnored.remove(0);
    }
    return count;
  }

  private Character findNextTask(int[] taskCount, List<Character> taskToBeIgnored) {
    Character next = null;
    int maxCount = 0;
    for (int i = 0; i < 26; i++) {
      if (taskCount[i] != 0 && !taskToBeIgnored.contains((char)(i + 'A'))) {
        if (maxCount < taskCount[i]) {
          maxCount = taskCount[i];
          next = (char)(i + 'A');
        }
      }
    }
    return next;
  }

  public static void main(String[] args){
    Prob621 prob621 = new Prob621();
    System.out.println(prob621.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
  }
}
