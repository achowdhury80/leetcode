package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob275 {
  public int hIndex(int[] citations) {
    if(citations == null || citations.length < 1) return 0;
    int accCount = 0;
    int numCitations = citations[citations.length - 1];
    int result = 0;
    for(int i = citations.length - 1; i > -1; i--){
      numCitations = citations[i];
      accCount += 1;
      result = Math.max(result, Math.min(accCount, numCitations));
      if(numCitations == accCount) return numCitations;
    }
    return result;
  }
}
