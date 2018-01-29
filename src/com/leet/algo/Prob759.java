package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/25/18.
 */
public class Prob759 {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> result = new ArrayList<>();
    if(schedule == null || schedule.size() < 1) return result;
    ListNode root = new ListNode(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
    for(List<Interval> e : schedule){
      ListNode current = root;
      for(Interval interval : e){
        ListNode[] collidingNodes = findCollidingNodes(current, interval);
        current = adjustNodes(collidingNodes, interval, current);
      }
    }
    ListNode current = root.next;
    if(current == null) return result;
    while (current.interval.end != Integer.MAX_VALUE){
      result.add(current.interval);
      current = current.next;
    }
    return result;
  }

  private ListNode[] findCollidingNodes(ListNode current, Interval interval){
    ListNode[] result = new ListNode[2];
    while(current.interval.end <= interval.start){
      current = current.next;
      if(current.interval.start >= interval.end) return result;
    }
    result[0] = current;
    ListNode last = current;
    while(current != null && current.interval.start < interval.end){
      last = current;
      current = current.next;
    }
    result[1] = last;
    return result;
  }

  private ListNode adjustNodes(ListNode[] nodes, Interval interval, ListNode current){
    if(nodes[0] == null) return current;
    ListNode beforeStart = null;
    Integer nodes_1_end = null;
    if(nodes[0].interval.start < interval.start){
      if(nodes[0].parent == null) {
        beforeStart = nodes[0];
        if(nodes[0] == nodes[1]){
          nodes_1_end = nodes[1].interval.end;
        }
        beforeStart.interval.end = interval.start;
      } else {
        beforeStart = new ListNode(new Interval(nodes[0].interval.start, interval.start));
        nodes[0].parent.next = beforeStart;
        beforeStart.parent = nodes[0].parent;
      }
    }
    ListNode afterEnd = null;
    if((nodes_1_end == null ? nodes[1].interval.end : nodes_1_end) > interval.end){
      afterEnd = new ListNode(new Interval(interval.end, (nodes_1_end == null ? nodes[1].interval.end : nodes_1_end)));
      afterEnd.next = nodes[1].next;
      if(nodes[1].next != null) nodes[1].next.parent = afterEnd;
    }
    if(beforeStart == null && afterEnd == null){
      nodes[0].parent.next = nodes[1].next;
      nodes[1].next.parent = nodes[0].parent;
      return nodes[0].parent;
    } else if(beforeStart == null){
      nodes[0].parent.next = afterEnd;
      afterEnd.parent = nodes[0].parent;
      return afterEnd;
    } else if(afterEnd == null){
      beforeStart.next = nodes[1].next;
      if(nodes[1].next == null){
        System.out.println();
      }
      nodes[1].next.parent = beforeStart;
      return beforeStart;
    } else {
      beforeStart.next = afterEnd;
      afterEnd.parent = beforeStart;
      return afterEnd;
    }
  }



  class ListNode{
    Interval interval;
    ListNode next;
    ListNode parent;
    ListNode(Interval interval){
      this.interval = interval;
    }
  }

  static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

  public static void main(String[] args){
    Prob759 prob759 = new Prob759();
      List<List<Interval>> schedule = null;
      List<Interval> intervals = null;
    schedule = new ArrayList<>();
    intervals = new ArrayList<>();
    intervals.add(new Interval(1,2));
    intervals.add(new Interval(5,6));
    schedule.add(intervals);
    intervals = new ArrayList<>();
    intervals.add(new Interval(1,3));
    schedule.add(intervals);
    intervals = new ArrayList<>();
    intervals.add(new Interval(4,10));
    schedule.add(intervals);
    System.out.println(prob759.employeeFreeTime(schedule));


    schedule = new ArrayList<>();
    intervals = new ArrayList<>();
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(6,7));
    schedule.add(intervals);
    intervals = new ArrayList<>();
    intervals.add(new Interval(2,4));
    schedule.add(intervals);
    intervals = new ArrayList<>();
    intervals.add(new Interval(2,5));
    intervals.add(new Interval(9,12));
    schedule.add(intervals);
    System.out.println(prob759.employeeFreeTime(schedule));
  }


}
