package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 11/16/17.
 */
public class Prob547 {
//  public int findCircleNum(int[][] M) {
//    Map<Integer, Integer> map = new HashMap<>();
//    for(int i = 0; i < M.length; i++){
//      for(int j = 0; j < M.length; j++){
//        Integer iCircle = map.get(i);
//        Integer jCircle = map.get(j);
//        if(iCircle != null && jCircle != null){
//          if(iCircle != jCircle){
//            if(i > j) map.put(i, jCircle);
//            else map.put(j, iCircle);
//          }
//        } else if(iCircle == null && jCircle == null){
//            if(i > j) {
//              map.put(j, j);
//              map.put(i, j);
//            }
//            else {
//              map.put(j, i);
//              map.put(i, i);
//            }
//        } else if(iCircle == null){
//          if(i > j) {
//            map.put(i, j);
//          }
//          else {
//            map.put(i, i);
//            map.put(j, i);
//          }
//        } else {
//          if(i > j) {
//            map.put(i, j);
//            map.put(j, j);
//          }
//          else {
//            map.put(i, i);
//            map.put(j, j);
//          }
//        }
//      }
//    }
//  }
}
