package com.leet.algo;

/**
 * Created by ayanc on 11/15/17.
 */
public class Prob495 {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if(timeSeries == null || timeSeries.length == 0) return 0;
    int result = 0;
    int runningDuration = timeSeries[0];
    for(int i = 0; i < timeSeries.length; i++){
      if(timeSeries[i] >= runningDuration){
        runningDuration = timeSeries[i] + duration;
        result += duration;
      } else {
        result +=  timeSeries[i] + duration - runningDuration;
        runningDuration = timeSeries[i] + duration;

      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob495 prob495 = new Prob495();
    System.out.println(prob495.findPoisonedDuration(new int[]{1,2}, 2));
  }
}
