package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob454 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    final int MAX = 227;
    final int MIN = -228;
    final int NUMBER_OF_SERIES = 4;
    if(A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null
        || D.length == 0) return 0;
    int n = A.length;

    int[][] allArr = new int[NUMBER_OF_SERIES][];
    allArr[0] = A;
    allArr[1] = B;
    allArr[2] = C;
    allArr[3] = D;

    final  Map<Integer, Integer> currentMap = new HashMap<>();
    Map<Integer, Integer> resultMap = null;
    int maxThreshold = (NUMBER_OF_SERIES / 2) * (0 - MIN);
    int minThreshold = (NUMBER_OF_SERIES / 2) * (0 - MAX);
    //System.out.println(maxThreshold);
    //System.out.println(minThreshold);
    for(int i = 0; i < (allArr.length + 1)/2; i++){
      currentMap.clear();
      Arrays.stream(allArr[i]).forEach(x -> currentMap.put(x, currentMap.get(x) == null ? 1 : currentMap.get(x) + 1));
      if(resultMap == null) {
        (resultMap = new HashMap<>()).putAll(currentMap);
      } else {
        Map<Integer, Integer> previousMap = resultMap;
        resultMap = new HashMap<>();
        //System.out.println("previousMap: " + previousMap);
        //System.out.println("currentMap: " + currentMap);
        for(Integer previousKey : previousMap.keySet()){
          for(Integer currentKey : currentMap.keySet()){
            Integer newKey = previousKey + currentKey;
            //System.out.println("newKey: " + newKey);
            if(newKey <= maxThreshold && newKey >= minThreshold){
              resultMap.put(newKey, resultMap.getOrDefault(newKey, 0) + previousMap.get(previousKey) * currentMap.get(currentKey));
            }
          }
        }
      }

    }

    //System.out.println("resultMap: " + resultMap);
    for(int i = (allArr.length + 1)/2; i < allArr.length; i++){
      currentMap.clear();
      Arrays.stream(allArr[i]).forEach(x -> currentMap.put(x, currentMap.get(x) == null ? 1 : currentMap.get(x) + 1));

      Map<Integer, Integer> previousMap = resultMap;

      resultMap = new HashMap<>();
      maxThreshold = (NUMBER_OF_SERIES - i - 1) * (0 - MIN);
      minThreshold = (NUMBER_OF_SERIES - i - 1) * (0 - MAX);
//      System.out.println("max: " + maxThreshold);
//      System.out.println("min:" + minThreshold);
//      System.out.println("previousMap: " + previousMap);
//      System.out.println("currentMap: " + currentMap);
      for(Integer previousKey : previousMap.keySet()){
        for(Integer currentKey : currentMap.keySet()){
          Integer newKey = previousKey + currentKey;
          if(newKey <= maxThreshold && newKey >= minThreshold){
            resultMap.put(newKey, resultMap.getOrDefault(newKey, 0) + previousMap.get(previousKey) * currentMap.get(currentKey));
          }
        }
      }
    }
    return resultMap.getOrDefault(0, 0);

  }

  public static void main(String[] args){
    Prob454 prob454 = new Prob454();
    int [] A = new int[]{1, 2};
    int [] B = new int[]{-2,-1};
    int [] C = new int[]{-1, 2};
    int [] D = new int[]{ 0, 2};
    System.out.println(prob454.fourSumCount(A, B, C, D));
  }
}
